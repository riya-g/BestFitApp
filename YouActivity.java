package com.example.bestfit;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.telecom.Call;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class YouActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_you);

        //Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        //setSupportActionBar(toolbar);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        Menu menu=bottomNav.getMenu();
        MenuItem menuItem=menu.getItem(2);
        menuItem.setChecked(true);



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

               /* case R.id.nav_search:
                    Intent i2=new Intent(YouActivity.this, SearchActivity.class);
                    startActivity(i2);
                    break;
                */
                case R.id.nav_you:
                    return true;
            }

            return true;
        }
    };
//    Call onClickNext() when the button Next is clicked
//    public void onClickNext(View view){
//        Intent intent = new Intent(this,AboutUs.class);
//        startActivity(intent);
//    }
//
//    Call onClickLoc() when the button Loc is clicked
//    public void onClickLoc(View view){
//        Intent intent = new Intent(this,LocationActivity.class);
//        startActivity(intent);
//    }



}

