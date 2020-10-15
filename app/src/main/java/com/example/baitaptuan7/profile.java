package com.example.baitaptuan7;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class profile extends AppCompatActivity {
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        back=findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(profile.this,Login.class);
                startActivity(in);
            }
        });
        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.nav_search);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_home:
                        startActivities(new Intent[]{new Intent(getApplicationContext(), Login.class)});
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.nav_favorites:
                        startActivities(new Intent[]{new Intent(getApplicationContext(),Customlist.class)});
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.nav_search:
                        return true;
                }
                return true;
            }

        });
    }
}