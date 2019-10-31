package com.daffodil.varsity.aupf.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.daffodil.varsity.aupf.model.Partner;
import com.daffodil.varsity.aupf.R;

import java.util.List;

public class PartnersAdapter extends RecyclerView.Adapter<PartnersAdapter.PartnerViewHolder> {

   private Context context;
   private List<Partner> partnerList;

    public PartnersAdapter(Context context, List<Partner> partnerList) {
        this.context = context;
        this.partnerList = partnerList;
    }

    @NonNull
    @Override
    public PartnerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_partners,parent,false);
        return new PartnerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PartnerViewHolder holder, int position) {
        holder.partnerC_Name.setText(partnerList.get(position).getPartnerName());
        holder.logoView.setImageResource(partnerList.get(position).getPartnerLogo());

    }

    @Override
    public int getItemCount() {
        return partnerList.size();
    }

    public class PartnerViewHolder extends RecyclerView.ViewHolder {

       private ImageView logoView;
       private TextView partnerC_Name;
       public PartnerViewHolder(@NonNull View itemView) {
           super(itemView);

           logoView = itemView.findViewById(R.id.row_partnersC_Logo);
           partnerC_Name = itemView.findViewById(R.id.row_partnersC_Name);
       }
   }
}
