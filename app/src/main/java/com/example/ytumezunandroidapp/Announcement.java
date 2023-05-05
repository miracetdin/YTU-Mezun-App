package com.example.ytumezunandroidapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Announcement extends AppCompatActivity {

    Button bt_profile, bt_announcement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_announcement);

        bt_profile = (Button) findViewById(R.id.mb_profile);
        bt_announcement = (Button) findViewById(R.id.mb_announcement);

        // Duyuru listesinin oluşturulması
        ArrayList<AnnouncementModel> announcementList = new ArrayList<>();

        announcementList.add(new AnnouncementModel(R.drawable.announcement, "Header 1", "16.03.2023"));
        announcementList.add(new AnnouncementModel(R.drawable.ytu_logo, "Header 2", "19.03.2023"));
        announcementList.add(new AnnouncementModel(R.drawable.announcement, "Header 3", "24.03.2023"));
        announcementList.add(new AnnouncementModel(R.drawable.ytu_logo, "Header 4", "31.03.2023"));
        announcementList.add(new AnnouncementModel(R.drawable.ytu_logo, "Header 5", "02.04.2023"));

        AnnouncementAdapter adapter = new AnnouncementAdapter(announcementList, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        bt_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Profile.class);
                startActivity(intent);
            }
        });

        bt_announcement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Announcement.this, "Duyuru ekranındasınız!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
