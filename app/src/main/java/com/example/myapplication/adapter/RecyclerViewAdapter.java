package com.example.myapplication.adapter;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.model.Contact;
//import com.example.myapplication.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.viewholder>{
    ArrayList<Contact> contactsList;
    Context context;
    public RecyclerViewAdapter(Context ct, ArrayList<Contact> contactsList){
        context = ct;
        this.contactsList = contactsList;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row,parent,false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        holder.name.setText(contactsList.get(position).getContactName());
        holder.contact.setText(contactsList.get(position).getContactNumber());
    }

    @Override
    public int getItemCount() {
        return contactsList.size();
    }

    public class viewholder extends RecyclerView.ViewHolder{

        TextView name;
        TextView contact;
        public viewholder(@NonNull View itemView) {

            super(itemView);
            name = itemView.findViewById(R.id.name);
            contact = itemView.findViewById(R.id.contact);

        }
    }
}
