package com.example.myapplication.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.myapplication.model.Contact;

import java.util.ArrayList;

public class ContactDatabase extends SQLiteOpenHelper {
private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "Assignment_3";

    public ContactDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(Contact.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Contact.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public long insertContact(Contact contact) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(Contact.CONTACT_NAME, contact.getContactName());
        values.put(Contact.CONTACT_NUMBER, contact.getContactNumber());

        long id = db.insert(Contact.TABLE_NAME, null, values);

        db.close();

        return id;
    }

    public ArrayList<Contact> getContacts() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(("SELECT * FROM " + Contact.TABLE_NAME), null);

        if (cursor != null)
            cursor.moveToFirst();

        ArrayList<Contact> contacts = new ArrayList<>();
        while (!cursor.isLast()) {
            contacts.add(new Contact(
                    cursor.getInt(cursor.getColumnIndexOrThrow(Contact.COLUMN_ID)),
                    cursor.getString(cursor.getColumnIndexOrThrow(Contact.CONTACT_NAME)),
                    cursor.getString(cursor.getColumnIndexOrThrow(Contact.CONTACT_NUMBER))));
            cursor.moveToNext();
        }

        cursor.close();

        db.close();

        return contacts;
    }
}
