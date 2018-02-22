package com.example.macbook.projectbasicpertama;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FirstPageActivity extends AppCompatActivity {

    //declare btn
    EditText etUser, etPass;
    Button btnlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);

        etUser = (EditText)findViewById(R.id.etUser);
        etPass = (EditText)findViewById(R.id.etPass);
        btnlogin = (Button) findViewById(R.id.btnlogin);


        //aksi

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = etUser.getText().toString();
                String password = etPass.getText().toString();

                String us = "Admin";
                String pw = "123123";
                if (TextUtils.isEmpty(username)){
                    etUser.setError("username jgn di kacangin");
                    etPass.requestFocus();
                }else if (TextUtils.isEmpty(password)){
                    etPass.setError("password jgn di kacangin");
                    etPass.requestFocus();
                }else if (!us.equals(username)&&!pw.equals(password)){
                    Toast.makeText(FirstPageActivity.this, "Gagal Bro Pfttt", Toast.LENGTH_SHORT).show();
                }else if (us.equals(username)&&pw.equals(password)){
                    Toast.makeText(FirstPageActivity.this, "Ea success ni ye ^_^", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(FirstPageActivity.this, MainActivity.class));
                }
            }
        });
    }
}
