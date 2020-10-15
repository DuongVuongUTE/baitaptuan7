package com.example.baitaptuan7;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Customlist extends AppCompatActivity {
    ListView listview;
    ImageView back;
    String sTitle[] = {"SPKT Đà Nẵng", "BK Đà Nẵng", "NN Đà Nẵng", "SP Đà Nẵng", "KT Đà Nẵng","SPKT Đà Nẵng", "BK Đà Nẵng", "NN Đà Nẵng", "SP Đà Nẵng", "KT Đà Nẵng"};
    String sDescription[] = {"ĐH SPKT Đà Nẵng", "ĐH Bách Khoa Đà Nẵng", "ĐH Ngoại Ngữ Đà Nẵng", "ĐH Sư Phạm Đà Nẵng", "ĐH Kinh Tế Đà Nẵng","ĐH SPKT Đà Nẵng", "ĐH Bách Khoa Đà Nẵng", "ĐH Ngoại Ngữ Đà Nẵng", "ĐH Sư Phạm Đà Nẵng", "ĐH Kinh Tế Đà Nẵng"};
    int sImage[] = {R.drawable.utelogo, R.drawable.logo_bkdn, R.drawable.ngoaingu, R.drawable.supham, R.drawable.kinhte,R.drawable.utelogo, R.drawable.logo_bkdn, R.drawable.ngoaingu, R.drawable.supham, R.drawable.kinhte};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customlist);
        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.nav_favorites);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_home:
                        startActivities(new Intent[]{new Intent(getApplicationContext(), Login.class)});
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.nav_favorites:
                        return true;
                    case R.id.nav_search:
                        startActivities(new Intent[]{new Intent(getApplicationContext(),profile.class)});
                        overridePendingTransition(0,0);
                        return true;
                }
                return true;
            }

        });
        listview = findViewById(R.id.listview);
        myAdapter adapter = new myAdapter(this, sTitle, sDescription, sImage);
        back=findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(Customlist.this,profile.class);
                startActivity(in);
            }
        });
        listview.setAdapter(adapter);
    }
    class myAdapter extends ArrayAdapter<String> {
        Context context;
        String gtitle[];
        String gdescription[];
        int gimage[];

        myAdapter(Customlist c, String[] title, String[] description, int[] image) {
            super(c, R.layout.row, R.id.textView1, title);
            this.context = c;
            this.gtitle = title;
            this.gdescription = description;
            this.gimage = image;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row, parent, false);
            ImageView image = row.findViewById(R.id.imageView);
            TextView myTitle = row.findViewById(R.id.textView1);
            TextView myDiscription = row.findViewById(R.id.textView2);

            image.setImageResource(gimage[position]);
            myTitle.setText(gtitle[position]);
            myDiscription.setText(gdescription[position]);

            return row;
        }
    }
}
