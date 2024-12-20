package com.example.mycircle;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mycircle.adapters.ContactsAdapter;
import com.example.mycircle.models.Contact;

import java.util.ArrayList;
import java.util.List;

public class ContactsFragment extends Fragment {

    private RecyclerView recyclerView;
    private ContactsAdapter contactsAdapter;
    private List<Contact> contactList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contacts, container, false);

        // Initialize RecyclerView
        recyclerView = view.findViewById(R.id.recycler_view_contacts);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Initialize Contact List
        contactList = new ArrayList<>();
        contactList.add(new Contact("Alice Johnson", "123-456-7890"));
        contactList.add(new Contact("Bob Smith", "987-654-3210"));
        contactList.add(new Contact("Charlie Brown", "555-555-5555"));

        // Set up Adapter
        contactsAdapter = new ContactsAdapter(contactList);
        recyclerView.setAdapter(contactsAdapter);

        return view;
    }
}
