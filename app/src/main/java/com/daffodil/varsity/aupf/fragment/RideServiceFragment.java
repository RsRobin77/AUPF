package com.daffodil.varsity.aupf.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.daffodil.varsity.aupf.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class RideServiceFragment extends Fragment {


    public RideServiceFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ride_service, container, false);
    }

}
