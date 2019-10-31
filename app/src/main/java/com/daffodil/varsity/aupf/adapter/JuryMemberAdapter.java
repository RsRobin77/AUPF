package com.daffodil.varsity.aupf.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.daffodil.varsity.aupf.R;
import com.daffodil.varsity.aupf.model.JuryMember;
import com.daffodil.varsity.aupf.model.JuryMemberItemClick;

import java.util.List;

public class JuryMemberAdapter extends RecyclerView.Adapter<JuryMemberAdapter.JuryMemberVH> {

    private Context context;
    private List<JuryMember> juryMemberList;
    private JuryMemberItemClick juryMemberItemClick;

    public JuryMemberAdapter(Context context, List<JuryMember> juryMemberList) {
        this.context = context;
        this.juryMemberList = juryMemberList;
    }

    @NonNull
    @Override
    public JuryMemberVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.jury_member_item, parent, false);
        return new JuryMemberVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JuryMemberVH holder, int position) {
        JuryMember member = juryMemberList.get(position);

        Glide.with(context).load(member.getAvatar()).circleCrop().into(holder.avatar);
        holder.name.setText(member.getName());
        holder.designation.setText(member.getDesignation());

    }

    @Override
    public int getItemCount() {
        return juryMemberList.size();
    }

    public void setJuryMemberItemClick(JuryMemberItemClick juryMemberItemClick) {
        this.juryMemberItemClick = juryMemberItemClick;
    }

    public class JuryMemberVH extends RecyclerView.ViewHolder {

        private TextView name;
        private TextView designation;
        private ImageView avatar;

        public JuryMemberVH(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.jury_member_name);
            designation = itemView.findViewById(R.id.jury_member_designation);
            avatar = itemView.findViewById(R.id.jury_member_avatar);

            itemView.setOnClickListener(v -> {
                if (juryMemberItemClick != null) {
                    if (RecyclerView.NO_POSITION != getAdapterPosition()) {
                        juryMemberItemClick.itemClick(juryMemberList.get(getAdapterPosition()));
                    }
                }

            });
        }
    }
}
