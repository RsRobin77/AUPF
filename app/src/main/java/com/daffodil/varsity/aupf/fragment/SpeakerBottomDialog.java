package com.daffodil.varsity.aupf.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.bumptech.glide.Glide;
import com.daffodil.varsity.aupf.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class SpeakerBottomDialog extends BottomSheetDialogFragment {
    private static final String NAME = "name";
    private static final String TITLE = "title";
    private static final String IMAGE = "image";
    private static final String BIO = "bio";

    public static SpeakerBottomDialog newInstance(int Image, String Name, String Title, String Bio) {
        Bundle args = new Bundle();
        args.putInt(IMAGE, Image);
        args.putString(NAME, Name);
        args.putString(TITLE, Title);
        args.putString(BIO, Bio);


        SpeakerBottomDialog fragment = new SpeakerBottomDialog();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.speakers_bottom_sheet_design, container, false);

        int img = getArguments().getInt(IMAGE);
        String name = getArguments().getString(NAME);
        String title = getArguments().getString(TITLE);
        String bio = getArguments().getString(BIO);

        Glide.with(getContext()).load(img).into((ImageView) view.findViewById(R.id.bottom_speaker_image));
        TextView tv_name = view.findViewById(R.id.bottom_speaker_name);
        tv_name.setText(name);
        TextView tv_title = view.findViewById(R.id.bottom_speaker_title);
        tv_title.setText(title);
        TextView tv_bio = view.findViewById(R.id.bottom_speaker_biography);
        tv_bio.setText(bio);

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NO_FRAME, R.style.AppTheme_NoFrame);
    }
}
