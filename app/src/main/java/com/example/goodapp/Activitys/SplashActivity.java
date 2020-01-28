package com.example.goodapp.Activitys;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;

import com.example.goodapp.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        final Thread thread = new Thread(){
            public void run(){
                try {
                    Thread.sleep(3 * 1000);
                    Intent i = new Intent(SplashActivity.this, LoginActivity.class);
                    startActivity(i);
                }catch (InterruptedException e){

                }
            }
        };
        thread.start();
    }
}
