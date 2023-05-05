package com.example.ytumezunandroidapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Profile extends AppCompatActivity {

    TextView name, surname, birthDate, graduateDate, mail, username, password;
    ImageView photo;
    Button bt_profile, bt_announcement;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_profile);

        name = (TextView) findViewById(R.id.tv_pr_name);
        surname = (TextView) findViewById(R.id.tv_pr_surname);
        birthDate = (TextView) findViewById(R.id.tv_pr_birthdatedata);
        graduateDate = (TextView) findViewById(R.id.tv_pr_graduatedatedata);
        mail = (TextView) findViewById(R.id.tv_pr_maildata);
        username = (TextView) findViewById(R.id.tv_pr_usernamedata);
        password = (TextView) findViewById(R.id.tv_pr_passworddata);
        photo = (ImageView) findViewById(R.id.iv_pr_profilephoto);

        bt_profile = (Button) findViewById(R.id.mb_profile);
        bt_announcement = (Button) findViewById(R.id.mb_announcement);

        bt_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Profile.this, "Profil ekranındasınız!", Toast.LENGTH_SHORT).show();
            }
        });

        bt_announcement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Announcement.class);
                startActivity(intent);
            }
        });
    }
}