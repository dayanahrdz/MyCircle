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

import com.example.mycircle.adapters.ScheduleAdapter;
import com.example.mycircle.models.ScheduleItem;

import java.util.ArrayList;
import java.util.List;

public class ScheduleFragment extends Fragment {

    private List<ScheduleItem> scheduleList;
    private ScheduleAdapter scheduleAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_schedule, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recycler_view_schedule);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        scheduleList = new ArrayList<>();
        scheduleAdapter = new ScheduleAdapter(scheduleList);
        recyclerView.setAdapter(scheduleAdapter);

        Button addScheduleItemButton = view.findViewById(R.id.add_schedule_item);
        addScheduleItemButton.setOnClickListener(v -> addScheduleItem());

        return view;
    }

    private void addScheduleItem() {
        scheduleList.add(new ScheduleItem("New Event", "Time"));
        scheduleAdapter.notifyItemInserted(scheduleList.size() - 1);
    }
}




