package com.daffodil.varsity.aupf.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.daffodil.varsity.aupf.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class RideServiceFragment extends Fragment {

    ImageView pathao,uber,download;
    View view;

    public RideServiceFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_ride_service, container, false);

        pathao=view.findViewById(R.id.pathao);
        uber=view.findViewById(R.id.uber);
        download=view.findViewById(R.id.downloadImage);
        Glide.with(getActivity()).load(R.drawable.pathao).into(pathao);
        Glide.with(getActivity()).load(R.drawable.uber).into(uber);
        Glide.with(getActivity()).load(R.drawable.getitonplaystore).into(download);

        return view;
    }

}
