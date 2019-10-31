package com.daffodil.varsity.aupf.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.daffodil.varsity.aupf.R;
import com.daffodil.varsity.aupf.fragment.SpeakerBottomDialog;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class SpeakerAdapter extends RecyclerView.Adapter<SpeakerAdapter.MyAdapter> {

    String[] name,title,bio;
    int[] image;
    Activity context;


    public SpeakerAdapter(Activity context,String[] name, String[] title, int[] image, String[] bio) {
        this.name = name;
        this.title = title;
        this.image = image;
        this.context=context;
        this.bio=bio;
    }

    @NonNull
    @Override
    public MyAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_speaker,parent,false);

        return new MyAdapter(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyAdapter holder, final int position) {

        Glide.with(context).load(image[position]).into(holder.proImage);
        holder.proName.setText(name[position]);
        holder.proTitle.setText(title[position]);


        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetDialogFragment bottomSheetDialogFragment = new SpeakerBottomDialog();
                bottomSheetDialogFragment=SpeakerBottomDialog.newInstance(image[position],name[position],title[position],bio[position]);
                bottomSheetDialogFragment.show(((FragmentActivity)context).getSupportFragmentManager(), bottomSheetDialogFragment.getTag());


            }
        });
    }

    @Override
    public int getItemCount() {
        return name.length;
    }

    public class MyAdapter extends RecyclerView.ViewHolder{

        CircleImageView proImage;
        TextView proName,proTitle;
        LinearLayout layout;
        public MyAdapter(@NonNull View itemView) {
            super(itemView);
            //find component from item speaker
            try {

                proImage=itemView.findViewById(R.id.speaker_image);
                proName=itemView.findViewById(R.id.speaker_name);
                proTitle=itemView.findViewById(R.id.speaker_title);
                layout=itemView.findViewById(R.id.linearlayout);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
