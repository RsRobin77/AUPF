package com.daffodil.varsity.aupf.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.daffodil.varsity.aupf.R;

public class SliderAdapter extends PagerAdapter {
    private Context context;
    private LayoutInflater layoutInflater;

    private int[] slideImages = {
            R.drawable.ictcarnival_logo,
            R.drawable.ictcarnival_logo,
            R.drawable.ictcarnival_logo
    };

    private String[] slideHeadings = {
            "Day 1",
            "Day 2",
            "Day 3"
    };

    private String[] slideDescription = {
            "Description of the event 1",
            "Description of the event 2",
            "Description of the event 3"
    };


    public SliderAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

        View view = layoutInflater.inflate(R.layout.intro_slider, container, false);

        ImageView image = view.findViewById(R.id.slide_image);
        TextView heading = view.findViewById(R.id.slide_heading);
        TextView desc = view.findViewById(R.id.slide_desc);

        image.setImageResource(slideImages[position]);
        heading.setText(slideHeadings[position]);
        desc.setText(slideDescription[position]);

        container.addView(view);


        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return slideHeadings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }
}
