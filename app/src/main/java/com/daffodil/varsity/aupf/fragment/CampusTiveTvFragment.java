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
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.daffodil.varsity.aupf.R;
import com.google.android.gms.maps.GoogleMap;

public class CampusTiveTvFragment extends Fragment {

    GoogleMap map;
    View view;
    private WebView webView;
    private ProgressBar progressBar;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_campus_tive_tv, container, false);

        progressBar = view.findViewById(R.id.progressbar);
        progressBar.setMax(100);

        return view;
    }

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        webView = view.findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("http://www.campustv.ac/");

        webView.saveWebArchive("");
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
            }

            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
                progressBar.setVisibility(View.GONE);

            }

            @Override
            public void onReceivedIcon(WebView view, Bitmap icon) {
                super.onReceivedIcon(view, icon);
                progressBar.setVisibility(View.GONE);


            }
        });
    }
}