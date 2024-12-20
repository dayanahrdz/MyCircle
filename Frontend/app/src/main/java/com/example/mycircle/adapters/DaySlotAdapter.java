package com.example.mycircle.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mycircle.R;
import com.example.mycircle.models.DaySlot;

import java.util.List;

public class DaySlotAdapter extends RecyclerView.Adapter<DaySlotAdapter.DaySlotViewHolder> {

    private final List<DaySlot> daySlotList;

    public DaySlotAdapter(List<DaySlot> daySlotList) {
        this.daySlotList = daySlotList;
    }

    @NonNull
    @Override
    public DaySlotViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_day_slot, parent, false);
        return new DaySlotViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DaySlotViewHolder holder, int position) {
        DaySlot slot = daySlotList.get(position);
        holder.timeTextView.setText(slot.getTime());
        holder.descriptionTextView.setText(slot.getDescription());
    }

    @Override
    public int getItemCount() {
        return daySlotList.size();
    }

    static class DaySlotViewHolder extends RecyclerView.ViewHolder {
        TextView timeTextView;
        TextView descriptionTextView;

        public DaySlotViewHolder(@NonNull View itemView) {
            super(itemView);
            timeTextView = itemView.findViewById(R.id.text_view_time);
            descriptionTextView = itemView.findViewById(R.id.text_view_description);
        }
    }
}
