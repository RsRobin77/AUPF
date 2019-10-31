package com.daffodil.varsity.aupf.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.daffodil.varsity.aupf.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * A simple {@link Fragment} subclass.
 */
public class VenueMapFragment extends Fragment implements OnMapReadyCallback {


    GoogleMap map;
    View view;


    public VenueMapFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_venue_map, container, false);

        SupportMapFragment mapFragment = (SupportMapFragment)
                this.getChildFragmentManager()
                        .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        return view;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map=googleMap;
        LatLng Diu =new LatLng(23.8766763,90.3205282);
        map.addMarker(new MarkerOptions().position(Diu).title("Sadhinata Hall, DIU"));
        map.moveCamera(CameraUpdateFactory.newLatLng(Diu));
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(Diu,17));


    }
}
