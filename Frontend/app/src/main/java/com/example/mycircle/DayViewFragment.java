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

import com.example.mycircle.R;
import com.example.mycircle.adapters.DaySlotAdapter;
import com.example.mycircle.models.DaySlot;

import java.util.ArrayList;
import java.util.List;

public class DayViewFragment extends Fragment {

    private RecyclerView recyclerView;
    private DaySlotAdapter adapter;
    private List<DaySlot> daySlotList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_day_view, container, false);

        // Initialize RecyclerView
        recyclerView = view.findViewById(R.id.recycler_view_day_slots);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Initialize data
        daySlotList = new ArrayList<>();
        populateDaySlots();

        // Set up adapter
        adapter = new DaySlotAdapter(daySlotList);
        recyclerView.setAdapter(adapter);

        // Add Slot Button (logic to be implemented)
        view.findViewById(R.id.button_add_slot).setOnClickListener(v -> {
            // Add slot logic here
        });

        return view;
    }

    private void populateDaySlots() {
        // Sample data, replace with actual backend or database call
        daySlotList.add(new DaySlot("9:00 AM", "Meeting with Team"));
        daySlotList.add(new DaySlot("11:00 AM", "Code Review"));
        daySlotList.add(new DaySlot("1:00 PM", "Lunch Break"));
        daySlotList.add(new DaySlot("3:00 PM", "Client Call"));
        daySlotList.add(new DaySlot("5:00 PM", "Wrap Up"));
    }
}

