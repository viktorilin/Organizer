package com.example.asus.organizer;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Asus on 01.08.2017.
 */

public class ContactAdapterRecycleView
        extends RecyclerView.Adapter<ContactAdapterRecycleView.CardViewHolder> {

    List<Contact> contacts;

    public ContactAdapterRecycleView(List<Contact> list) {
        this.contacts = list;
    }

    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_cards_layout,parent,false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CardViewHolder holder, int position) {
        Contact contact = contacts.get(position);
        holder.contactNameTextView.setText(contact.getName());
        holder.contactNumberOfPhoneTextView.setText(contact.getNumberOfPhone());
        holder.contactImageView.setImageResource(contact.getImage());
    }
    public void removeItem(int position){
        contacts.remove(position);
        notifyItemChanged(position);
    }


    @Override
    public int getItemCount() {
        return contacts.size();
    }



    public static class CardViewHolder extends RecyclerView.ViewHolder{
        protected TextView contactNameTextView;
        protected TextView contactNumberOfPhoneTextView;
        protected ImageView contactImageView;

        public CardViewHolder(View itemView) {
            super(itemView);
            contactNameTextView = (TextView) itemView.findViewById(R.id.contact_name);
            contactNumberOfPhoneTextView = (TextView) itemView.findViewById(R.id.contact_number);
            contactImageView = (ImageView) itemView.findViewById(R.id.contact_photo);
        }


    }
}
