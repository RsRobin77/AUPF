package com.daffodil.varsity.aupf.fragment;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.daffodil.varsity.aupf.R;
import com.daffodil.varsity.aupf.adapter.GalleryAdapter;
import com.daffodil.varsity.aupf.model.Image;
import com.google.android.gms.common.internal.Objects;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class GalleryFragment extends Fragment {

    private Context context;
    private GalleryAdapter adapter;
    private RecyclerView galleryRV;


    public GalleryFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_gallery, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        galleryRV= view.findViewById(R.id.galleryRV);
        galleryRV.setHasFixedSize(true);

        adapter = new GalleryAdapter(getContext(),gatAllImage());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),3);
        galleryRV.setLayoutManager(gridLayoutManager);
        galleryRV.setAdapter(adapter);
    }

    private int[] gatAllImage(){

       int[] images = {R.drawable.image1,
               R.drawable.image2,
               R.drawable.image3,
               R.drawable.image4,
               R.drawable.image5,
               R.drawable.image6,
               R.drawable.image7,
               R.drawable.image8,
               R.drawable.image9,
               R.drawable.image10,
               R.drawable.image11,
               R.drawable.image12,
               R.drawable.image13,
               R.drawable.image14,
               R.drawable.image15,
               R.drawable.image16,
               R.drawable.image17,
               R.drawable.image18,
               R.drawable.image19,
               R.drawable.image20,
               R.drawable.image21,
               R.drawable.image22,
               R.drawable.image23,
               R.drawable.image24,
               R.drawable.image25,
               R.drawable.image26,
               R.drawable.image27,
               R.drawable.image28,
               R.drawable.image29,
               R.drawable.image30,
               R.drawable.image31,
               R.drawable.image32,
               R.drawable.image33,
               R.drawable.image34,
               R.drawable.image35,
               R.drawable.image36,
               R.drawable.image37,
               R.drawable.image38,
               R.drawable.image39,
               R.drawable.image40,
               R.drawable.image41,
               R.drawable.image42,
               R.drawable.image43,
               R.drawable.image44,
               R.drawable.image45,
               R.drawable.image46,
               R.drawable.image47,
               R.drawable.image48,
               R.drawable.image49,
               R.drawable.image50};


      return images;
    }

}
