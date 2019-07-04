package com.example.quickpicktick;
//Note add login logout part
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class YouActivity extends AppCompatActivity {

    private View profile,location,about,help,logout;
    private Button signin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_you);

        profile=findViewById(R.id.profile_layout);
        location = findViewById(R.id.location_layout);
        about = findViewById(R.id.about_us_layout);
        help = findViewById(R.id.help_layout);
        logout=findViewById(R.id.logout_layout);
        signin=findViewById(R.id.signin);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        Menu menu=bottomNav.getMenu();
        MenuItem menuItem=menu.getItem(2);
        menuItem.setChecked(true);

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(YouActivity.this,ProfileActivity.class);
                startActivity(i);
            }
        });
        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLocation();
            }
        });

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAbout();
            }
        });

        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHelp();
            }
        });
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(YouActivity.this,LoginActivity.class);
                startActivity(i);
            }
        });
    }

    private void openLocation() {
        Intent i = new Intent(this,LocationActivity.class);
        startActivity(i);
    }

    private void openHelp() {
        Intent i = new Intent(this,HelpActivity.class);
        startActivity(i);
    }

    private void openAbout() {
        Intent i = new Intent(this,AboutUs.class);
        startActivity(i);
    }

    @Override
    public void onBackPressed() { }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;
            switch(item.getItemId()){
                case R.id.nav_home:
                    Intent i1=new Intent(YouActivity.this,HomeActivity.class);
                    startActivity(i1);
                    break;

                case R.id.nav_search:
                    Intent i2=new Intent(YouActivity.this, SearchActivity.class);
                    startActivity(i2);
                    break;

                case R.id.nav_you:
                    return true;
            }


            return true;
        }
    };


}