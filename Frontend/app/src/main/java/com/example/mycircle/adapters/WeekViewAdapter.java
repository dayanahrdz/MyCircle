package com.example.mycircle.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mycircle.R;
import com.example.mycircle.models.ScheduleItem;

import java.util.List;

public class WeekViewAdapter extends RecyclerView.Adapter<WeekViewAdapter.WeekViewHolder> {

    private final List<ScheduleItem> weekScheduleItems;

    public WeekViewAdapter(List<ScheduleItem> weekScheduleItems) {
        this.weekScheduleItems = weekScheduleItems;
    }

    @NonNull
    @Override
    public WeekViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_schedule, parent, false);
        return new WeekViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WeekViewHolder holder, int position) {
        ScheduleItem item = weekScheduleItems.get(position);
        holder.titleTextView.setText(item.getTitle());
        holder.timeTextView.setText(item.getTime());
    }

    @Override
    public int getItemCount() {
        return weekScheduleItems.size();
    }

    static class WeekViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView;
        TextView timeTextView;

        public WeekViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.schedule_title);
            timeTextView = itemView.findViewById(R.id.schedule_time);
        }
    }
}
