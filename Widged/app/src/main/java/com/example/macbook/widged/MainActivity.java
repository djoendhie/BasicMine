package com.example.macbook.widged;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btnSpinner)
    Button btnSpinner;
    @BindView(R.id.btnList)
    Button btnList;
    @BindView(R.id.btnMsg)
    Button btnMsg;
    @BindView(R.id.btnView)
    Button btnView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnSpinner)
    public void onBtnSpinnerClicked() {

        startActivity(new Intent(this,SpinnerActivity.class));
    }

    @OnClick(R.id.btnList)
    public void onBtnListClicked() {

        startActivity(new Intent(this,ListViewActivity.class));
    }

    @OnClick(R.id.btnMsg)
    public void onBtnMsgClicked() {

        startActivity(new Intent(this,MessageActivity.class));
    }

    @OnClick(R.id.btnView)
    public void onBtnViewClicked() {
        startActivity(new Intent(this,ViewPagerActivity.class));
    }
}
