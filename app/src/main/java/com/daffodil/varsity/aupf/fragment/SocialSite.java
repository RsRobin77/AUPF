package com.daffodil.varsity.aupf.fragment;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.daffodil.varsity.aupf.R;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * A simple {@link Fragment} subclass.
 */
public class SocialSite extends Fragment {


    public SocialSite() {
        // Required empty public constructor
    }

    View rootview;
    CircleImageView fb,youtube,linkedin;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview= inflater.inflate(R.layout.fragment_social_site, container, false);
        fb=rootview.findViewById(R.id.facebook);
        youtube=rootview.findViewById(R.id.youtube);
        linkedin=rootview.findViewById(R.id.linked_in);


        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.fb.com/ictcarnival/"));
                    startActivity(intent);
                } catch(Exception e) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/ictcarnival/")));
                }
            }
        });

        youtube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                try
                {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("https://www.youtube.com/playlist?list=PLEDkBrWlI0pSKCJUzFbifcVtwSQwdT1ej"));
                    startActivity(intent);
                }
                catch (Exception e)
                {
                    startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.youtube.com/playlist?list=PLEDkBrWlI0pSKCJUzFbifcVtwSQwdT1ej")));
                }

            }
        });

        linkedin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/school/daffodil-international-university/"));
                    startActivity(intent);
                } catch(Exception e) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/school/daffodil-international-university/")));
                }
            }
        });



        return rootview;
    }



}
