package com.example.mycircle;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mycircle.adapters.FriendsAdapter;
import com.example.mycircle.models.Friend;

import java.util.ArrayList;
import java.util.List;

public class AddFriendsFragment extends Fragment {

    private FriendsAdapter friendsAdapter;
    private List<Friend> friendsList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_friends, container, false);

        SearchView searchView = view.findViewById(R.id.search_view);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view_friends);

        // Initialize friends list and adapter
        friendsList = new ArrayList<>();
        friendsAdapter = new FriendsAdapter(friendsList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(friendsAdapter);

        // Implement search functionality
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchFriends(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        return view;
    }

    private void searchFriends(String query) {
        // TODO: Implement API call to fetch friends based on the query
        // For now, let's simulate some results
        friendsList.clear();
        friendsList.add(new Friend("John Doe", "john.doe@example.com"));
        friendsList.add(new Friend("Jane Smith", "jane.smith@example.com"));
        friendsAdapter.notifyDataSetChanged();
    }
}
