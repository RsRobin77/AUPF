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

       int[] images = {};


      return images;
    }

}
