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

public class RegisterAsPengajarActivity extends AppCompatActivity {

    private TextView mDaftar;

    private EditText mNamaLengkapPengajar, mTempatLahirPengajar, mTanggalLahirPengajar, mNomorHPPengajar,
            mEmailPengajar, mPendidikanTerakhir, mPekerjaanUtama, mMitraPengajar, mKodeVerifikasiMitra, mStatusPengajar,
            mLinePengajar, mFacebookPengajar, mTwitterPengajar, mInstagramPengajar, mUsernamePengajar, mPasswordPengajar,
            mUlangiPasswordPengajar;

    private CheckBox mIkhwanPengajar, mAkhwatPengajar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_as_pengajar);

        Calligrapher calligrapher = new Calligrapher(this);
        calligrapher.setFont(this, "KeepCalm-Medium.ttf", true);

        mDaftar = (TextView) findViewById(R.id.daftarTextView);

        mNamaLengkapPengajar = (EditText) findViewById(R.id.namaLengkapPengajarEditText);
        mTempatLahirPengajar = (EditText) findViewById(R.id.tempatLahirPengajarEditText);
        mTanggalLahirPengajar = (EditText) findViewById(R.id.tanggalLahirPengajarEditText);
        mNomorHPPengajar = (EditText) findViewById(R.id.nomorHPPengajarEditText);
        mEmailPengajar = (EditText) findViewById(R.id.emailPengajarEditText);
        mPendidikanTerakhir = (EditText) findViewById(R.id.pendidikanTerakhirPengajarEditText);
        mPekerjaanUtama = (EditText) findViewById(R.id.pekerjaanUtamaPengajarEditText);
        mMitraPengajar = (EditText) findViewById(R.id.mitraEditText);
        mKodeVerifikasiMitra = (EditText) findViewById(R.id.kodeVerifikasiMitraEditText);
        mStatusPengajar = (EditText) findViewById(R.id.statusPengajarEditText);
        mLinePengajar = (EditText) findViewById(R.id.linePengajarEditText);
        mFacebookPengajar = (EditText) findViewById(R.id.facebookPengajarEditText);
        mTwitterPengajar = (EditText) findViewById(R.id.twitterPengajarEditText);
        mInstagramPengajar = (EditText) findViewById(R.id.instagramPengajarEditText);
        mUsernamePengajar = (EditText) findViewById(R.id.usernamePengajarEditText);
        mPasswordPengajar = (EditText) findViewById(R.id.passwordPengajarEditText);
        mUlangiPasswordPengajar = (EditText) findViewById(R.id.ulangiPasswordPengajarEditText);

        mIkhwanPengajar = (CheckBox) findViewById(R.id.ikhwanPengajarCheckBox);
        mAkhwatPengajar = (CheckBox) findViewById(R.id.akhwatPengajarCheckBox);


        mDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                starRegister();

            }
        });
    }

    private void starRegister() {
        String nama = mNamaLengkapPengajar.getText().toString().trim();
        String tempatLahir = mTempatLahirPengajar.getText().toString().trim();
        String tanggalLahir = mTanggalLahirPengajar.getText().toString().trim();
        String nomorHP = mNomorHPPengajar.getText().toString().trim();
        String email = mEmailPengajar.getText().toString().trim();
        String pendidikanTerakhir = mPendidikanTerakhir.getText().toString().trim();
        String pekerjaanUtama = mPekerjaanUtama.getText().toString().trim();
        String mitraPengajar = mMitraPengajar.getText().toString().trim();
        String kodeVerifikasiMitra = mKodeVerifikasiMitra.getText().toString().trim();
        String statusPengajar = mStatusPengajar.getText().toString().trim();
        String linePengajar = mLinePengajar.getText().toString().trim();
        String facebookPengajar = mFacebookPengajar.getText().toString().trim();
        String twitterPengajar = mTwitterPengajar.getText().toString().trim();
        String instagramPengajar = mInstagramPengajar.getText().toString().trim();
        String usernamePengajar = mUsernamePengajar.getText().toString().trim();
        String passwordPengajar = mPasswordPengajar.getText().toString().trim();
        String ulangiPasswordPengajar = mUlangiPasswordPengajar.getText().toString().trim();

        String ikhwanPengajar = mIkhwanPengajar.getText().toString().trim();
        String akhwatPengajar = mAkhwatPengajar.getText().toString().trim();

        if(TextUtils.isEmpty(nama) || TextUtils.isEmpty(tempatLahir) || TextUtils.isEmpty(tanggalLahir) ||
                TextUtils.isEmpty(nomorHP) || TextUtils.isEmpty(email) || TextUtils.isEmpty(pendidikanTerakhir) ||
                TextUtils.isEmpty(pekerjaanUtama) || TextUtils.isEmpty(mitraPengajar) || TextUtils.isEmpty(kodeVerifikasiMitra) ||
                TextUtils.isEmpty(usernamePengajar) || TextUtils.isEmpty(passwordPengajar) || TextUtils.isEmpty(ulangiPasswordPengajar)) {

            Toast.makeText(RegisterAsPengajarActivity.this, "Data yang  bersifat wajib belum diisi semua", Toast.LENGTH_LONG).show();


        }
        else {

            if(passwordPengajar.equals(ulangiPasswordPengajar)){

                Intent keMainActivity = new Intent(RegisterAsPengajarActivity.this, MainActivity.class);
                startActivity(keMainActivity);

            }
            else {

                Toast.makeText(RegisterAsPengajarActivity.this, "Konfirmasi ulangi password salah", Toast.LENGTH_LONG).show();
            }


        }
    }
}
