package com.example.bestfitt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

public class Breakfast extends AppCompatActivity {

    public Button plus1;
    public Button minus1;
    public TextView amt1;
    public Button plus2;
    public Button minus2;
    public TextView amt2;

    ArrayList<Integer> selected = new ArrayList<Integer>(3);
    int sum = 0;
    int quantity1 = 0;
    int quantity2 = 0;
    int val1 = 1;
    int val2 = 1;
    private static final String TAG = "MyActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breakfast);
        selected.add(0, 0);
        selected.add(1, 0);
        selected.add(2, 0);

        amt1 = (TextView) findViewById(R.id.Amt1);
        plus1 = (Button) findViewById(R.id.plus1);
        minus1 = (Button) findViewById(R.id.minus1);

        amt2 = (TextView) findViewById(R.id.Amt2);
        plus2 = (Button) findViewById(R.id.plus2);
        minus2 = (Button) findViewById(R.id.minus2);

        plus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantity1 = quantity1 + 1;
                Log.d(TAG,String.valueOf(quantity1));

                amt1.setText("" + quantity1);
                if (quantity1 >= 1) {
                    minus1.setEnabled(true);
                } else {
                    minus1.setEnabled(false);
                }

            }

        });

        minus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantity1 = quantity1 - 1;
                amt1.setText("" + quantity1);
                if (quantity1 >= 1) {
                    minus1.setEnabled(true);
                } else {
                    minus1.setEnabled(false);
                }

            }
        });

        plus2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantity2 = quantity2 + 1;
                Log.d(TAG,String.valueOf(quantity2));

                amt2.setText("" + quantity2);
                if (quantity2 >= 1) {
                    minus2.setEnabled(true);
                } else {
                    minus2.setEnabled(false);
                }

            }

        });

        minus2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantity2 = quantity2 - 1;
                amt2.setText("" + quantity2);
                if (quantity2 >= 1) {
                    minus2.setEnabled(true);
                } else {
                    minus2.setEnabled(false);
                }

            }
        });



    }

    public void selectItem1(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        if (checked) {
            selected.add(0, 115);

        } else {
            selected.add(0, 0);

        }
    }

    public void selectItem2(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        if (checked) {
            plus1.setEnabled(true);
            minus1.setEnabled(true);
            Log.d(TAG,String.valueOf(quantity1));

        } else {
            plus1.setEnabled(false);
            minus1.setEnabled(false);
            quantity1 = 0;
            amt1.setText(""+quantity1);
            selected.add(0, 0);

        }

    }

    public void selectItem3(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        if (checked) {
            plus2.setEnabled(true);
            minus2.setEnabled(true);
           // Log.d(TAG,String.valueOf(quantity1));

        } else {
            plus2.setEnabled(false);
            minus2.setEnabled(false);
            quantity2 = 0;
            amt2.setText(""+quantity2);
            selected.add(0, 0);

        }
    }

    public void sendSelected(View view) {
        int i;
        sum = 0;
        val1 = quantity1 * 86;
        val2 = quantity2 * 136;
        selected.add(1, val1);
        selected.add(2,val2);
        for (i = 0; i < 3; i++) {
            sum = sum + selected.get(i);
        }
        Log.d(TAG, String.valueOf(sum));

        openMealTracker();
    }

    private void openMealTracker() {
        String calVal = String.valueOf(sum);
        Intent intent;
        intent = new Intent(Breakfast.this, MealTrackerActivity.class);
        intent.putExtra("breakfastCal", calVal);
        startActivity(intent);
    }

}

