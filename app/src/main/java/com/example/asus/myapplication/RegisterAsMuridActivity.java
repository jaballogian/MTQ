package com.example.asus.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import me.anwarshahriar.calligrapher.Calligrapher;

public class RegisterAsMuridActivity extends AppCompatActivity {

    private TextView mDaftar;

    private EditText mNama, mTempatLahir, mTanggalLahir, mNomorHP, mEmail, mStatus, mLine, mFacebook, mTwitter, mInstagram,
            mUsername, mPassword, mUlangipassword;

    private CheckBox mIkhwan, mAkhwat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_as_murid);

        Calligrapher calligrapher = new Calligrapher(this);
        calligrapher.setFont(this, "KeepCalm-Medium.ttf", true);

        mDaftar = (TextView) findViewById(R.id.daftarTextView);

        mNama = (EditText) findViewById(R.id.namaLengkapMuridEditText);
        mTempatLahir = (EditText) findViewById(R.id.tempatLahirMuridEditText);
        mTanggalLahir = (EditText) findViewById(R.id.tanggalLahirMuridEditText);
        mNomorHP = (EditText) findViewById(R.id.nomorHPMuridEditText);
        mEmail = (EditText) findViewById(R.id.emailMuridEditText);
        mStatus = (EditText) findViewById(R.id.statusMuridEditText);
        mLine = (EditText) findViewById(R.id.lineMuridEditText);
        mFacebook = (EditText) findViewById(R.id.facebookMuridEditText);
        mTwitter = (EditText) findViewById(R.id.twitterMuridEditText);
        mInstagram = (EditText) findViewById(R.id.instagramMuridEditText);
        mUsername = (EditText) findViewById(R.id.usernameMuridEditText);
        mPassword = (EditText) findViewById(R.id.passwordMuridEditText);
        mUlangipassword = (EditText) findViewById(R.id.ulangiPasswordMuridEditText);

        mIkhwan = (CheckBox) findViewById(R.id.ikhwanMuridCheckBox);
        mAkhwat = (CheckBox) findViewById(R.id.akhwatMuridCheckBox);


        mDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startRegister();

            }
        });
    }

    private void startRegister() {
        String nama = mNama.getText().toString().trim();
        String tempatLahir = mTempatLahir.getText().toString().trim();
        String tanggalLahir = mTanggalLahir.getText().toString().trim();
        String nomorHP = mNomorHP.getText().toString().trim();
        String email = mEmail.getText().toString().trim();
        String status = mStatus.getText().toString().trim();
        String line = mLine.getText().toString().trim();
        String facebook = mFacebook.getText().toString().trim();
        String twitter = mTwitter.getText().toString().trim();
        String instagram = mInstagram.getText().toString().trim();
        String username = mUsername.getText().toString().trim();
        String password = mPassword.getText().toString().trim();
        String ulangiPassword = mUlangipassword.getText().toString().trim();

        String ikhwan = mIkhwan.getText().toString().trim();
        String akhwat = mAkhwat.getText().toString().trim();

        if(TextUtils.isEmpty(nama) || TextUtils.isEmpty(tempatLahir) || TextUtils.isEmpty(tanggalLahir) ||
                TextUtils.isEmpty(nomorHP) || TextUtils.isEmpty(email) || TextUtils.isEmpty(username) ||
                TextUtils.isEmpty(password) || TextUtils.isEmpty(ulangiPassword)) {

            Toast.makeText(RegisterAsMuridActivity.this, "Data yang  bersifat wajib belum diisi semua", Toast.LENGTH_LONG).show();


        }
        else {

            if(password.equals(ulangiPassword)){

                Intent keMainActivity = new Intent(RegisterAsMuridActivity.this, MainActivity.class);
                startActivity(keMainActivity);

            }
            else {

                Toast.makeText(RegisterAsMuridActivity.this, "Konfirmasi ulangi password salah", Toast.LENGTH_LONG).show();
            }


        }
    }
}
