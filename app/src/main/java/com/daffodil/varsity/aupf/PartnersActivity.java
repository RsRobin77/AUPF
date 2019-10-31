package com.daffodil.varsity.aupf;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.daffodil.varsity.aupf.adapter.PartnersAdapter;
import com.daffodil.varsity.aupf.model.Partner;

import java.util.ArrayList;

public class PartnersActivity extends AppCompatActivity {

    private RecyclerView partnerRV;
    private PartnersAdapter adapter;
    private LinearLayoutManager LayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partners);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Partners");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        }

        partnerRV = findViewById(R.id.partnersRV);

        adapter = new PartnersAdapter(this, getPartner());
        LayoutManager = new LinearLayoutManager(this);
        partnerRV.setLayoutManager(LayoutManager);
        partnerRV.setAdapter(adapter);


    }


    private ArrayList<Partner> getPartner() {
        ArrayList<Partner> partnerList = new ArrayList<>();

        partnerList.add(new Partner("Daffodil Group", R.drawable.partner_group));
        partnerList.add(new Partner("Daffodil International University", R.drawable.partner_diu));
        partnerList.add(new Partner("Daffodil Educational Network", R.drawable.partner_dia_bcs));
        partnerList.add(new Partner("Daffodil Computer Limited", R.drawable.partner_dcl));
        partnerList.add(new Partner("Daffodil Software Limited", R.drawable.partner_dsl));
        partnerList.add(new Partner("Skill Jobs", R.drawable.partner_sk));
        partnerList.add(new Partner("Apnare.com", R.drawable.partner_apnare));
        partnerList.add(new Partner("Bangladesh Skill Development", R.drawable.partner_bsdi));
        partnerList.add(new Partner("Daffodil Polytechnic Institute", R.drawable.partner_dpi));
        partnerList.add(new Partner("Daffodil International College", R.drawable.partner_dic));
        partnerList.add(new Partner("Daffodil Technical Institute", R.drawable.partner_dti));

        return partnerList;

    }
}
