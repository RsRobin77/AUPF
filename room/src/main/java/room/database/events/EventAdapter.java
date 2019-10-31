package room.database.events;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import room.database.R;

public class EventAdapter extends ListAdapter<DailyEvent, EventAdapter.EventViewHolder> {


    private static final DiffUtil.ItemCallback<DailyEvent> DIFF_CALLBACK = new DiffUtil.ItemCallback<DailyEvent>() {
        @Override
        public boolean areItemsTheSame(@NonNull DailyEvent oldItem, @NonNull DailyEvent newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull DailyEvent oldItem, @NonNull DailyEvent newItem) {
            return oldItem.getEvent().equals(newItem.getEvent()) &&
                    oldItem.getStartTime().equals(newItem.getStartTime()) &&
                    oldItem.getEndTime().equals(newItem.getEndTime());
        }
    };

    public EventAdapter() {
        super(DIFF_CALLBACK);
    }

    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.daily_event_item, parent, false);
        return new EventViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull EventViewHolder holder, int position) {
        int setOfColors[] = {Color.parseColor("#f44336"),
                Color.parseColor("#9c27b0"),
                Color.parseColor("#e57373"),
                Color.parseColor("#d32f2f"),
                Color.parseColor("#ad1457"),
                Color.parseColor("#673ab7"),
                Color.parseColor("#880e4f"),
                Color.parseColor("#673ab7"),
                Color.parseColor("#42a5f5"),
                Color.parseColor("#42a5f5"),
                Color.parseColor("#D81B60")};

        DailyEvent event = getItem(position);

        int rand = (int) (Math.random() * 10);
        holder.view.getBackground().setColorFilter(setOfColors[rand], PorterDuff.Mode.SRC_ATOP);

        holder.time.setText(event.getStartTime() + event.getEndTime());
        holder.event.setText(event.getEvent());
    }

    public class EventViewHolder extends RecyclerView.ViewHolder {

        private View view;
        private TextView event;
        private TextView time;

        public EventViewHolder(@NonNull View itemView) {
            super(itemView);

            view = itemView.findViewById(R.id.view);
            event = itemView.findViewById(R.id.event_name);
            time = itemView.findViewById(R.id.event_time);

        }
    }
}
