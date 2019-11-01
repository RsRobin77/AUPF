package com.daffodil.varsity.aupf.fragment;


import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
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

    //End time
    private static final String EVENT_START_TIME = "22.11.2019, 10:0:00";
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

    private WebView webView;

    public TimerUpComingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_timer_up_coming, container, false);
//
//        if (savedInstanceState == null) {
//            openFragment(new SpeakerFragment());
//        }

        initTimer();
        init();

        ImageView carnivalLogo = view.findViewById(R.id.carnival_logo_home);
        Glide.with(this).load(R.drawable.aupf_logo).into(carnivalLogo);

        return view;
    }

    @SuppressLint("SetTextI18n")
    private void init() {
        TextView textView = view.findViewById(R.id.keynote);

        textView.setText("Former Senior Advisor of the London Stock Exchange " +
                "Group (LSEG) for the Elite Program, Chairman of the World Business " +
                "Angels Investment Forum (WBAF) – an affiliated partner of the G20 Global" +
                " Partnership for Financial Inclusion (GPFI) chaired by the Queen Maxima " +
                "of the Netherlands, Co-chair of the Washington DC- based Global Business" +
                " Angels Network (GBAN), Vice President of the Brussels-based European Trade Association for Business Angels, Seed Funds, and Early Stage Market Players (EBAN), President of the Business Angels Association of Turkey (TBAA), the World Entrepreneurship Forum Ambassador to Turkey and the Balkan countries, and President of Deulcom International Inc. Star of the Turkish version of the television show Dragons’ Den / Sharks Tank. Recipient of the European Trade Association of Business Angels (EBAN) award for the Best Individual in Europe Globally Engaging with the Global Entrepreneurial Ecosystem in 2014 (Ireland), 2015 (Netherlands), 2016 (Portugal), 2017 (Spain) and 2018 (Bulgaria). The only entrepreneur to be granted a personal audience with former President Obama at the Presidential Summit on Entrepreneurship in Washington DC. Developer of the world-renowned entrepreneurship theory, the Altuntas Start-up Compass Theory, researched by Sheffield University and used in numerous MBA programs. Appointed as JCI Ambassador, following Ban Ki-moon, former Secretary General of the United Nations. Profiled regularly by leading international media such as CNN International, Bloomberg, BBC. A co-author of Planet Entrepreneur: The World Entrepreneurship Forum's Guide to Business Success Around the World, published by Wiley (2013). Author of Off the Bus, Into a Supercar! How I Became a Top TV Star and Celebrated Investor, published by Balboa Press (2014) and " +
                "translated into Chinese, Croatian, Albanian, and Macedonian.");


        ImageView carnivalGroupPhoto = view.findViewById(R.id.avatar);
        Glide.with(this).load(R.drawable.baybars)
                .optionalCenterCrop()
                .circleCrop()
                .into(carnivalGroupPhoto);

        ImageView radisson = view.findViewById(R.id.radisson);
        Glide.with(this).load(R.drawable.radison)
                .into(radisson);

        ImageView leMaeridian = view.findViewById(R.id.le_maeridian);
        Glide.with(this).load(R.drawable.le_meridian2)
                .into(leMaeridian);

        ImageView aupf18 = view.findViewById(R.id.aupf_18);
        Glide.with(this).load(R.drawable.aupf18)
                .into(aupf18);

    }

    private void initTimer() {
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

        Date oldDate, newDate;
        try {
            oldDate = formatter.parse(oldTime);
            newDate = formatter.parse(EVENT_START_TIME);
            oldLong = oldDate.getTime();
            NewLong = newDate.getTime();

            //Interval Time
            diff = NewLong - oldLong;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        counter = new MyCount(diff, 1000);
        counter.start();
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

    private int getRandomColor() {
        Random rnd = new Random();
        return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
    }

    // countdown timer is an abstract class, so extend it and fill in methods
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
