package com.daffodil.varsity.aupf.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.daffodil.varsity.aupf.R;
import com.daffodil.varsity.aupf.model.Image;

import java.util.List;

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.GalleryViewHolder> {

    private Context context;
    private int[] imageList;

    public GalleryAdapter(Context context, int[] imageList) {
        this.context = context;
        this.imageList = imageList;
    }

    @NonNull
    @Override
    public GalleryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.gallery_image_view, parent, false);
        return new GalleryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GalleryViewHolder holder, int position) {
        Glide.with(context)
                .load(imageList[position])
                .optionalCenterCrop()
                .into(holder.gellaryImage);
    }

    @Override
    public int getItemCount() {
        return imageList.length;
    }


    public class GalleryViewHolder extends RecyclerView.ViewHolder {
        private ImageView gellaryImage;

        public GalleryViewHolder(@NonNull View itemView) {
            super(itemView);
            gellaryImage = itemView.findViewById(R.id.row_image);
        }
    }
}
