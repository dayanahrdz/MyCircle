package com.example.mycircle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class FamilyMemberAdapter extends RecyclerView.Adapter<FamilyMemberAdapter.ViewHolder> {

    private List<FamilyMember> familyMembers;

    public FamilyMemberAdapter(List<FamilyMember> familyMembers) {
        this.familyMembers = familyMembers;
    }

    public List<FamilyMember> getFamilyMembers() {
        return familyMembers;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_family_member, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        FamilyMember member = familyMembers.get(position);
        holder.nameText.setText(member.getName());
        holder.statusText.setText(member.getStatus());
        holder.lastSeenText.setText("Since " + member.getLastSeen());
        holder.travelTimeText.setText(member.getTravelTime());

        // TODO: Load profile picture using Glide or similar library
        holder.profileImage.setImageResource(R.drawable.default_profile);
    }

    @Override
    public int getItemCount() {
        return familyMembers.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView profileImage;
        TextView nameText;
        TextView statusText;
        TextView lastSeenText;
        TextView travelTimeText;
        ImageView transportIcon;
        ImageView homeIcon;

        ViewHolder(View itemView) {
            super(itemView);
            profileImage = itemView.findViewById(R.id.profile_image);
            nameText = itemView.findViewById(R.id.name_text);
            statusText = itemView.findViewById(R.id.status_text);
            lastSeenText = itemView.findViewById(R.id.last_seen_text);
            travelTimeText = itemView.findViewById(R.id.travel_time_text);
            transportIcon = itemView.findViewById(R.id.transport_icon);
            homeIcon = itemView.findViewById(R.id.home_icon);
        }
    }
}

