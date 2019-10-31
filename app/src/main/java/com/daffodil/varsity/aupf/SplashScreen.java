package com.daffodil.varsity.aupf;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;


public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        ImageView carnivalLogo = findViewById(R.id.carnivalLogo);

        Glide.with(this).load(R.drawable.ict_carnival_logo).into(carnivalLogo);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                startActivity(new Intent(SplashScreen.this,HomeActivity.class));
                finish();

            }
        }, 3000);
    }
}
