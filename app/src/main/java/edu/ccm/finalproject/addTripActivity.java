package edu.ccm.finalproject;

import static edu.ccm.finalproject.MainActivity.theCar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class addTripActivity extends AppCompatActivity {

    private EditText mMilesTraveledInputText;
    private EditText mGasConsumedInputText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_trip);
    }

    public void backButtonClick(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void submitButtonClick(View view){
        Intent intent = new Intent(this, MainActivity.class);

        SharedPreferences defaultSharedPref = getSharedPreferences("storage",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = defaultSharedPref.edit();

        mMilesTraveledInputText = findViewById(R.id.milesTraveledInputText);
        mGasConsumedInputText = findViewById(R.id.gasConsumedInputText);

        theCar.addTrip(Integer.parseInt(mMilesTraveledInputText.getText().toString()), Integer.parseInt(mGasConsumedInputText.getText().toString()));

        editor.putInt("lastMilesDriven", theCar.getLastMilesDriven());
        editor.putInt("lastGasConsumed", theCar.getLastGasConsumed());
        editor.putInt("totalMilesDriven", theCar.getTotalMilesDriven());
        editor.putInt("totalGasConsumed", theCar.getTotalGasConsumed());
        editor.apply();

        startActivity(intent);
    }
}