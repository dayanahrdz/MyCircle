package com.example.mycircle;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mycircle.adapters.GroupsAdapter;
import com.example.mycircle.models.Group;

import java.util.ArrayList;
import java.util.List;

public class GroupsFragment extends Fragment {

    private List<Group> groupsList;
    private GroupsAdapter groupsAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_groups, container, false);

        Button createGroupButton = view.findViewById(R.id.create_group_button);
        RecyclerView recyclerView = view.findViewById(R.id.groups_recycler_view);

        // Initialize groups list and adapter
        groupsList = new ArrayList<>();
        groupsAdapter = new GroupsAdapter(groupsList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(groupsAdapter);

        // Add action for "Create Group" button
        createGroupButton.setOnClickListener(v -> {
            // TODO: Implement logic to create a new group
            createGroup("New Group");
        });

        // Fetch groups
        fetchGroups();

        return view;
    }

    private void fetchGroups() {
        // TODO: Implement API call to fetch groups
        // Simulated group data
        groupsList.clear();
        groupsList.add(new Group("Family"));
        groupsList.add(new Group("Friends"));
        groupsList.add(new Group("Work"));
        groupsAdapter.notifyDataSetChanged();
    }

    private void createGroup(String groupName) {
        // TODO: Implement API call to create a group
        groupsList.add(new Group(groupName));
        groupsAdapter.notifyItemInserted(groupsList.size() - 1);
    }
}



