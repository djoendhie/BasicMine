package com.example.macbook.projectbasicpertama;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TerimaActivity extends AppCompatActivity {

    @BindView(R.id.etNama)
    EditText etNama;
    @BindView(R.id.etAlamat)
    EditText etAlamat;
    @BindView(R.id.btnback)
    Button btnback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terima);
        ButterKnife.bind(this);

        Intent terima = getIntent();
        etAlamat.setText(terima.getStringExtra("aL"));
        etNama.setText(terima.getStringExtra("nM"));
    }

    @OnClick(R.id.btnback)
    public void onViewClicked() {
        startActivity(new Intent(TerimaActivity.this, KirimDataActivity.class));
    }
}
