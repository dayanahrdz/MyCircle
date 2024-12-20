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

import com.example.mycircle.adapters.WeekViewAdapter;
import com.example.mycircle.models.ScheduleItem;

import java.util.ArrayList;
import java.util.List;

public class WeekViewFragment extends Fragment {

    private RecyclerView recyclerView;
    private WeekViewAdapter weekViewAdapter;
    private List<ScheduleItem> weekScheduleItems;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_week_view, container, false);

        // Initialize RecyclerView
        recyclerView = view.findViewById(R.id.week_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Initialize data for the week
        weekScheduleItems = new ArrayList<>();
        weekScheduleItems.add(new ScheduleItem("Monday: ", "10:00 AM"));
        weekScheduleItems.add(new ScheduleItem("Tuesday: ", "11:00 AM"));
        weekScheduleItems.add(new ScheduleItem("Wednesday: ", "12:30 PM"));
        weekScheduleItems.add(new ScheduleItem("Thursday: ", "3:00 PM"));
        weekScheduleItems.add(new ScheduleItem("Friday: ", "4:30 PM"));

        // Set up Adapter
        weekViewAdapter = new WeekViewAdapter(weekScheduleItems);
        recyclerView.setAdapter(weekViewAdapter);

        return view;
    }
}
