package com.example.macbook.bangundatar;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.etAlas)
    EditText etAlas;
    @BindView(R.id.etTinggi)
    EditText etTinggi;
    @BindView(R.id.btnCount)
    Button btnCount;
    @BindView(R.id.txtHasil)
    TextView txtHasil;
    @BindView(R.id.btnKirim)
    Button btnKirim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnCount)
    public void onViewClicked() {
        //enable btn krim
        btnKirim.setEnabled(true);


        //validasi input e

        if (etAlas.getText().toString().isEmpty() || etTinggi.getText().toString().isEmpty()) {
            Toast.makeText(this, "jgn Kosong", Toast.LENGTH_SHORT).show();
        } else {
            //ambil nilai dari et
            Double nilaiAlas = Double.parseDouble(etAlas.getText().toString());
            Double nilaiTinggi = Double.parseDouble(etTinggi.getText().toString());
            //hting
            //rumus 1/2 * Alas * Tinggi
            Double hasilHitung = 0.5 * nilaiAlas * nilaiTinggi;
            txtHasil.setText(hasilHitung.toString());

        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // tambah menu

        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    /// untuk menghandle act nya


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        // get id dulu
        int menuId = item.getItemId();
        //fit id
        if (menuId == R.id.MAbout) {
            //alert menu about

            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("about apps");
            alert.setMessage("Dev : ntah \n Ver : Beta ntah siapa.0.1 \n Rils : Barusan ae \n coment : fackx Off ").show();

        } else if (menuId == R.id.MExit) {
            //alert exit
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("Exit");
            alert.setMessage("Serius lu mw Kluar?").show();
            alert.setPositiveButton("Iye bg", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                    // kalo iya kill app dari ram
                    System.exit(0);
                }
            });
            //batal
            alert.setNegativeButton("Kga jadi bg", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                    // kalo kga jadi
                    //biari kosong ae
                }
            });

        }

        return super.onOptionsItemSelected(item);
    }

    @OnClick(R.id.btnKirim)
    public void onBtnKirimClicked() {

        //tampung data var
        String nilaiAlas = etAlas.getText().toString();
        String nilaitinggi = etTinggi.getText().toString();

        String nlaiHasil = txtHasil.getText().toString();

        Intent intent = new Intent(MainActivity.this, HasilActivity.class);

        intent.putExtra("Nilai Alas",nilaiAlas);
        intent.putExtra("Nilai Tinggi",nilaitinggi);
        intent.putExtra("Nilai Hasil",nlaiHasil);

        startActivity(intent);


    }
}









