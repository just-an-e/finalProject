package edu.ccm.finalproject;

import static edu.ccm.finalproject.MainActivity.theCar;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

    public void backButtonClick(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void submitButtonClick(View view){
        Intent intent = new Intent(this, MainActivity.class);

        mGasBoughtInputText = findViewById(R.id.gasBoughtInputText);
        mMoneySpentInputText = findViewById(R.id.moneySpentInputText);

        theCar.addRefuel(Integer.parseInt(mGasBoughtInputText.getText().toString()), Integer.parseInt(mMoneySpentInputText.getText().toString()));

        startActivity(intent);
    }
}