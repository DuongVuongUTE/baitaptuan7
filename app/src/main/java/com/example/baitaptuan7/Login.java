package com.example.baitaptuan7;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Login extends AppCompatActivity implements View.OnClickListener {
    private Button button;
    TextView r;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        button = findViewById(R.id.button);
        button.setOnClickListener(this);
        r=findViewById(R.id.register);
        r.setOnClickListener(this);
        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.nav_home);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_favorites:
                        startActivities(new Intent[]{new Intent(getApplicationContext(), Customlist.class)});
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.nav_home:
                        return true;
                    case R.id.nav_search:
                        startActivities(new Intent[]{new Intent(getApplicationContext(),profile.class)});
                        overridePendingTransition(0,0);
                        return true;
                }
                return true;
            }

        });
    }

    @Override
    public void onClick(View v) {
        if (v==r){
            Intent intent=new Intent(Login.this,register.class);
            startActivity(intent);
        }
        if (v==button){
            Intent intent=new Intent(Login.this,Customlist.class);
            startActivity(intent);
        }
    }



}