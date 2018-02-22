package com.example.macbook.projectbasicpertama;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class KirimDataActivity extends AppCompatActivity {

    @BindView(R.id.etNama)
    EditText etNama;
    @BindView(R.id.etAlamat)
    EditText etAlamat;
    @BindView(R.id.btnkirim)
    Button btnkirim;
    @BindView(R.id.ntah)
    Button ntah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kirim_data);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @OnClick(R.id.btnkirim)
    public void onViewClicked() {
        String nama = etNama.getText().toString();
        String alamat = etAlamat.getText().toString();
        if (TextUtils.isEmpty(nama)) {
            etNama.setError("nama tidak boleh kosong");
            etNama.requestFocus();
        } else if (TextUtils.isEmpty(alamat)) {
            etAlamat.setError("alamat tidak boleh kosong");
            etAlamat.requestFocus();
        } else {
            Intent kirim = new Intent(KirimDataActivity.this, TerimaActivity.class);
            kirim.putExtra("nM", nama);
            kirim.putExtra("aL", alamat);
            startActivity(kirim);
        }
    }

    @OnClick(R.id.ntah)
    public void onViewClicked() {
        startActivity(new Intent(KirimDataActivity.this, MainActivity.class));
    }
}
