package com.example.asus.myapplication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import me.anwarshahriar.calligrapher.Calligrapher;

public class RegisterAsAdminMasjidActivity extends AppCompatActivity {

    private TextView mDaftar;

    private EditText mNamaLengkapAdmin, mNomorHPAdmin, mNamaLengkapMasjid, mLokasiMasjid, mNomorKontakMasjid,
            mEmail, mWeb, mFacebook, mTwitter, mInstagram, mKodeVerifikasiMasjid, mUsername, mPassword, mUlangiPassword;

    private FirebaseAuth mAuth;

    private ProgressDialog mProgress;

    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_as_admin_masjid);

        Calligrapher calligrapher = new Calligrapher(this);
        calligrapher.setFont(this, "KeepCalm-Medium.ttf", true);

        mDaftar = (TextView) findViewById(R.id.daftarTextView);

        mNamaLengkapAdmin = (EditText) findViewById(R.id.namaLengkapAdminEditText);
        mNomorHPAdmin = (EditText) findViewById(R.id.nomorHPAdminEditText);
        mNamaLengkapMasjid = (EditText) findViewById(R.id.namaLengkapMasjidEditText);
        mLokasiMasjid = (EditText) findViewById(R.id.lokasiMasjidEditText);
        mNomorKontakMasjid = (EditText) findViewById(R.id.nomorKontakMasjidEditText);
        mEmail = (EditText) findViewById(R.id.emailMasjidEditText);
        mWeb = (EditText) findViewById(R.id.webMasjidEditText);
        mFacebook = (EditText) findViewById(R.id.facebookMasjidEditText);
        mTwitter = (EditText) findViewById(R.id.twitterMasjidEditText);
        mInstagram = (EditText) findViewById(R.id.instagramMasjidEditText);
        mKodeVerifikasiMasjid = (EditText) findViewById(R.id.kodeVerifikasiMasjidEditText);
        mUsername = (EditText) findViewById(R.id.usernameMasjidEditText);
        mPassword = (EditText) findViewById(R.id.passwordMasjidEditText);
        mUlangiPassword = (EditText) findViewById(R.id.ulangiPasswordMasjidEditText);

        mAuth = FirebaseAuth.getInstance();

        mProgress = new ProgressDialog(this);

        mDatabase = FirebaseDatabase.getInstance().getReference().child("User Admin Masjid");

        mDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startRegister();
            }
        });

    }

    private void startRegister() {

        final String namaLengkapAdmin = mNamaLengkapAdmin.getText().toString().trim();
        final String nomorHPAdmin = mNomorHPAdmin.getText().toString().trim();
        final String namaLengkapMasjid = mNamaLengkapMasjid.getText().toString().trim();
        final String lokasiMasjid = mLokasiMasjid.getText().toString().trim();
        final String nomorKontakMasjid = mNomorKontakMasjid.getText().toString().trim();
        final String email = mEmail.getText().toString().trim();
        final String web = mWeb.getText().toString().trim();
        final String facebook = mFacebook.getText().toString().trim();
        final String twitter = mTwitter.getText().toString().trim();
        final String instagram = mInstagram.getText().toString().trim();
        final String kodeVerfikasiMasjid = mKodeVerifikasiMasjid.getText().toString().trim();
        final String username = mUsername.getText().toString().trim();
        final String password = mPassword.getText().toString().trim();
        final String ulangiPassword = mUlangiPassword.getText().toString().trim();

        if(TextUtils.isEmpty(namaLengkapAdmin) || TextUtils.isEmpty(nomorHPAdmin) || TextUtils.isEmpty(namaLengkapMasjid) ||
                TextUtils.isEmpty(lokasiMasjid) || TextUtils.isEmpty(nomorKontakMasjid) || TextUtils.isEmpty(kodeVerfikasiMasjid) ||
                TextUtils.isEmpty(username) || TextUtils.isEmpty(password) || TextUtils.isEmpty(ulangiPassword)) {

            Toast.makeText(RegisterAsAdminMasjidActivity.this, "Data yang  bersifat wajib belum diisi semua", Toast.LENGTH_LONG).show();

        }
        else {

            if(password.equals(ulangiPassword)){

                mProgress.setMessage("Data sedang didaftarkan");
                mProgress.show();

                mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task.isSuccessful()){

                            String userID = mAuth.getCurrentUser().getUid();

                            DatabaseReference currentUserDatabase = mDatabase.child(userID);
                            currentUserDatabase.child("Nama Lengkap Admin").setValue(namaLengkapAdmin);
                            currentUserDatabase.child("Nomor HP Admin").setValue(nomorHPAdmin);
                            currentUserDatabase.child("Nama Lengkap Masjid").setValue(namaLengkapMasjid);
                            currentUserDatabase.child("Lokasi Masjid").setValue(lokasiMasjid);
                            currentUserDatabase.child("Nomor Kontak Masjid").setValue(nomorKontakMasjid);
                            currentUserDatabase.child("Email Masjid").setValue(email);
                            currentUserDatabase.child("Web Masjid").setValue(web);
                            currentUserDatabase.child("Facebook Madjid").setValue(facebook);
                            currentUserDatabase.child("Twitter Masjid").setValue(twitter);
                            currentUserDatabase.child("Instagram Masjid").setValue(instagram);
                            currentUserDatabase.child("Kode Verifikasi Masjid").setValue(kodeVerfikasiMasjid);
                            currentUserDatabase.child("Username").setValue(username);
                            currentUserDatabase.child("Password").setValue(password);
                            currentUserDatabase.child("Ulangi Password").setValue(ulangiPassword);

                            mProgress.dismiss();

                            Intent keMainActivity = new Intent(RegisterAsAdminMasjidActivity.this, MainActivity.class);
                            startActivity(keMainActivity);
                        }
                    }
                });

            }
            else {

                Toast.makeText(RegisterAsAdminMasjidActivity.this, "Konfirmasi ulangi password salah", Toast.LENGTH_LONG).show();
            }


        }
    }
}
