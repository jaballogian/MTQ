package com.example.asus.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import me.anwarshahriar.calligrapher.Calligrapher;

public class RegisterActivity extends AppCompatActivity {

    private TextView daftarMuridTextView;
    private TextView daftarPengajarTextView;
    private TextView daftarAdminTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Calligrapher calligrapher = new Calligrapher(this);
        calligrapher.setFont(this, "KeepCalm-Medium.ttf", true);

        daftarMuridTextView = (TextView) findViewById(R.id.daftarMurid);
        daftarPengajarTextView = (TextView) findViewById(R.id.daftarPengajar);
        daftarAdminTextView = (TextView) findViewById(R.id.daftarAdmin);

        daftarMuridTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent keRegisterAsMuridActivity = new Intent(RegisterActivity.this, RegisterAsMuridActivity.class);
                startActivity(keRegisterAsMuridActivity);
            }
        });

        daftarPengajarTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent keRegisterAsPengajarActivity = new Intent(RegisterActivity.this, RegisterAsPengajarActivity.class);
                startActivity(keRegisterAsPengajarActivity);
            }
        });

        daftarAdminTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent keRegisterAsAdminActivity = new Intent(RegisterActivity.this, RegisterAsAdminMasjidActivity.class);
                startActivity(keRegisterAsAdminActivity);
            }
        });
    }
}
