package com.example.macbook.widged;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SpinnerActivity extends AppCompatActivity {

    @BindView(R.id.SpinBuah)
    Spinner SpinBuah;
    @BindView(R.id.imgBuah)
    ImageView imgBuah;
    @BindView(R.id.namaBuah)
    TextView namaBuah;

    //array nama buah

    String [] namabuah1 = {"alpukat", "apel", "ceri", "durian","jambuair", "manggis", "strawberri"};
    int[] suarabuah = {R.raw.alpukat, R.raw.apel, R.raw.ceri, R.raw.durian, R.raw.jambuair, R.raw.manggis, R.raw.strawberry};
    int[] gambarbuah1 = {R.drawable.alpukat, R.drawable.apel, R.drawable.ceri, R.drawable.durian, R.drawable.jambuair, R.drawable.manggis, R.drawable.strawberry};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        ButterKnife.bind(this);


        //buat adapter buat spinner nya
        ArrayAdapter<String> adapterSpinner = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, namabuah1);

        // set adapter spinner
        SpinBuah.setAdapter(adapterSpinner);

        SpinBuah.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int posisi, long l) {

                // set src img nya dari aray nya
                imgBuah.setImageResource(gambarbuah1[posisi]);
                //text nya juga
                namaBuah.setText(namabuah1[posisi]);

                ///jalan methood audio nya
                putarsuarabuah(posisi);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    private void putarsuarabuah(int posisi) {
//        panggil media player
        MediaPlayer mediaPlayer = MediaPlayer.create(this, suarabuah[posisi]);
        mediaPlayer.start();
    }

}










