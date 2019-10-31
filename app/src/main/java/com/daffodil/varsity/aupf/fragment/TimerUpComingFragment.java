package com.daffodil.varsity.aupf.fragment;


import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.daffodil.varsity.aupf.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.TimeUnit;


/**
 * A simple {@link Fragment} subclass.
 */
public class TimerUpComingFragment extends Fragment {

    private View view;
    private MyCount counter;
    private TextView day, hours, minutes, seconds;
    private long diff;
    private long oldLong;
    private long NewLong;
    private ConstraintLayout LayoutDay;
    private ConstraintLayout LayoutHours;
    private ConstraintLayout LayoutMin;
    private ConstraintLayout LayoutSec;

    public TimerUpComingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_timer_up_coming, container, false);

        if (savedInstanceState == null) {
            openFragment(new SpeakerFragment());
        }

        day = view.findViewById(R.id.day);
        hours = view.findViewById(R.id.hours);
        minutes = view.findViewById(R.id.minutes);
        seconds = view.findViewById(R.id.seconds);
        LayoutDay = view.findViewById(R.id.CLday);
        LayoutHours = view.findViewById(R.id.Clhours);
        LayoutMin = view.findViewById(R.id.CLmin);
        LayoutSec = view.findViewById(R.id.CLsec);

        //change timer color init
        GradientDrawable drawable = (GradientDrawable) getActivity().getResources().getDrawable(R.drawable.circle_shape_day);
        drawable.setColor(getRandomColor());
        LayoutDay.setBackgroundDrawable(drawable);
        GradientDrawable drawable_hr = (GradientDrawable) getActivity().getResources().getDrawable(R.drawable.circle_shape_hr);
        drawable_hr.setColor(getRandomColor());
        LayoutHours.setBackgroundDrawable(drawable_hr);
        GradientDrawable drawable_min = (GradientDrawable) getActivity().getResources().getDrawable(R.drawable.circle_shape_min);
        drawable_min.setColor(getRandomColor());
        LayoutMin.setBackgroundDrawable(drawable_min);


        //Date and Time format
        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy, HH:mm:ss");
        // get date from device
        String currentDate = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault()).format(new Date());
        // get time from device
        String currentTime = new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date());

        // start time
        String oldTime = currentDate + ", " + currentTime;
        //End time
        String NewTime = "26.10.2019, 07:0:00";

        Date oldDate, newDate;
        try {
            oldDate = formatter.parse(oldTime);
            newDate = formatter.parse(NewTime);
            oldLong = oldDate.getTime();
            NewLong = newDate.getTime();
            //Interval Time
            diff = NewLong - oldLong;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        counter = new MyCount(diff, 1000);
        counter.start();

        ImageView carnivalLogo = view.findViewById(R.id.carnival_logo_home);
        Glide.with(this).load(R.drawable.carnival_logo_2019).into(carnivalLogo);

        ImageView carnivalGroupPhoto = view.findViewById(R.id.carnival_group_photo);
        Glide.with(this).load(R.drawable.carnival_group_photo).optionalCenterCrop().into(carnivalGroupPhoto);


        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        if (counter == null) {
            counter.start();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        if (counter != null) {
            counter.cancel();
        }
    }


    private void openFragment(Fragment fragment) {

        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_speaker, fragment, "Speaker fragment")
                .commit();
    }

    private int getRandomColor() {
        Random rnd = new Random();
        return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
    }

    // countdowntimer is an abstract class, so extend it and fill in methods
    public class MyCount extends CountDownTimer {
        MyCount(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onFinish() {
            //when finish countdown timer
            day.setText("0");
            hours.setText("0");
            minutes.setText("0");
            seconds.setText("0");
        }

        @Override
        public void onTick(long millisUntilFinished) {

            long millis = millisUntilFinished;
            //convert milliseconds to Days
            day.setText(String.valueOf(TimeUnit.MILLISECONDS.toDays(millisUntilFinished))
            );
            //convert milliseconds to Hours
            hours.setText(String.valueOf(TimeUnit.MILLISECONDS.toHours(millisUntilFinished) -
                    TimeUnit.DAYS.toHours(TimeUnit.MILLISECONDS.toDays(millisUntilFinished)))
            );
            //convert milliseconds to Minutes
            minutes.setText(String.valueOf(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) -
                    TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millisUntilFinished)))
            );
            //convert milliseconds to Seconds
            seconds.setText(String.valueOf(TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) -
                    TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)))
            );

            //Change background colour
            GradientDrawable drawable_sec = (GradientDrawable) getActivity().getResources().getDrawable(R.drawable.circle_shape);
            drawable_sec.setColor(getRandomColor());

            //Seconds Color change
            LayoutSec.setBackgroundDrawable(drawable_sec);
            //minute color change
            if ((TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished))) == 59) {
                GradientDrawable drawable_min = (GradientDrawable) getActivity().getResources().getDrawable(R.drawable.circle_shape_min);
                drawable_min.setColor(getRandomColor());
                LayoutMin.setBackgroundDrawable(drawable_min);
            }

            //Hours color change
            if (TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millisUntilFinished)) == 59) {
                GradientDrawable drawable = (GradientDrawable) getActivity().getResources().getDrawable(R.drawable.circle_shape_hr);
                drawable.setColor(getRandomColor());
                LayoutHours.setBackgroundDrawable(drawable);
            }

            //Days color change
            if (TimeUnit.MILLISECONDS.toHours(millisUntilFinished) - TimeUnit.DAYS.toHours(TimeUnit.MILLISECONDS.toDays(millisUntilFinished)) == 59) {
                GradientDrawable drawable = (GradientDrawable) getActivity().getResources().getDrawable(R.drawable.circle_shape_day);
                drawable.setColor(getRandomColor());
                LayoutDay.setBackgroundDrawable(drawable);
            }

        }
    }
}
