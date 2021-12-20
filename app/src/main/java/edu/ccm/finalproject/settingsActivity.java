package edu.ccm.finalproject;

import static edu.ccm.finalproject.MainActivity.theCar;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.util.Linkify;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class settingsActivity extends AppCompatActivity {

    private Spinner mCarSelect;
    private String carSelected;
    private TextView githubLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);


        githubLink = findViewById(R.id.githubPageTextView);
        Linkify.addLinks(githubLink, Linkify.WEB_URLS);

        Spinner spinner = findViewById(R.id.carSelect);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.cars_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                carSelected = (String)adapterView.getItemAtPosition(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                carSelected = null;
            }
        });
    }



    public void backButton(View view) {
    Intent intent = new Intent(this, MainActivity.class);
    startActivity(intent);
    }

    public void applyButtonClick(View view){
        Intent intent = new Intent(this, MainActivity.class);

        SharedPreferences defaultSharedPref = getSharedPreferences("storage", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = defaultSharedPref.edit();

        mCarSelect = findViewById(R.id.carSelect);

        if(carSelected == null){

        }
        else if(carSelected == "Honda Civic"){
            theCar.setCarName(carSelected);
            theCar.setMileage(30);
        }
        else if(carSelected == "Honda Accord"){
            theCar.setCarName(carSelected);
            theCar.setMileage(26);
        }
        else if(carSelected == "Honda Odyessy"){
            theCar.setCarName(carSelected);
            theCar.setMileage(22);
        }
        else{

        }

        editor.putInt("mileage", theCar.getMileage());
        editor.putString("name", theCar.getCarName());

        editor.apply();

        startActivity(intent);
    }
}