package com.example.macbook.web;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class AboutActivity extends AppCompatActivity {

    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        webView = (WebView)findViewById(R.id.Web);

        // biar nampak

        webView.loadUrl("file:///android/assets/testJutexx.mhtml");

    }
}
