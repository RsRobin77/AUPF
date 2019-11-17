package com.daffodil.varsity.aupf.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.daffodil.varsity.aupf.R;

import java.util.List;

public class NearbyAdapter extends RecyclerView.Adapter<NearbyAdapter.NearbyHolder> {
    private List<String> locations;

    public NearbyAdapter(List<String> locations) {
        this.locations = locations;
    }

    @NonNull
    @Override
    public NearbyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_nearby, parent, false);
        return new NearbyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NearbyHolder holder, int position) {
        holder.location.setText(locations.get(position).trim());
    }

    @Override
    public int getItemCount() {
        return locations.size();
    }

    public class NearbyHolder extends RecyclerView.ViewHolder {
        TextView location;

        public NearbyHolder(@NonNull View itemView) {
            super(itemView);

            location = itemView.findViewById(R.id.location_name);
        }
    }
}
