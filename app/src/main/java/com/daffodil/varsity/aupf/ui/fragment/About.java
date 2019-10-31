package com.daffodil.varsity.aupf.ui.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.daffodil.varsity.aupf.R;

public class About extends Fragment {


    @SuppressLint("SetTextI18n")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_about, container, false);

        ImageView carnivalLogo = view.findViewById(R.id.carnival_logo_about);
        Glide.with(this).load(R.drawable.ict_carnival_logo).into(carnivalLogo);

        return view;
    }


}
