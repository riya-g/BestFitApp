package com.example.bestfitt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TargetActivity extends AppCompatActivity {

    public TextView caloriesGained;
    public TextView totalCalories;
    public TextView AmtOfWater;
    public Button plus;
    public Button minus;

    int quantity = 0;
    //private static final String TAG = "MyActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_target);

        Intent intent = getIntent();
        final String calorieGain = intent.getStringExtra("totalCalories");

        caloriesGained = (TextView) findViewById (R.id.calories);
        caloriesGained.setText(calorieGain);

        totalCalories = (TextView) findViewById (R.id.total);
        totalCalories.setText(calorieGain);

        AmtOfWater = (TextView) findViewById(R.id.AmtOfWater);
        plus = (Button) findViewById(R.id.plus);
        minus = (Button) findViewById(R.id.minus);

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantity = quantity + 1;
                AmtOfWater.setText("" + quantity);
                if(quantity >= 1){
                    minus.setEnabled(true);
                }
                else{
                    minus.setEnabled(false);
                }
            }

        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quantity > 1){
                    minus.setEnabled(true);
                }
                else{
                    minus.setEnabled(false);
                }
                quantity = quantity - 1;
                AmtOfWater.setText("" + quantity);
            }
        });


    }

}
