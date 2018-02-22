package com.example.macbook.projectbasicpertama;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "tampilan Oncreate", Toast.LENGTH_SHORT).show();
        Log.d("lc", "onCreate: ");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "tampilan star", Toast.LENGTH_SHORT).show();
        Log.d("lc", "stadr: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "tampilan stop", Toast.LENGTH_SHORT).show();
        Log.d("lc", "stop: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "tampilan resume", Toast.LENGTH_SHORT).show();
        Log.d("lc", "resume: ");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "tampilan pause", Toast.LENGTH_SHORT).show();
        Log.d("lc", "pause: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "tampilan destroy", Toast.LENGTH_SHORT).show();
        Log.d("lc", "destroy: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "tampilan restar", Toast.LENGTH_SHORT).show();
        Log.d( "lc", "restart: ");
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("konfirm keluar");
        builder.setMessage("yakin lo kluar?");
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setPositiveButton("iye", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                moveTaskToBack(true);
                System.exit(0);
            }
        });

        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        builder.show();
    }
}
