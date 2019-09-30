package com.example.biodatagr;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button call_btn, maill_btn, alm_btn, flw_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        call_btn = (Button)findViewById(R.id.call);
        maill_btn = (Button)findViewById(R.id.email);
        alm_btn = (Button)findViewById(R.id.alamat);
        flw_btn = (Button)findViewById(R.id.follow_me);
    }

    public void call(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:082322597622"));
        startActivity(intent);
    }

    @SuppressLint("LongLogTag")
    public void mail(View view) {
        Log.i("Send email", "");

        String[] TO = {"bayugrafit@gmail.com"};
        String[] CC = {"nbayugrafit@gmail.com"};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");

        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "tugas pemrograman perangkat bergerak");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "tugas pemrograman perangkat bergerak seleai");
        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            finish();
            Log.i("menyelesaikan pengiriman email", "");
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(MainActivity.this,
                    "tidak ada email tujuan", Toast.LENGTH_SHORT).show();
        }

    }

    public void alamat(View view) {

    }

    public void follow(View view) {
    }
}
