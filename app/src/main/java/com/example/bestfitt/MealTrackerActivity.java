package com.example.bestfitt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MealTrackerActivity extends AppCompatActivity {

    private Button breakfast;
    private Button snacks;
    private Button lunch;
    private Button dinner;
    private Button submit;
    private TextView text;


    public static final String EXTRA_TEXT = "com.example.application.example.EXTRA_TEXT";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_tracker);

        Intent intent = getIntent();
        final String breakfastCalories = intent.getStringExtra(Breakfast.EXTRA_TEXT);
        final String snacksCalories = intent.getStringExtra(Snacks.EXTRA_TEXT);
        final String lunchCalories = intent.getStringExtra(Lunch.EXTRA_TEXT);
        final String dinnerCalories = intent.getStringExtra(Dinner.EXTRA_TEXT);

        text = (TextView) findViewById (R.id.text);
        text.setText(breakfastCalories+snacksCalories+lunchCalories+dinnerCalories);

        breakfast = (Button) findViewById(R.id.breakfast);
        snacks = (Button) findViewById(R.id.snacks);
        lunch = (Button) findViewById(R.id.lunch);
        dinner = (Button) findViewById(R.id.dinner);






        breakfast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }

            public void openActivity2(){

                Intent intent = new Intent(MealTrackerActivity.this, Breakfast.class);
                startActivity(intent);
            }

        });
        submit = (Button) findViewById(R.id.submit);

        snacks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity3();
            }
            public void openActivity3(){

                Intent intent = new Intent(MealTrackerActivity.this, Snacks.class);
                startActivity(intent);
            }

         });


         lunch.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 openActivity4();
             }
             public void openActivity4(){

                 Intent intent = new Intent(MealTrackerActivity.this, Lunch.class);
                 startActivity(intent);
             }
         });


        dinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity5();
            }
            public void openActivity5(){

                Intent intent = new Intent(MealTrackerActivity.this, Dinner.class);
                startActivity(intent);
            }


         });


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTargetActivity();
            }

            public void openTargetActivity() {

                String calVal = text.getText().toString();
                Intent intent;
                intent = new Intent(MealTrackerActivity.this,TargetActivity.class);
                intent.putExtra(EXTRA_TEXT,calVal);
                startActivity(intent);
            }
        });


    }
}
