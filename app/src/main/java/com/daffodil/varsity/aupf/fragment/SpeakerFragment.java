package com.daffodil.varsity.aupf.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.daffodil.varsity.aupf.R;
import com.daffodil.varsity.aupf.adapter.JuryMemberAdapter;
import com.daffodil.varsity.aupf.adapter.SpeakerAdapter;
import com.daffodil.varsity.aupf.model.JuryMember;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class SpeakerFragment extends Fragment {

    private RecyclerView recyclerView;
    private View view;
    private RecyclerView.Adapter adapter;
    private String[] speakerName = {"Dr. Md. Sabur Khan", "Dr. Yousuf Mahbubul Islam", "Dr. S.M. Mahbub Ul Haque Majumder", "Mohammad Nuruzzaman", "Mr. Mohamed Emran Hossain", "Mr. Mominul Haque Majumder", "Professor Dr. Engr. A. K. M. Fazlul Hoque", "Professor Dr. Mostafa Kamal", "Prof. Dr. Syed Akhter Hossain", "Dr. Touhid Bhuiyan", "Dr. Shaikh Muhammad Allayear",
            "Mohammed Shakhawat Hossain", "K. M Hasan Ripon", "Rathindra Nath Das"};
    private String[] speakerTitle = {"FOUNDER & CHAIRMAN", "VICE CHANCELLOR - DIU", "PRO-VICE CHANCELLOR - DIU", "CEO - DAFFODIL FAMILY", "COO - DAFFODIL FAMILY", "TREASURER-DIU", "REGISTRAR - DIU", "DEAN - PERMANENT CAMPUS", "HEAD OF CSE - DIU", "HEAD OF SWE - DIU", "HEAD OF MCT - DIU", "PRINCIPAL - DIIT",
            "Adviser BSDI", "Executive Director,  DIPTI & DTI"};

    private int[] speakerImage = {R.drawable.sabur_khan, R.drawable.mahbubul_islam, R.drawable.mahbub_ul_haque_majumder, R.drawable.muhammad_nuruzzaman, R.drawable.mohamed_emran_hossain, R.drawable.mominul_haque_majumder, R.drawable.akm_fazlul_hoque, R.drawable.mostofa_kamal, R.drawable.syed_akhter_hossain, R.drawable.touhid_bhuiyan, R.drawable.shaikh_muhammad_allayear, R.drawable.mohammad_shakhawat_hossain,
            R.drawable.k_m_hasan_ripon, R.drawable.das};


    private String[] speakerBiography;

    public SpeakerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_speaker, container, false);

        ImageView carnivalLogo = view.findViewById(R.id.venue);

        Glide.with(this).load(R.drawable.ic_parmanent_campus).into(carnivalLogo);

        speakerBiography = getResources().getStringArray(R.array.speakers_biography);

        LinearLayoutManager layoutManager
                = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);

        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new SpeakerAdapter(getActivity(), speakerName, speakerTitle, speakerImage, speakerBiography);
        recyclerView.setAdapter(adapter);


        RecyclerView juryMembers = view.findViewById(R.id.recycler_view_jury_board);

        List<JuryMember> juryMemberList = new ArrayList<>();

        juryMemberList.add(new JuryMember(R.drawable.alauddin,
                "Mr. Alauddin Azad",
                "CTO, Skill Jobs\n",
                "cto@skill.jobs.com"));

        juryMemberList.add(new JuryMember(R.drawable.karim,
                "Mr. Md. Rashed Karim",
                "Deputy Director (IT)\n",
                "software@daffodilvarsity.edu.bd\n" +
                        "Ext: 157\n" +
                        "Daffodil Tower-04 (Main Campus)"));

        juryMemberList.add(new JuryMember(R.drawable.mujahid,
                "Mr. Md. Mujahidul Islam Khan",
                "Assistant Director (Software)\n",
                "mujahid@daffodilvarsity.edu.bd\n" +
                        "Cell: +8801991195562\n" +
                        "DF-Tower (Main Campus)"));

        juryMemberList.add(new JuryMember(R.drawable.jafar,
                "Jafar Ahmed Patwary",
                "Deputy General Manager (DCL)\n",
                "Ph:     (+88 02) 9116600\n" +
                        "Cell: (+88) 01713493161\n" +
                        "Fax:  (+88 02)  58153690\n" +
                        "Skype : tojafar@live.com," +
                        "\nWechat: J01713493161\n" +
                        "Web:   www.daffodil-bd.com"));

        juryMemberList.add(new JuryMember(R.drawable.reaz,
                "Mr Reaz Uddin Ahmed (Emon)",
                "Business Development Manager (DCL)\n",
                "64/3 Lake Circus, Kalabagan\n" +
                        "Dhaka-1205.\n" +
                        "Phone: +88 02 9116600\n" +
                        "Cell: +88 01713 493026\n" +
                        "Website: www.daffodil-bd.com"));

        juryMemberList.add(new JuryMember(R.drawable.firoz,
                "Sm Firoz Ahmed",
                "Assistant IT Officer (DIU)\n",
                "Cell +8801991195522, +8801718689105 "));

        JuryMemberAdapter juryMemberAdapter = new JuryMemberAdapter(getContext(), juryMemberList);

        juryMembers.hasFixedSize();
        juryMembers.setLayoutManager(new LinearLayoutManager(getContext(),
                LinearLayoutManager.HORIZONTAL,
                false)
        );

        juryMembers.setAdapter(juryMemberAdapter);

        juryMemberAdapter.setJuryMemberItemClick(info -> {
            AlertDialog.Builder builder1 = new AlertDialog.Builder(getContext());

            builder1.setTitle(info.getName());
            builder1.setMessage(info.getDesignation() + "\n" + info.getInfo());
            builder1.setCancelable(true);

            builder1.setPositiveButton(
                    "Ok",
                    (dialog, id) -> dialog.cancel());

            AlertDialog alert11 = builder1.create();
            alert11.show();
        });

        return view;
    }

}
