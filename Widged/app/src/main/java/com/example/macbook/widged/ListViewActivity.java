package com.example.macbook.widged;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListViewActivity extends AppCompatActivity {

    // buat aray trus kasi nama buat d kenang TT_TT
    String [] arraybuah = {"alpukat", "apel", "ceri", "durian","jambuair", "manggis", "strawberri"};
    int[] arraysuara = {R.raw.alpukat, R.raw.hat, R.raw.ceri, R.raw.durian, R.raw.jambuair, R.raw.manggis, R.raw.strawberry};
    int[] arraygambar = {R.drawable.alpukat, R.drawable.apel, R.drawable.ceri, R.drawable.durian, R.drawable.jambuair, R.drawable.manggis, R.drawable.strawberry};


    @BindView(R.id.List)
    ListView List;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        ButterKnife.bind(this);

        /// adapter nya
        ListBuahAdapter adapter = new ListBuahAdapter(this, arraybuah, arraygambar);
        //set adapter
        List.setAdapter(adapter);

        //event ktk item d click
        List.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posisi1, long l) {
                ///supaya ada suaranya
                putarsuara(posisi1);
            }
        });

    }

    private void putarsuara(int posisi1) {

        // biar bunyi
        MediaPlayer mediaPlayer = MediaPlayer.create(this, arraysuara[posisi1]);
        // biar stasrt
        mediaPlayer.start();
    }

    private class ListBuahAdapter extends BaseAdapter {

        // var Global di buat dulu vrohhh biar bisa nampung data konstruktor

        String [] namaBuah;
        int [] gambarBuah;
        Context context;

        //construktor buat nakap data
        public ListBuahAdapter(Context context, String[] arraybuah, int[] arraygambar) {
            // data nya di panggil
            this.namaBuah = arraybuah;
            this.gambarBuah = arraygambar;
            this.context = context;

        }

        @Override
        public int getCount() {
            return namaBuah.length;
        }

        @Override
        public Object getItem(int posisi1) {
            return null;
        }

        @Override
        public long getItemId(int posisi1) {
            return 0;
        }

        @Override
        public View getView(int posisi1, View convertView, ViewGroup parent) {

            View view = convertView;
            LayoutInflater inflater = LayoutInflater.from(context);
            view = inflater.inflate(R.layout.item_buah, null);
            ImageView ivgmbar = (ImageView)view.findViewById(R.id.ivgmbar);
            TextView ivnama = (TextView)view.findViewById(R.id.ivnama);

            ivnama.setText(namaBuah[posisi1]);
            ivgmbar.setImageResource(gambarBuah[posisi1]);
            return view;
        }
    }
}
