package edu.ccm.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class splashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        /*
        ImageView splashImage = findViewById(R.id.splashImage);
        Animation splashAnim = AnimationUtils.loadAnimation(this, R.anim.embiggen);
        splashImage.startAnimation(splashAnim);
        */

        TimerTask task = new TimerTask(){
            @Override
            public void run () {

                //finish();
                startActivity(new Intent(splashActivity.this, MainActivity.class));
            }
        };
        Timer opening = new Timer();
        opening.schedule(task, 10000);
    }
}