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
    private TextView text1;
    private TextView text2;
    private TextView text3;
    private TextView text4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_tracker);

        Intent intent = getIntent();
        final String breakfastCalories = intent.getStringExtra("breakfastCal");
        final String lunchCalories = intent.getStringExtra("lunchCal");
        final String snacksCalories = intent.getStringExtra("snackCal");
        final String dinnerCalories = intent.getStringExtra("dinnerCal");

        text1 = (TextView) findViewById(R.id.text1);
        text1.setText(breakfastCalories);

        text2 = (TextView) findViewById(R.id.text2);
        text2.setText(lunchCalories);

        text3 = (TextView) findViewById(R.id.text3);
        text3.setText(snacksCalories);

        text4 = (TextView) findViewById(R.id.text4);
        text4.setText(dinnerCalories);

        breakfast = (Button) findViewById(R.id.breakfast);
        snacks = (Button) findViewById(R.id.snacks);
        lunch = (Button) findViewById(R.id.lunch);
        dinner = (Button) findViewById(R.id.dinner);


        breakfast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBreakfast();
            }

            public void openBreakfast() {

                Intent intent = new Intent(MealTrackerActivity.this, Breakfast.class);
                startActivity(intent);
            }

        });
        submit = (Button) findViewById(R.id.submit);

        snacks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSnacks();
            }

            public void openSnacks() {

                Intent intent = new Intent(MealTrackerActivity.this, Snacks.class);
                startActivity(intent);
            }

        });


        lunch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLunch();
            }

            public void openLunch() {

                Intent intent = new Intent(MealTrackerActivity.this, Lunch.class);
                startActivity(intent);
            }
        });


        dinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDinner();
            }

            public void openDinner() {

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
                int breakCal = 0, dinnerCal = 0, lunchCal = 0, snacksCal = 0;
                String breakfast = text1.getText().toString();

                if (!breakfast.equals("") /*&& !breakfast.equals(......)*/) {
                    breakCal = Integer.parseInt(breakfast);
                }

                String lunch = text2.getText().toString();

                if (!lunch.equals("") /*&& !lunch.equals(......)*/) {
                    lunchCal = Integer.parseInt(lunch);
                }

                String snacks = text3.getText().toString();

                if (!snacks.equals("")/* && !breakfast.equals(......)*/) {
                    snacksCal = Integer.parseInt(snacks);
                }

                String dinner = text4.getText().toString();

                if (!dinner.equals("")/* && !breakfast.equals(......)*/) {
                    dinnerCal = Integer.parseInt(dinner);
                }

                int totalCal = breakCal + lunchCal + snacksCal + dinnerCal;
                String totCal = String.valueOf(totalCal);
                Intent intent;
                intent = new Intent(MealTrackerActivity.this, TargetActivity.class);
                intent.putExtra("totalCalories", totCal);
                startActivity(intent);
            }
        });


    }
}
