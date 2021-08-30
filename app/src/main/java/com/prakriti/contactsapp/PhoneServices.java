package com.prakriti.contactsapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PhoneServices extends AppCompatActivity implements View.OnClickListener {

    private static final int CALL = 1; // specfic to a specific button to this project

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_services);

        Button btnDialPad = findViewById(R.id.btnDialPad);
        Button btnGoogle = findViewById(R.id.btnGoogle);
        Button btnUdemy = findViewById(R.id.btnUdemy);
        Button btnCall = findViewById(R.id.btnCall);

        btnCall.setOnClickListener(this);
        btnDialPad.setOnClickListener(this);
        btnGoogle.setOnClickListener(this);
        btnUdemy.setOnClickListener(this);

//        callPermissions(PhoneServices.this);
    }

    public void callPermissions(Activity activity) {
        if(ActivityCompat.checkSelfPermission(activity, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // prompt user if not allowed
            ActivityCompat.requestPermissions(activity, new String[] { Manifest.permission.CALL_PHONE }, CALL);
        }
        else {
            makeACall();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == CALL && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            makeACall();
        }
    }

    private void makeACall() {
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:9898989898")); // format for specifying phone numbers
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnCall:
                callPermissions(this);
                break;

            case R.id.btnGoogle:
                Intent intent = new Intent(Intent.ACTION_WEB_SEARCH); // go to browser
//                intent.setData(Uri.parse("http://www.google.com")); // check usesClearTextTraffic in manifests file
                startActivity(intent);
                break;

            case R.id.btnDialPad:
                startActivity(new Intent(Intent.ACTION_DIAL));
                break;

            case R.id.btnUdemy:
                Intent intentUdemy = new Intent(Intent.ACTION_VIEW); // go to browser
                intentUdemy.setData(Uri.parse("http://www.udemy.com")); // check usesClearTextTraffic in manifests file
                startActivity(intentUdemy);
                break;
        }
    }
}