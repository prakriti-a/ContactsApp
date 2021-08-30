package com.prakriti.contactsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.QuickContactBadge;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        QuickContactBadge badge = findViewById(R.id.badge);
            // this class extends ImageView
        badge.assignContactFromPhone("9898989898", true);
    }

    public void accessPhoneServices(View v) {
        startActivity(new Intent(this, PhoneServices.class));
    }
}