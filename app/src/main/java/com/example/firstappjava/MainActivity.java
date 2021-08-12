package com.example.firstappjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {



    TextView tvSplash, tvSubSplash;
    Button btnGet;
    Animation atg, btgOne, btgTwo;
    ImageView ivSplash;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivSplash =  findViewById(R.id.ivSplash);
        tvSplash =  findViewById(R.id.tvSplash);
        tvSubSplash = findViewById(R.id.tvSubSplash);
        btnGet = findViewById(R.id.btnGet);

        //load animations
        atg = AnimationUtils.loadAnimation(this, R.anim.atg);
        btgOne = AnimationUtils.loadAnimation(this, R.anim.btgone);
        btgTwo = AnimationUtils.loadAnimation(this, R.anim.btgtwo);

        // passing animation
        ivSplash.startAnimation(atg);
        tvSplash.startAnimation(btgOne);
        tvSubSplash.startAnimation(btgOne);
        btnGet.startAnimation(btgTwo);

        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent( MainActivity.this, StopWatchAct.class );
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });

        //Import font
        Typeface Mlight = Typeface.createFromAsset(getAssets(), "fonts/MLight.ttf");
        Typeface MMedium = Typeface.createFromAsset(getAssets(), "fonts/MMedium.ttf");
        Typeface MRegular = Typeface.createFromAsset(getAssets(), "fonts/MRegular.ttf");

        //customize font
        tvSplash.setTypeface(MRegular);
        tvSubSplash.setTypeface(Mlight);
        btnGet.setTypeface(MMedium);
    }
}