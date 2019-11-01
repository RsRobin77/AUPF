package com.daffodil.varsity.aupf.adapter;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.daffodil.varsity.aupf.R;
import com.daffodil.varsity.aupf.model.EventSegments;

import java.util.List;

public class EventSegmentAdapter extends RecyclerView.Adapter<EventSegmentAdapter.EventsHolder> {

    private List<EventSegments> eventSegmentsList;

    public EventSegmentAdapter(List<EventSegments> eventSegmentsList) {
        this.eventSegmentsList = eventSegmentsList;
    }

    @NonNull
    @Override
    public EventsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_segment_item, parent, false);
        return new EventsHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventsHolder holder, int position) {
        int setOfColors[] = {Color.parseColor("#f44336"),
                Color.parseColor("#9c27b0"),
                Color.parseColor("#e57373"),
                Color.parseColor("#d32f2f"),
                Color.parseColor("#ad1457"),
                Color.parseColor("#673ab7"),
                Color.parseColor("#880e4f"),
                Color.parseColor("#673ab7"),
                Color.parseColor("#42a5f5"),
                Color.parseColor("#1e88e5")};

        int rand = (int) (Math.random() * 10);
        holder.view.getBackground().setColorFilter(setOfColors[rand], PorterDuff.Mode.SRC_ATOP);

        EventSegments eventSegments = eventSegmentsList.get(position);

        holder.eventName.setText(eventSegments.getEventName());
        holder.eventDate.setText(eventSegments.getEventDate());

    }

    @Override
    public int getItemCount() {
        return eventSegmentsList.size();
    }

    class EventsHolder extends RecyclerView.ViewHolder {
        private View view;

        private TextView eventName;
        private TextView eventDate;

        public EventsHolder(@NonNull View itemView) {
            super(itemView);

            view = itemView.findViewById(room.database.R.id.view);
            eventName = itemView.findViewById(room.database.R.id.event_name);
            eventDate = itemView.findViewById(room.database.R.id.event_date);
        }
    }
}
