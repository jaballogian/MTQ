package com.example.asus.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import me.anwarshahriar.calligrapher.Calligrapher;

public class ProfilPengajarIkhwanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil_pengajar_ikhwan);

        Calligrapher calligrapher = new Calligrapher(this);
        calligrapher.setFont(this, "KeepCalm-Medium.ttf", true);

    }
}
