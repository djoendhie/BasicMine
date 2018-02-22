package com.example.macbook.bangundatar;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // class handler
        Handler handler = new Handler();

        //delay nya
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                ///order buat ke activity

                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                /// viar kgak balek lage
                finish();
            }
        }, 3000);
    }
}
