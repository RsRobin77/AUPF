package room.database.freshroom;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import room.database.R;

public class FreshRoomAdapter extends ListAdapter<FreshRoom, FreshRoomAdapter.FreshRoomHolder> {
    private static final String TAG = "FreshRoomAdapter";

    private static final DiffUtil.ItemCallback<FreshRoom> DIFF_CALLBACK = new DiffUtil.ItemCallback<FreshRoom>() {
        @Override
        public boolean areItemsTheSame(@NonNull FreshRoom oldItem, @NonNull FreshRoom newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull FreshRoom oldItem, @NonNull FreshRoom newItem) {
            return oldItem.getBuilding().equals(newItem.getBuilding()) &&
                    oldItem.getFloor().equals(newItem.getFloor());
        }
    };

    public FreshRoomAdapter() {
        super(DIFF_CALLBACK);
    }

    @NonNull
    @Override
    public FreshRoomHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.fresh_room_item, parent, false);
        return new FreshRoomHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull FreshRoomHolder holder, int position) {
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

        FreshRoom freshRoom = getItem(position);
        holder.building.setText(freshRoom.getBuilding());
        holder.floor.setText(freshRoom.getFloor());
    }

    class FreshRoomHolder extends RecyclerView.ViewHolder {
        private View view;

        private TextView building;
        private TextView floor;

        public FreshRoomHolder(@NonNull View itemView) {
            super(itemView);

            view = itemView.findViewById(R.id.view);
            building = itemView.findViewById(R.id.volunteer_name);
            floor = itemView.findViewById(R.id.cell_number);
        }
    }
}
