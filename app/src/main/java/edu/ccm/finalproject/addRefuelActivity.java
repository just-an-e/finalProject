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
import android.view.View;
import android.widget.EditText;

public class addRefuelActivity extends AppCompatActivity {

    private EditText mGasBoughtInputText;
    private EditText mMoneySpentInputText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_refuel);
    }

    //sends the user back without changing anything
    public void backButtonClick(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    //saves everything and adds the refuel
    public void submitButtonClick(View view){
        Intent intent = new Intent(this, MainActivity.class);

        SharedPreferences defaultSharedPref = getSharedPreferences("storage", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = defaultSharedPref.edit();

        mGasBoughtInputText = findViewById(R.id.gasBoughtInputText);
        mMoneySpentInputText = findViewById(R.id.moneySpentInputText);

        theCar.addRefuel(Integer.parseInt(mGasBoughtInputText.getText().toString()), Integer.parseInt(mMoneySpentInputText.getText().toString()));

        editor.putInt("lastGasBought", theCar.getLastGasBought());
        editor.putInt("lastMoneySpent", theCar.getLastMoneySpent());
        editor.putInt("totalGasBought", theCar.getTotalGasBought());
        editor.putInt("totalMoneySpent", theCar.getTotalMoneySpent());
        editor.apply();

        startActivity(intent);
    }
}