package com.daffodil.varsity.aupf.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.daffodil.varsity.aupf.R;
import com.daffodil.varsity.aupf.model.Participant;

import java.util.ArrayList;

public class ParticipantAdapter extends RecyclerView.Adapter<ParticipantAdapter.ParticipantHolder> {
    private ArrayList<Participant> participantArrayList;

    public ParticipantAdapter(ArrayList<Participant> participantArrayList) {
        this.participantArrayList = participantArrayList;
    }

    @NonNull
    @Override
    public ParticipantHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.participant_item_list, parent, false);

        return new ParticipantHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ParticipantHolder holder, int position) {
        Participant participant = participantArrayList.get(position);

        holder.Name.setText(participant.getName());
        holder.Designation.setText(participant.getDesignation());
        holder.Institute.setText("Institute: " + participant.getInstitute());
        holder.Country.setText("Country: " + participant.getCountry());
        holder.Email.setText("Email: " + participant.getEmail());
    }

    @Override
    public int getItemCount() {
        return participantArrayList.size();
    }

    public class ParticipantHolder extends RecyclerView.ViewHolder {
        TextView Name, Designation, Institute, Country, Email;

        public ParticipantHolder(@NonNull View itemView) {
            super(itemView);

            Name = itemView.findViewById(R.id.name);
            Designation = itemView.findViewById(R.id.designation);
            Institute = itemView.findViewById(R.id.institute);
            Country = itemView.findViewById(R.id.country);
            Email = itemView.findViewById(R.id.email);
        }
    }
}
