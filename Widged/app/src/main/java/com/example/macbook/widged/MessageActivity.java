package com.example.macbook.widged;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MessageActivity extends AppCompatActivity {

    @BindView(R.id.btnToast)
    Button btnToast;
    @BindView(R.id.btnAlert)
    Button btnAlert;
    @BindView(R.id.btnCstm)
    Button btnCstm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnToast)
    public void onBtnToastClicked() {
        Toast.makeText(this, "Ini Toast kan?", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.btnAlert)
    public void onBtnAlertClicked() {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
    }

    @OnClick(R.id.btnCstm)
    public void onBtnCstmClicked() {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Info Buah");

        //set costum view
        View view = getLayoutInflater().inflate(R.layout.alert_view, null);
        alert.setView(view);
        //declare inisialisasi dalam alert
        ImageView imgalert = (ImageView)view.findViewById(R.id.gambarBuah);
        TextView lblBuah = (TextView) view.findViewById(R.id.lblBuah);
        //biar nampak
        lblBuah.setText("pokat adalah jenis buah enak buat di jus brooo");
        imgalert.setImageResource(R.drawable.alpukat);
        //supaya muncul
        alert.show();

    }
}
