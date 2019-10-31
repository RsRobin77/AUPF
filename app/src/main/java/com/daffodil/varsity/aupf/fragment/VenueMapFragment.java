package com.daffodil.varsity.aupf.fragment;


import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
public class VenueMapFragment extends Fragment {


    GoogleMap map;
    View view;
    private WebView webView;



    public VenueMapFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_venue_map, container, false);

//        SupportMapFragment mapFragment = (SupportMapFragment)
//                this.getChildFragmentManager()
//                        .findFragmentById(R.id.map);
//        mapFragment.getMapAsync(this);



        return view;
    }

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        webView = view.findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://www.google.com/url?q=" +
                "https://drive.google.com/open?" +
                "id%3D1Fcd0nCuGdrpEhXnFK8Mj2-WcTCHxUogO%26usp%3" +
                "Dsharing&sa=D&source=hangouts&ust=1572418303631000&usg=AFQjCNG2_k4AwSEsqrGjmmvVIB_FmPnkJg");

        webView.saveWebArchive("");
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        webView.setWebChromeClient(new WebChromeClient(){

            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
            }

            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
//                progressBar.setVisibility(View.GONE);

            }

            @Override
            public void onReceivedIcon(WebView view, Bitmap icon) {
                super.onReceivedIcon(view, icon);
//                progressBar.setVisibility(View.GONE);


            }
        });
    }

//    @Override
//    public void onMapReady(GoogleMap googleMap) {
//        map=googleMap;
//        LatLng Diu =new LatLng(23.8766763,90.3205282);
//        map.addMarker(new MarkerOptions().position(Diu).title("Sadhinata Hall, DIU"));
//        map.moveCamera(CameraUpdateFactory.newLatLng(Diu));
//        map.animateCamera(CameraUpdateFactory.newLatLngZoom(Diu,17));
//
//
//    }
}
