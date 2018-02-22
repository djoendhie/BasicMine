package com.example.macbook.bangundatar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class HasilActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil);

        String nilaiAlas = getIntent().getStringExtra("Nilai Alas");
        String nilaiTinggi = getIntent().getStringExtra("Nilai Tinggi");
        String nilaiHasil = getIntent().getStringExtra("Nilai Hasil");

        //Set widget
        tAlas.setText("Nilai Alas :" + nilaiAlas);
        tTinggi.setText("Nilai Alas :" + nilaiTinggi);
        tHasil.setText(nilaiHasil);
    }
}
