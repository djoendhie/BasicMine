package com.example.macbook.widged;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ViewPagerActivity extends AppCompatActivity {

    @BindView(R.id.VPager)
    ViewPager VPager;

    String[] namaBuahs = new SpinnerActivity().namabuah1;
    int[] gmbarBuahs = new SpinnerActivity().gambarbuah1;
    int[] suaraBuahs = new SpinnerActivity().suarabuah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        ButterKnife.bind(this);

        //buat adapter
        ViewPagerAdapter adapter = new ViewPagerAdapter(this, namaBuahs, gmbarBuahs, suaraBuahs);
        // set adapter ke view pager
        VPager.setAdapter(adapter);

    }


    private class ViewPagerAdapter extends PagerAdapter {

        // buat var buat nampung data2 nya
        String[] namaBuah;
        int[] gambarBuah;
        int[] suaraBuah;

        Context context;

        public ViewPagerAdapter(Context cntx, String[] namaBuahs, int[] gmbarBuahs, int[] suaraBuahs) {

            // ninisialisasi var ama data yg d bawa si konstruktor
            this.namaBuah = namaBuahs;
            this.gambarBuah = gmbarBuahs;
            this.suaraBuah = suaraBuahs;
            this.context = cntx;

        }

        @Override
        public int getCount() {
            return namaBuahs.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == ((LinearLayout) object);
        }

        @RequiresApi(api = Build.VERSION_CODES.M)
        @Override
        public Object instantiateItem(ViewGroup container, final int position) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(R.layout.isipager, null);


            //inisialisasi widget
            ImageView ivgmbr = (ImageView) view.findViewById(R.id.Buah);
            TextView ivnama = (TextView) view.findViewById(R.id.buahDuren);

            //set widget
            ivgmbr.setImageResource(gmbarBuahs[position]);
            ivnama.setText(namaBuahs[position]);




            ((ViewPager) container).addView(view);

            ivgmbr.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    suaraputar(position);

                }
            });


            return view;
        }




        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            ((ViewPager) container).removeView((LinearLayout) object);
        }



        }

    private void suaraputar(int position) {
        MediaPlayer mediaPlayer = MediaPlayer.create(this, suaraBuahs[position]);
        mediaPlayer.start();
    }
}



