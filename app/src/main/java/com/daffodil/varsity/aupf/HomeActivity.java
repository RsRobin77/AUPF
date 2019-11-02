package com.daffodil.varsity.aupf;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.bumptech.glide.Glide;
import com.daffodil.varsity.aupf.fragment.About;
import com.daffodil.varsity.aupf.fragment.TimerUpComingFragment;
import com.daffodil.varsity.aupf.fragment.VenueMapFragment;
import com.daffodil.varsity.aupf.ui.fragment.ContactUs;
import com.daffodil.varsity.aupf.ui.fragment.DailyEvents;
import com.daffodil.varsity.aupf.ui.fragment.EventSegment;
import com.daffodil.varsity.aupf.ui.fragment.Volunteer;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

/**
 * This is the home activity where the users are stay. In this activity we have
 * some different fragments. [Dashboard, DailyEvent, FreshRoom, Volunteer]
 * in Dashboard fragment there are some different type of data like remaining time to start the carnival,
 * the list of speakers, and the list of events.
 */

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        BottomNavigationView.OnNavigationItemSelectedListener {

    private static final String AUPF_HOME = "home";

    private static String ACTIVE_FRAGMENT = "";

    boolean doubleBackToExitPressedOnce = false;
    private View background;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        NavigationView nav = findViewById(R.id.nav_view);
        BottomNavigationView bottomNavigation = findViewById(R.id.bottom_navigation);

        bottomNavigation.setOnNavigationItemSelectedListener(this);
        //navigationView
        nav.setNavigationItemSelectedListener(this);
        View headerView = nav.getHeaderView(0);

        ImageView carnivalLogo = headerView.findViewById(R.id.nav_carnival_logo);
        Glide.with(this).load(R.drawable.aupf_logo_large).into(carnivalLogo);

        /*NAVIGATION DRAWER SEGMENT*/
        DrawerLayout drawer = findViewById(R.id.drawer_layout);

        final ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {

            openFragment(new TimerUpComingFragment(), "aupf_home");
            if (getSupportActionBar() != null)
                getSupportActionBar().setTitle("AUPF");
            ACTIVE_FRAGMENT = "aupf_home";

            try {

                //Open CountDown Timer
                background = drawer;

                final ViewTreeObserver viewTreeObserver = background.getViewTreeObserver();

                if (viewTreeObserver.isAlive()) {
                    viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {

                        @SuppressLint("NewApi")
                        @Override
                        public void onGlobalLayout() {
                            circularRevealAnimation();
                            background.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        }

                    });
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    private void circularRevealAnimation() {
        int cx = background.getRight() / 2;
        int cy = background.getBottom() / 2;

        float finalRadius = Math.max(background.getWidth(), background.getHeight());

        @SuppressLint({"NewApi", "LocalSuppress"})
        Animator circularReveal = ViewAnimationUtils.createCircularReveal(
                background,
                cx,
                cy,
                0,
                finalRadius);

        circularReveal.setDuration(800);
        background.setVisibility(View.VISIBLE);
        circularReveal.start();

    }

    // Open Fragment
    private void openFragment(Fragment fragment, String container) {

        if (!ACTIVE_FRAGMENT.equals(container)) {
            ACTIVE_FRAGMENT = String.valueOf(container);

            FrameLayout layout = findViewById(R.id.container);
            layout.removeAllViews();

            FragmentManager fragmentManager = getSupportFragmentManager();

            FragmentTransaction transaction = fragmentManager.beginTransaction();

//            transaction.setCustomAnimations(R.anim.enter_from_bottom, R.anim.exit_to_top);
            transaction.disallowAddToBackStack(); //to remove back fragment
            transaction.replace(R.id.container,
                    fragment).commit();
            fragmentManager.executePendingTransactions();
        }
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.bottom_nav_rundown || item.getItemId() == R.id.nav_rundown_and_schedule) {
            if (getSupportActionBar() != null)
                getSupportActionBar().setTitle("Schedule & Rundown");

            openFragment(new DailyEvents(), "daily_event");
        } else {
            switch (item.getItemId()) {

                /**Navigation drawer item segment starts here..*/

                case R.id.nav_about:

                    if (getSupportActionBar() != null)
                        getSupportActionBar().setTitle("AUPF");

                    openFragment(new About(), "about");

                    break;

                case R.id.nav_event_segment:

                    if (getSupportActionBar() != null)
                        getSupportActionBar().setTitle("AUPF Calender");

                    openFragment(new EventSegment(), "event_segment");

                    break;


                case R.id.nav_volunteer:
                    if (getSupportActionBar() != null)
                        getSupportActionBar().setTitle("Volunteers");

                    openFragment(new Volunteer(), "volunteer");
                    break;

                case R.id.nav_gallery:

                    break;

                case R.id.nav_social_media:
                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_VIEW);
                    intent.addCategory(Intent.CATEGORY_BROWSABLE);
                    intent.setData(Uri.parse("http://aupf2019.daffodil.university/"));
                    startActivity(intent);

                    break;

//
//                case R.id.nav_contact_us:
//                    if (getSupportActionBar() != null)
//                        getSupportActionBar().setTitle("Contact US");
//
//                    openFragment(new ContactUs(), "contact_us");
//                    break;
//

                /**Navigation drawer item segment ends here..*/

                /**bottom navigation item segment starts from here*/

                case R.id.bottom_nav_dashboard:
                    if (getSupportActionBar() != null)
                        getSupportActionBar().setTitle("AUPF");

                    //Open CountDown Timer
                    openFragment(new TimerUpComingFragment(), "aupf_home");

                    break;


                case R.id.bottom_nav_map:
                    if (getSupportActionBar() != null)
                        getSupportActionBar().setTitle("Venue Map");

                    openFragment(new VenueMapFragment(), "map");
                    break;

                case R.id.bottom_nav_contact_us:
                    if (getSupportActionBar() != null)
                        getSupportActionBar().setTitle("Contact");

                    openFragment(new ContactUs(), "contact_us");
                    break;

                /**bottom navigation item segment ends here*/
            }
        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);

        builder1.setTitle("Do you want to exit?");
        builder1.setCancelable(true);
        builder1.setIcon(R.drawable.aupf_logo);

        builder1.setNegativeButton(
                "NO",
                (dialog, id) -> dialog.cancel());

        builder1.setNeutralButton("YES", ((dialog, which) -> super.onBackPressed()));

        AlertDialog alert11 = builder1.create();
        alert11.show();
    }
}
