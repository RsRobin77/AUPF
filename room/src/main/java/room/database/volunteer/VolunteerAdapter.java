package room.database.volunteer;

import android.annotation.SuppressLint;
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

public class VolunteerAdapter extends ListAdapter<Volunteer, VolunteerAdapter.VolunteerHolder> {
    private static final String TAG = "VolunteerAdapter";

    private static final DiffUtil.ItemCallback<Volunteer> DIFF_CALLBACK = new DiffUtil.ItemCallback<Volunteer>() {
        @Override
        public boolean areItemsTheSame(@NonNull Volunteer oldItem, @NonNull Volunteer newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull Volunteer oldItem, @NonNull Volunteer newItem) {
            return oldItem.getVolunteerName().equals(newItem.getVolunteerName()) &&
                    oldItem.getDept().equals(newItem.getDept()) &&
                    oldItem.getMobileNumber().equals(newItem.getMobileNumber()) &&
                    oldItem.getCampus().equals(newItem.getCampus());
        }
    };
    private OnRecyclerViewItemClickListener listener;

    public VolunteerAdapter() {
        super(DIFF_CALLBACK);
    }

    @NonNull
    @Override
    public VolunteerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.volunteer_item, parent, false);
        return new VolunteerHolder(itemView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull VolunteerHolder holder, int position) {
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

        Volunteer volunteer = getItem(position);
        holder.volunteerName.setText(volunteer.getVolunteerName());
        holder.cell.setText(volunteer.getMobileNumber());
        holder.mail.setText(volunteer.getMail());
        holder.studentId.setText(volunteer.getStudentid());

        holder.dept.setText(volunteer.getDept() + " (" + volunteer.getCampus() + ")");
    }


    public Volunteer getVolunteerAt(int position) {
        return getItem(position);
    }

    public void setOnItemClickListener(OnRecyclerViewItemClickListener listener) {
        this.listener = listener;
    }

    class VolunteerHolder extends RecyclerView.ViewHolder {

        private View view;
        private TextView volunteerName;
        private TextView cell;
        private TextView mail;
        private TextView dept;
        private TextView studentId;

        public VolunteerHolder(@NonNull View itemView) {
            super(itemView);

            view = itemView.findViewById(R.id.view);
            volunteerName = itemView.findViewById(R.id.volunteer_name);
            cell = itemView.findViewById(R.id.cell_number);
            mail = itemView.findViewById(R.id.mail);
            dept = itemView.findViewById(R.id.dept);
            studentId = itemView.findViewById(R.id.student_id);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();

                    if (listener != null && position != RecyclerView.NO_POSITION)
                        listener.onItemClick(getItem(position));
                }
            });
        }
    }
}
