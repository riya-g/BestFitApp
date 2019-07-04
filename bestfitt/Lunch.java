package com.example.bestfitt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;

import java.util.ArrayList;

public class Lunch extends AppCompatActivity {

    ArrayList<Integer> selected = new ArrayList<Integer>(3);
    int sum = 0;
    private static final String TAG = "MyActivity";
    public static final String EXTRA_TEXT = "com.example.application.example.EXTRA_TEXT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lunch);

        selected.add(0, 0);
        selected.add(1, 0);
        selected.add(2, 0);
    }
    public void selectItem1(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        if (checked) {
            selected.add(0, 280);
            Log.d(TAG, "The Rice is checked" + String.valueOf(selected.get(0)));
        } else {
            selected.add(0, 0);
            Log.d(TAG, "The Rice is unchecked" + String.valueOf(selected.get(0)));
        }

    }

    public void selectItem2(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        if (checked) {
            selected.add(1, 82);
            Log.d(TAG, "The sauteed vegetable is checked" + String.valueOf(selected.get(1)));
        } else {
            selected.add(1, 0);
            Log.d(TAG, "The sauteed vegetable is unchecked" + String.valueOf(selected.get(1)));
        }
    }

    public void selectItem3(View view) {
        boolean checked = ((CheckBox) view).isChecked();

        if (checked) {
            selected.add(2, 71);
            Log.d(TAG, "The chicken lettuce salad is checked" + String.valueOf(selected.get(2)));
        } else {
            selected.add(2, 0);
            Log.d(TAG, "The chicken lettuce salad is unchecked" + String.valueOf(selected.get(2)));
        }

    }

    public void sendSelected(View view) {
        int i;
        sum = 0;
        for (i = 0; i < 3; i++) {
            sum = sum + selected.get(i);
        }
        Log.d(TAG, String.valueOf(sum));

        openMealTracker();
    }

    private void openMealTracker() {
        String calVal = String.valueOf(sum);
        Intent intent;
        intent = new Intent(Lunch.this, MealTrackerActivity.class);
        intent.putExtra("lunchCal", calVal);
        startActivity(intent);

    }
}
