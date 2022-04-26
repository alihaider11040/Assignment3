package com.example.myapplication.model;

public class Contact {

    // For Model
    private int id;
    private String contactName;
    private String contactNumber;

    public Contact(int id, String contactName, String contactNumber) {
        this.id = id;
        this.contactName = contactName;
        this.contactNumber = contactNumber;
    }

    public int getId() {
        return id;
    }

    public String getContactName() {
        return contactName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    // For Database
    public static final String TABLE_NAME = "Contact";
    public static final String COLUMN_ID = "id";
    public static final String CONTACT_NAME = "name";
    public static final String CONTACT_NUMBER = "number";
    public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT DEFAULT 1," + CONTACT_NAME + " TEXT," + CONTACT_NUMBER + " TEXT UNIQUE)";
}