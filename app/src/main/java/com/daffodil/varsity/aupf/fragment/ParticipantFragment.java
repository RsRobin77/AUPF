package com.daffodil.varsity.aupf.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.daffodil.varsity.aupf.R;
import com.daffodil.varsity.aupf.adapter.ParticipantAdapter;
import com.daffodil.varsity.aupf.model.Participant;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ParticipantFragment extends Fragment {


    public ParticipantFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_participant, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Gson gson = new Gson();

        Type type = new TypeToken<ArrayList<Participant>>() {
        }.getType();

        ArrayList<Participant> participant = gson.fromJson(json(), type);

        RecyclerView recyclerView = view.findViewById(R.id.participant_list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        ParticipantAdapter adapter = new ParticipantAdapter(participant);
        recyclerView.setAdapter(adapter);
    }

    private String json() {
        return "[" +
                "  {\n" +
                "    \"SL\": \"1\",\n" +
                "    \"Name\": \"Mr. Kazi Rafiqul Alam\",\n" +
                "    \"Designation\": \"Chairman\",\n" +
                "    \"Institute\": \"Ahsanullah University of Science and Technology\",\n" +
                "    \"Country\": \"Bangladesh\",\n" +
                "    \"Email\": \"dambgd@gmail.com\",\n" +
                "    \"\": \"\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"SL\": \"2\",\n" +
                "    \"Name\": \"Mr Sarwar Jahan\",\n" +
                "    \"Designation\": \"Founder & Vice-president\",\n" +
                "    \"Institute\": \"Southern University Bangladesh\",\n" +
                "    \"Country\": \"Bangladesh\",\n" +
                "    \"Email\": \"sjahan@southern.edu.bd\",\n" +
                "    \"\": \"\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"SL\": \"3\",\n" +
                "    \"Name\": \"Mr. Abu Yousuf MD Abdullah\",\n" +
                "    \"Designation\": \"Chairman\",\n" +
                "    \"Institute\": \"Northern Uniiversity Bangladesh\",\n" +
                "    \"Country\": \"Bangladesh\",\n" +
                "    \"Email\": \"draymabdullah@yahoo.com\",\n" +
                "    \"\": \"\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"SL\": \"4\",\n" +
                "    \"Name\": \"Mr Dr. Dalem Ch Barman\",\n" +
                "    \"Designation\": \"Vice Chancellor\",\n" +
                "    \"Institute\": \"ASA University Bangladesh(ASAUB)\",\n" +
                "    \"Country\": \"Bangladesh\",\n" +
                "    \"Email\": \"vc@asaub.edu.bd\",\n" +
                "    \"\": \"\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"SL\": \"5\",\n" +
                "    \"Name\": \"Ms. Ishrat Jahan\",\n" +
                "    \"Designation\": \"Professor and Head of Business Administration\",\n" +
                "    \"Institute\": \"Southern University Bangladesh\",\n" +
                "    \"Country\": \"Bangladesh\",\n" +
                "    \"Email\": \"info@southern.edu.bd\",\n" +
                "    \"\": \"\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"SL\": \"6\",\n" +
                "    \"Name\": \"Prof. H M Jahirul Haque\",\n" +
                "    \"Designation\": \" PhD\",\n" +
                "    \"Institute\": \"Vice Chancellor\",\n" +
                "    \"Country\": \"University of Liberal Arts Bangladesh (ULAB)\",\n" +
                "    \"Email\": \"Bangladesh\",\n" +
                "    \"\": \"\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"SL\": \"7\",\n" +
                "    \"Name\": \"Dr. Milan Pagon\",\n" +
                "    \"Designation\": \"Vice Chancellor (acting)\",\n" +
                "    \"Institute\": \"Independent University of Bangladesh \",\n" +
                "    \"Country\": \"Bangladesh\",\n" +
                "    \"Email\": \"mpagon@iub.edu.bd\",\n" +
                "    \"\": \"\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"SL\": \"8\",\n" +
                "    \"Name\": \"Mr. Khandker MD Iftekhar Haider\",\n" +
                "    \"Designation\": \"Treasurer \",\n" +
                "    \"Institute\": \"Independent University of Bangladesh \",\n" +
                "    \"Country\": \"Bangladesh\",\n" +
                "    \"Email\": \"haider@iub.edu.bd\",\n" +
                "    \"\": \"\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"SL\": \"9\",\n" +
                "    \"Name\": \"Mr. Muhammad Anwarul Islam \",\n" +
                "    \"Designation\": \"Registrar \",\n" +
                "    \"Institute\": \"Independent University of Bangladesh\",\n" +
                "    \"Country\": \"Bangladesh\",\n" +
                "    \"Email\": \"anwar2242@gmail.com\",\n" +
                "    \"\": \"\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"SL\": \"10\",\n" +
                "    \"Name\": \"Prof. Jude William R.Genilo \",\n" +
                "    \"Designation\": \" Professor & Head\",\n" +
                "    \"Institute\": \"University of Liberal Arts Bangladesh (ULAB)\",\n" +
                "    \"Country\": \"Bangladesh\",\n" +
                "    \"Email\": \"jude.genilo@ulab.edu.bd\",\n" +
                "    \"\": \"\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"SL\": \"11\",\n" +
                "    \"Name\": \"Mr. KBM MOIN UDDIN CHISTY\",\n" +
                "    \"Designation\": \"President\",\n" +
                "    \"Institute\": \"Victoria University of Bangladesh\",\n" +
                "    \"Country\": \"Bangladesh\",\n" +
                "    \"Email\": \" chisty_vub@yahoo.com\",\n" +
                "    \"\": \"\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"SL\": \"12\",\n" +
                "    \"Name\": \"Professor Dr. Lutful Hasdan\",\n" +
                "    \"Designation\": \"Vice Chancellor\",\n" +
                "    \"Institute\": \"Bangladesh Agricultural University\",\n" +
                "    \"Country\": \"Bangladesh\",\n" +
                "    \"Email\": \"shrionsong@gmail.com\",\n" +
                "    \"\": \"\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"SL\": \"13\",\n" +
                "    \"Name\": \"Prof. Dr. Nazmul Karim Chowdhury\",\n" +
                "    \"Designation\": \"Vice Chancellor\",\n" +
                "    \"Institute\": \"Fareast International University\",\n" +
                "    \"Country\": \"Bangladesh\",\n" +
                "    \"Email\": \"vc@fiu.edu.bd\",\n" +
                "    \"\": \"\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"SL\": \"14\",\n" +
                "    \"Name\": \"Mr. Md. Monjur-E-Khoda Tarafdar\",\n" +
                "    \"Designation\": \"Treasurer \",\n" +
                "    \"Institute\": \"Fareast International University\",\n" +
                "    \"Country\": \"Bangladesh\",\n" +
                "    \"Email\": \"treasurer@fiu.edu.bd\",\n" +
                "    \"\": \"\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"SL\": \"15\",\n" +
                "    \"Name\": \"Prof. Dr. Md. Nural Anwar\",\n" +
                "    \"Designation\": \"VC\",\n" +
                "    \"Institute\": \"Port City International University\",\n" +
                "    \"Country\": \"Bangladesh\",\n" +
                "    \"Email\": \"\",\n" +
                "    \"\": \"\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"SL\": \"16\",\n" +
                "    \"Name\": \"Md. Obaydur Rahman\",\n" +
                "    \"Designation\": \"Registrar\",\n" +
                "    \"Institute\": \"Port City International University\",\n" +
                "    \"Country\": \"Bangladesh\",\n" +
                "    \"Email\": \"\",\n" +
                "    \"\": \"\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"SL\": \"17\",\n" +
                "    \"Name\": \"Md. Abdul Hye Babu.\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"SL\": \"\",\n" +
                "    \"Name\": \"Director. (Planing & Devt. Division)\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"SL\": \"\",\n" +
                "    \"Name\": \"Bangladesh Open University\",\n" +
                "    \"Designation\": \"Bangladesh\",\n" +
                "    \"Institute\": \"\",\n" +
                "    \"Country\": \"\",\n" +
                "    \"Email\": \"\",\n" +
                "    \"\": \"\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"SL\": \"18\",\n" +
                "    \"Name\": \"Prof. Abdul Mannan Choudhury\",\n" +
                "    \"Designation\": \" Ph.D.\",\n" +
                "    \"Institute\": \"Vice Chancellor & Founder\",\n" +
                "    \"Country\": \"World University of Bangladesh \",\n" +
                "    \"Email\": \"Bangladesh\",\n" +
                "    \"\": \"\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"SL\": \"19\",\n" +
                "    \"Name\": \"Professor Musfiq M. Choudhury\",\n" +
                "    \"Designation\": \"PHDCHAIRMAN (ACTING)\",\n" +
                "    \"Institute\": \" BOARD OF TRUSTEES\",\n" +
                "    \"Country\": \"World University of Bangladesh \",\n" +
                "    \"Email\": \"Bangladesh\",\n" +
                "    \"\": \"\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"SL\": \"20\",\n" +
                "    \"Name\": \"Prof. Dr. M. Nurul Islam\",\n" +
                "    \"Designation\": \"PRO-VICE CHANCELLOR\",\n" +
                "    \"Institute\": \"World University of Bangladesh \",\n" +
                "    \"Country\": \"Bangladesh\",\n" +
                "    \"Email\": \"\",\n" +
                "    \"\": \"\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"SL\": \"21\",\n" +
                "    \"Name\": \"Prof. Jinbo Lin\",\n" +
                "    \"Designation\": \"Assistant Director\",\n" +
                "    \"Institute\": \"Chaoshan College\",\n" +
                "    \"Country\": \" Guangdong\",\n" +
                "    \"Email\": \" China\",\n" +
                "    \"\": \"\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"SL\": \"22\",\n" +
                "    \"Name\": \"Dr. Shaoyou Ji\",\n" +
                "    \"Designation\": \"President\",\n" +
                "    \"Institute\": \"Chaoshan College\",\n" +
                "    \"Country\": \" Guangdong\",\n" +
                "    \"Email\": \" China\",\n" +
                "    \"\": \"\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"SL\": \"23\",\n" +
                "    \"Name\": \"Mr. Zhiqin Wu\",\n" +
                "    \"Designation\": \"Vice Director\",\n" +
                "    \"Institute\": \"Chaoshan College\",\n" +
                "    \"Country\": \" Guangdong\",\n" +
                "    \"Email\": \" China\",\n" +
                "    \"\": \"\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"SL\": \"24\",\n" +
                "    \"Name\": \"Mr. Mingying Zhuang\",\n" +
                "    \"Designation\": \"Honorary President\",\n" +
                "    \"Institute\": \"Chaoshan College\",\n" +
                "    \"Country\": \" Guangdong\",\n" +
                "    \"Email\": \" China\",\n" +
                "    \"\": \"\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"SL\": \"25\",\n" +
                "    \"Name\": \"Mr. Weidao Zhang\",\n" +
                "    \"Designation\": \"Vice President\",\n" +
                "    \"Institute\": \"Chaoshan College\",\n" +
                "    \"Country\": \" Guangdong\",\n" +
                "    \"Email\": \" China\",\n" +
                "    \"\": \"\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"SL\": \"26\",\n" +
                "    \"Name\": \"Mr Wenting Shuang\",\n" +
                "    \"Designation\": \"Dean\",\n" +
                "    \"Institute\": \"Wuhan University of Science and Technology\",\n" +
                "    \"Country\": \"China\",\n" +
                "    \"Email\": \"wtshuang@wust.edu.cn\",\n" +
                "    \"\": \"\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"SL\": \"27\",\n" +
                "    \"Name\": \"Mr Jiwei Shen\",\n" +
                "    \"Designation\": \"Vice President\",\n" +
                "    \"Institute\": \"Wuhan University of Science and Technology\",\n" +
                "    \"Country\": \"China\",\n" +
                "    \"Email\": \"54294141@qq.com\",\n" +
                "    \"\": \"\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"SL\": \"28\",\n" +
                "    \"Name\": \" Mr. Xue Zhengliang \",\n" +
                "    \"Designation\": \"Co-Dean of School of Materials and Metallurgy\",\n" +
                "    \"Institute\": \"Wuhan University of Science and Technology\",\n" +
                "    \"Country\": \"China\",\n" +
                "    \"Email\": \"shuangwenting@wust.edu.cn\",\n" +
                "    \"\": \"\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"SL\": \"29\",\n" +
                "    \"Name\": \"Ms. Lu LU\",\n" +
                "    \"Designation\": \"Vice Director\",\n" +
                "    \"Institute\": \"Guangdong University of Foreign Studies\",\n" +
                "    \"Country\": \"China\",\n" +
                "    \"Email\": \"201110037@oamail.gdufs.edu.cn\",\n" +
                "    \"\": \"\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"SL\": \"30\",\n" +
                "    \"Name\": \"Mr. Ming LIU\",\n" +
                "    \"Designation\": \"Vice Dean\",\n" +
                "    \"Institute\": \"Guangdong University of Foreign Studies\",\n" +
                "    \"Country\": \"China\",\n" +
                "    \"Email\": \"199710573@oamail.gdufs.edu.cn\",\n" +
                "    \"\": \"\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"SL\": \"31\",\n" +
                "    \"Name\": \"Ms. Mengqi LU\",\n" +
                "    \"Designation\": \"Teaching assistant\",\n" +
                "    \"Institute\": \"Guangdong University of Foreign Studies\",\n" +
                "    \"Country\": \"China\",\n" +
                "    \"Email\": \"201910063@oamail.gdufs.edu.cn\",\n" +
                "    \"\": \"\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"SL\": \"32\",\n" +
                "    \"Name\": \"Prof. Xie Wei\",\n" +
                "    \"Designation\": \"Dean\",\n" +
                "    \"Institute\": \"Nanchang University\",\n" +
                "    \"Country\": \"China\",\n" +
                "    \"Email\": \"xiewei@ncu.edu.cn\",\n" +
                "    \"\": \"\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"SL\": \"33\",\n" +
                "    \"Name\": \"Mr Chengping Jiang\",\n" +
                "    \"Designation\": \"Deputy President\",\n" +
                "    \"Institute\": \"Nanchang University\",\n" +
                "    \"Country\": \"China\",\n" +
                "    \"Email\": \"xieweixw2000@yahoo.com\",\n" +
                "    \"\": \"\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"SL\": \"34\",\n" +
                "    \"Name\": \"Prof. YONG KONG\",\n" +
                "    \"Designation\": \"Vice Director\",\n" +
                "    \"Institute\": \"Zhejiang Yuexiu University of Foreign Languages\",\n" +
                "    \"Country\": \"China\",\n" +
                "    \"Email\": \"254058002@qq.com\",\n" +
                "    \"\": \"\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"SL\": \"35\",\n" +
                "    \"Name\": \"Prof. YONGBO ZHANG\",\n" +
                "    \"Designation\": \"Vice President\",\n" +
                "    \"Institute\": \"Zhejiang Yuexiu University of Foreign Languages\",\n" +
                "    \"Country\": \"China\",\n" +
                "    \"Email\": \"zyu_iccd@163.com\",\n" +
                "    \"\": \"\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"SL\": \"36\",\n" +
                "    \"Name\": \"Dr. GOVINDASAMY VISWANATHAN\",\n" +
                "    \"Designation\": \"FOUNDER-CHANCELLOR\",\n" +
                "    \"Institute\": \"Vellore Institute of Technology\",\n" +
                "    \"Country\": \"India\",\n" +
                "    \"Email\": \"chancellor@vit.ac.in\",\n" +
                "    \"\": \"\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"SL\": \"37\",\n" +
                "    \"Name\": \"Mr. Vijayakumar Chandrasekaran\",\n" +
                "    \"Designation\": \"Director of International office\",\n" +
                "    \"Institute\": \"Vellore Institute of Technology\",\n" +
                "    \"Country\": \"India\",\n" +
                "    \"Email\": \"vijay@vit.ac.in\",\n" +
                "    \"\": \"\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"SL\": \"38\",\n" +
                "    \"Name\": \"Mr Sankar Viswanathan\",\n" +
                "    \"Designation\": \"Vice President\",\n" +
                "    \"Institute\": \"Vellore Institute of Technology\",\n" +
                "    \"Country\": \"India\",\n" +
                "    \"Email\": \"sankar@vit.ac.in\",\n" +
                "    \"\": \"\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"SL\": \"39\",\n" +
                "    \"Name\": \"Dr. Brijesh Nair Achuthan Nair Nalinakumari\",\n" +
                "    \"Designation\": \"Assistant Director\",\n" +
                "    \"Institute\": \"Vellore Institute of Technology\",\n" +
                "    \"Country\": \"India\",\n" +
                "    \"Email\": \"brijeshnair.an@vit.ac.in\",\n" +
                "    \"\": \"\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"SL\": \"40\",\n" +
                "    \"Name\": \"Prof. Hiranya Kumar Das\",\n" +
                "    \"Designation\": \"Pro Vice Chancellor\",\n" +
                "    \"Institute\": \"Assam down town University\",\n" +
                "    \"Country\": \"India\",\n" +
                "    \"Email\": \"hkdas1964@gmail.com\",\n" +
                "    \"\": \"\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"SL\": \"41\",\n" +
                "    \"Name\": \"Dr. Parimal Chandra Biswas\",\n" +
                "    \"Designation\": \"Professor\",\n" +
                "    \"Institute\": \" School of Management\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"SL\": \"Dean\",\n" +
                "    \"Name\": \" Students Affairs and International Relations\",\n" +
                "    \"Designation\": \"Adamas University\",\n" +
                "    \"Institute\": \"India\",\n" +
                "    \"Country\": \"parimalchandrabiswas@adamasuniversity.ac.in\",\n" +
                "    \"Email\": \"\",\n" +
                "    \"\": \"\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"SL\": \"42\",\n" +
                "    \"Name\": \"Ms. Oleksandra Biswas\",\n" +
                "    \"Designation\": \"\",\n" +
                "    \"Institute\": \"\",\n" +
                "    \"Country\": \"India\",\n" +
                "    \"Email\": \"\",\n" +
                "    \"\": \"\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"SL\": \"43\",\n" +
                "    \"Name\": \"Prof. Samit Ray\",\n" +
                "    \"Designation\": \"Chancellor\",\n" +
                "    \"Institute\": \"Adamas University\",\n" +
                "    \"Country\": \"India\",\n" +
                "    \"Email\": \"samitray6@gmail.com\",\n" +
                "    \"\": \"\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"SL\": \"44\",\n" +
                "    \"Name\": \"Mr. Debraj Pradhan \",\n" +
                "    \"Designation\": \"Director General- International Relations\",\n" +
                "    \"Institute\": \"KIIT University\",\n" +
                "    \"Country\": \"India\",\n" +
                "    \"Email\": \" internationaloffice@kiit.ac.in\",\n" +
                "    \"\": \"\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"SL\": \"45\",\n" +
                "    \"Name\": \" Anjali Das\",\n" +
                "    \"Designation\": \"\",\n" +
                "    \"Institute\": \"\",\n" +
                "    \"Country\": \"India\",\n" +
                "    \"Email\": \"\",\n" +
                "    \"\": \"\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"SL\": \"46\",\n" +
                "    \"Name\": \"Mr. Meghdut Roychowdhury\",\n" +
                "    \"Designation\": \"Director\",\n" +
                "    \"Institute\": \" Global Operations\",\n" +
                "    \"Country\": \" Techno India University\",\n" +
                "    \"Email\": \"India\",\n" +
                "    \"\": \"\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"SL\": \"47\",\n" +
                "    \"Name\": \"Mr. Erning Wihardjo\",\n" +
                "    \"Designation\": \"Rector\",\n" +
                "    \"Institute\": \"Krida Wacana Christian University (UKRIDA)\",\n" +
                "    \"Country\": \"Indonesia\",\n" +
                "    \"Email\": \"erning.wihardjo@ukrida.ac.id\",\n" +
                "    \"\": \"\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"SL\": \"48\",\n" +
                "    \"Name\": \"Ms. Lanny Susanty\",\n" +
                "    \"Designation\": \"Head of Collaboration Division\",\n" +
                "    \"Institute\": \"Petra Christian University\",\n" +
                "    \"Country\": \"Indonesia\",\n" +
                "    \"Email\": \"domrel@petra.ac.id\",\n" +
                "    \"\": \"\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"SL\": \"49\",\n" +
                "    \"Name\": \"Mr. Djwantoro Hardjito\",\n" +
                "    \"Designation\": \"Rector\",\n" +
                "    \"Institute\": \"Petra Christian University\",\n" +
                "    \"Country\": \"Indonesia\",\n" +
                "    \"Email\": \"rector@petra.ac.id\",\n" +
                "    \"\": \"\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"SL\": \"50\",\n" +
                "    \"Name\": \"Mr. Agung Herwi Bantara\",\n" +
                "    \"Designation\": \"Secretary\",\n" +
                "    \"Institute\": \"Petra Christian University\",\n" +
                "    \"Country\": \"Indonesia\",\n" +
                "    \"Email\": \"herwi@petra.ac.id\",\n" +
                "    \"\": \"\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"SL\": \"51\",\n" +
                "    \"Name\": \"Prof. Marniati \",\n" +
                "    \"Designation\": \"Rector\",\n" +
                "    \"Institute\": \"University of Ubudiyah Indonesia\",\n" +
                "    \"Country\": \"Indonesia\",\n" +
                "    \"Email\": \"marniati@uui.ac.id\",\n" +
                "    \"\": \"\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"SL\": \"52\",\n" +
                "    \"Name\": \"Mr Dedi Zefrizal\",\n" +
                "    \"Designation\": \"Chairman\",\n" +
                "    \"Institute\": \"University of Ubudiyah Indonesia\",\n" +
                "    \"Country\": \"Indonesia\",\n" +
                "    \"Email\": \"info@uui.ac.id\",\n" +
                "    \"\": \"\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"SL\": \"53\",\n" +
                "    \"Name\": \"Ms. Riana Permatasari\",\n" +
                "    \"Designation\": \"Head\",\n" +
                "    \"Institute\": \"Universitas Islam Sultan Agung\",\n" +
                "    \"Country\": \"Indonesia\",\n" +
                "    \"Email\": \"international@unissula.ac.id\",\n" +
                "    \"\": \"\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"SL\": \"54\",\n" +
                "    \"Name\": \"Dr. Bedjo Santoso\",\n" +
                "    \"Designation\": \"Vice Rector of Academic and Collaboration Affairs\",\n" +
                "    \"Institute\": \"Universitas Islam Sultan Agung\",\n" +
                "    \"Country\": \"Indonesia\",\n" +
                "    \"Email\": \"\",\n" +
                "    \"\": \"\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"SL\": \"55\",\n" +
                "    \"Name\": \"Dr. Hendar Hender\",\n" +
                "    \"Designation\": \"Vice Dean\",\n" +
                "    \"Institute\": \"Universitas Islam Sultan Agung\",\n" +
                "    \"Country\": \"Indonesia\",\n" +
                "    \"Email\": \"hendar@unissula.ac.id\",\n" +
                "    \"\": \"\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"SL\": \"56\",\n" +
                "    \"Name\": \"Mr Khoirul Fuad\",\n" +
                "    \"Designation\": \"Head of Dyploma Accounting Department\",\n" +
                "    \"Institute\": \"Universitas Islam Sultan Agung\",\n" +
                "    \"Country\": \"Indonesia\",\n" +
                "    \"Email\": \"khoirulfuad@unissula.ac.id\",\n" +
                "    \"\": \"\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"SL\": \"57\",\n" +
                "    \"Name\": \"Mr. Yudi Sutarso\",\n" +
                "    \"Designation\": \"Rector\",\n" +
                "    \"Institute\": \"STIE Perbanas Surabaya\",\n" +
                "    \"Country\": \"Indonesia\",\n" +
                "    \"Email\": \"yudi@perbanas.ac.id\",\n" +
                "    \"\": \"\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"SL\": \"58\",\n" +
                "    \"Name\": \"Dr. ROVILA EL MAGHVIROH\",\n" +
                "    \"Designation\": \"HEAD OF INTERNATIONAL AFFAIRS\",\n" +
                "    \"Institute\": \"STIE Perbanas Surabaya\",\n" +
                "    \"Country\": \"Indonesia\",\n" +
                "    \"Email\": \"rovila@perbanas.ac.id\",\n" +
                "    \"\": \"\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"SL\": \"59\",\n" +
                "    \"Name\": \"Ms. Lidia Sandra\",\n" +
                "    \"Designation\": \" Expert Staff to the Rector\",\n" +
                "    \"Institute\": \"Krida Wacana Christian University (UKRIDA)\",\n" +
                "    \"Country\": \"Indonesia\",\n" +
                "    \"Email\": \" lidia.sandra@ukrida.ac.id\",\n" +
                "    \"\": \"\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"SL\": \"60\",\n" +
                "    \"Name\": \"Prof. Ahmad Reza Bahrami\",\n" +
                "    \"Designation\": \"Vice-President for Research and Technology\",\n" +
                "    \"Institute\": \"Ferdowsi University of Mashhad\",\n" +
                "    \"Country\": \"Iran\",\n" +
                "    \"Email\": \" ar-bahrami@um.ac.ir\",\n" +
                "    \"\": \"\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"SL\": \"61\",\n" +
                "    \"Name\": \"Prof. Dr. Regina Valutytė\",\n" +
                "    \"Designation\": \"Vice-Rector for Academic Affairs\",\n" +
                "    \"Institute\": \"Mykolas Romeris University\",\n" +
                "    \"Country\": \"Lithuania\",\n" +
                "    \"Email\": \"r.valutyte@mruni.eu\",\n" +
                "    \"\": \"\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"SL\": \"62\",\n" +
                "    \"Name\": \"Prof. SALLEH ABD RASHID\",\n" +
                "    \"Designation\": \"Director\",\n" +
                "    \"Institute\": \"Universiti Malaysia Perlis\",\n" +
                "    \"Country\": \"Malaysia\",\n" +
                "    \"Email\": \"salleh@unimap.edu.my\",\n" +
                "    \"\": \"\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"SL\": \"63\",\n" +
                "    \"Name\": \"Prof. Rezuwan Kamaruddin\",\n" +
                "    \"Designation\": \"Deputy Vice Chancellor (Academic & International)\",\n" +
                "    \"Institute\": \"Universiti Malaysia Perlis\",\n" +
                "    \"Country\": \"Malaysia\",\n" +
                "    \"Email\": \"rezuwan@unimap.edu.my\",\n" +
                "    \"\": \"\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"SL\": \"64\",\n" +
                "    \"Name\": \"Dr. Zenaida Reyes\",\n" +
                "    \"Designation\": \"Vice President for University Relations and Advancement\",\n" +
                "    \"Institute\": \"Philippine Normal University\",\n" +
                "    \"Country\": \"Philippines\",\n" +
                "    \"Email\": \"reyes.zq@pnu.edu.ph\",\n" +
                "    \"\": \"\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"SL\": \"65\",\n" +
                "    \"Name\": \" MS. CAMILLE AUREA T. REZONABLE\",\n" +
                "    \"Designation\": \"Admission Officer\",\n" +
                "    \"Institute\": \"Panpacific University\",\n" +
                "    \"Country\": \"Philippines\",\n" +
                "    \"Email\": \"rezonable.camille@panpacificu.edu.ph\",\n" +
                "    \"\": \"\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"SL\": \"66\",\n" +
                "    \"Name\": \"MISS. MADELEINE PATRICIA P. CRUZ\",\n" +
                "    \"Designation\": \"Deputy Head\",\n" +
                "    \"Institute\": \"Panpacific University\",\n" +
                "    \"Country\": \"Philippines\",\n" +
                "    \"Email\": \" cruz.madeleine@panpacificu.edu.ph\",\n" +
                "    \"\": \"\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"SL\": \"67\",\n" +
                "    \"Name\": \"Dr. Gina Lee Santos\",\n" +
                "    \"Designation\": \"Director Quality Assurance\",\n" +
                "    \"Institute\": \"Panpacific University\",\n" +
                "    \"Country\": \"Philippines\",\n" +
                "    \"Email\": \"ginalee.punp@gmail.com\",\n" +
                "    \"\": \"\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"SL\": \"68\",\n" +
                "    \"Name\": \"Prof. Dr. hab. C. Eng. Janusz Szpytko\",\n" +
                "    \"Designation\": \"Professor; UNESCO AGH Chairholder\",\n" +
                "    \"Institute\": \"AGH University of Science and Technology Krakow\",\n" +
                "    \"Country\": \"Poland\",\n" +
                "    \"Email\": \"szpytko@agh.edu.pl\",\n" +
                "    \"\": \"\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"SL\": \"69\",\n" +
                "    \"Name\": \"Ms. Danuta Anita Wozniak\",\n" +
                "    \"Designation\": \"\",\n" +
                "    \"Institute\": \"\",\n" +
                "    \"Country\": \"Poland\",\n" +
                "    \"Email\": \"\",\n" +
                "    \"\": \"\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"SL\": \"70\",\n" +
                "    \"Name\": \"Dr. Jekuk Chang\",\n" +
                "    \"Designation\": \"President\",\n" +
                "    \"Institute\": \"Dongseo University\",\n" +
                "    \"Country\": \"South korea\",\n" +
                "    \"Email\": \"jchang@dongseo.ac.kr\",\n" +
                "    \"\": \"\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"SL\": \"71\",\n" +
                "    \"Name\": \"Prof. Kyongho Hahn\",\n" +
                "    \"Designation\": \"Dean\",\n" +
                "    \"Institute\": \"Dongseo University\",\n" +
                "    \"Country\": \"South korea\",\n" +
                "    \"Email\": \"khahn@dongseo.ac.kr\",\n" +
                "    \"\": \"\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"SL\": \"72\",\n" +
                "    \"Name\": \"Ms. Jeonghee Kim\",\n" +
                "    \"Designation\": \"Director\",\n" +
                "    \"Institute\": \"Dongseo University\",\n" +
                "    \"Country\": \"South korea\",\n" +
                "    \"Email\": \"international@dongseo.ac.kr\",\n" +
                "    \"\": \"\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"SL\": \"73\",\n" +
                "    \"Name\": \"Mr. Ching-Pu Chen Chen\",\n" +
                "    \"Designation\": \"Chief Global Officer\",\n" +
                "    \"Institute\": \"Yuan Ze University\",\n" +
                "    \"Country\": \"Taiwan\",\n" +
                "    \"Email\": \"chingpu@saturn.yzu.edu.tw\",\n" +
                "    \"\": \"\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"SL\": \"74\",\n" +
                "    \"Name\": \"Dr. Panadda Unyapho\",\n" +
                "    \"Designation\": \"Director\",\n" +
                "    \"Institute\": \"Bangkok University\",\n" +
                "    \"Country\": \"Thailand\",\n" +
                "    \"Email\": \"panadda.u@bu.ac.th\",\n" +
                "    \"\": \"\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"SL\": \"75\",\n" +
                "    \"Name\": \"Dr. Mathana Santiwat\",\n" +
                "    \"Designation\": \"Vice Chairman of the Board of Trustees\",\n" +
                "    \"Institute\": \"Bangkok University\",\n" +
                "    \"Country\": \"Thailand\",\n" +
                "    \"Email\": \"mathana.s@bu.ac.th\",\n" +
                "    \"\": \"\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"SL\": \"76\",\n" +
                "    \"Name\": \"Mr. ALTUNTAS BAYBARS\",\n" +
                "    \"Designation\": \"Chairman \",\n" +
                "    \"Institute\": \"World Business Angels Investment Forum (WBAF)\",\n" +
                "    \"Country\": \"Turkey\",\n" +
                "    \"Email\": \"\",\n" +
                "    \"\": \"\"\n" +
                "  }\n" +
                "]";
    }
}
