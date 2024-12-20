package com.example.mycircle;

import android.os.Bundle;
import android.widget.CalendarView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mycircle.R;
import com.example.mycircle.adapters.EventAdapter;
import com.example.mycircle.models.Event;

import java.util.ArrayList;
import java.util.List;

public class MonthViewFragment extends Fragment {

    private CalendarView calendarView;
    private RecyclerView recyclerView;
    private EventAdapter eventAdapter;
    private List<Event> eventList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_month_view, container, false);

        // Initialize views
        calendarView = view.findViewById(R.id.calendar_view);
        recyclerView = view.findViewById(R.id.recycler_view_events);

        // Setup RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        eventList = new ArrayList<>();
        eventAdapter = new EventAdapter(eventList);
        recyclerView.setAdapter(eventAdapter);

        // Handle calendar date change
        calendarView.setOnDateChangeListener((view1, year, month, dayOfMonth) -> {
            // Fetch and display events for the selected date
            fetchEventsForDate(year, month, dayOfMonth);
        });

        return view;
    }

    private void fetchEventsForDate(int year, int month, int dayOfMonth) {
        // Example: Clear current list and add mock data
        eventList.clear();
        eventList.add(new Event("Event 1", "9:00 AM"));
        eventList.add(new Event("Event 2", "11:00 AM"));
        eventList.add(new Event("Event 3", "1:00 PM"));

        // Notify adapter
        eventAdapter.notifyDataSetChanged();
    }
}
