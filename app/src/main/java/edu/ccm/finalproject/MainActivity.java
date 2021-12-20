package edu.ccm.finalproject;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public static Car theCar;
    private TextView mTotalMilesDT;
    private TextView mTotalGasConsumedDT;
    private TextView mTotalGasBoughtDT;
    private TextView mTotalMoneySpentDT;
    private TextView mLastMilesDT;
    private TextView mLastGasConsumedDT;
    private TextView mLastGasBoughtDT;
    private TextView mLastMoneySpentDT;
    private TextView mCarNameDT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences defaultSharedPref = getSharedPreferences("storage", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = defaultSharedPref.edit();


            theCar = new Car(defaultSharedPref.getString("name", "placeholder"), defaultSharedPref.getInt("totalMilesDriven", 0), defaultSharedPref.getInt("totalGasConsumed", 0), defaultSharedPref.getInt("totalMoneySpent", 0), defaultSharedPref.getInt("totalGasBought", 0), defaultSharedPref.getInt("lastMilesDriven", 0), defaultSharedPref.getInt("lastGasConsumed", 0), defaultSharedPref.getInt("lastMoneySpent", 0), defaultSharedPref.getInt("lastGasBought", 0));
            editor.putBoolean("startedOnce", true);
            editor.putString("name", theCar.getCarName());
            editor.putInt("totalMilesDriven", theCar.getTotalMilesDriven());
            editor.putInt("totalGasConsumed", theCar.getTotalGasConsumed());
            editor.putInt("totalMoneySpent", theCar.getTotalMoneySpent());
            editor.putInt("totalGasBought", theCar.getTotalGasBought());
            editor.putInt("lastMilesDriven", theCar.getLastMilesDriven());
            editor.putInt("lastGasConsumed", theCar.getLastGasConsumed());
            editor.putInt("lastMoneySpent", theCar.getLastMoneySpent());
            editor.putInt("lastGasBought", theCar.getLastGasBought());
            editor.putInt("mileage", theCar.getMileage());
        editor.apply();

        updateDisplay();
    }

    public void settingsClick(View view){
        Intent intent = new Intent(this, settingsActivity.class);
        startActivity(intent);
    }

    public void addTripClick(View view){
        Intent intent = new Intent(this, addTripActivity.class);
        startActivity(intent);
    }

    public void addRefuelClick(View view){
        Intent intent = new Intent(this, addRefuelActivity.class);
        startActivity(intent);
    }

    public void updateDisplay(){
        mTotalMilesDT = findViewById(R.id.totalMilesTraveledDisplayText);
        mTotalGasConsumedDT = findViewById(R.id.totalGasConsumedDisplayText);
        mTotalGasBoughtDT = findViewById(R.id.totalGasBoughtDisplayText);
        mTotalMoneySpentDT = findViewById(R.id.totalMoneySpentDisplayText);
        mLastMilesDT = findViewById(R.id.lastMilesTraveledDisplayText);
        mLastGasConsumedDT = findViewById(R.id.lastGasConsumedDisplayText);
        mLastGasBoughtDT = findViewById(R.id.lastGasBoughtDisplayText);
        mLastMoneySpentDT = findViewById(R.id.lastMoneySpentDisplayText);
        mCarNameDT = findViewById(R.id.carNameDisplayText);

        mTotalMilesDT.setText("Total Miles Traveled: " + theCar.getTotalMilesDriven());
        mTotalGasConsumedDT.setText("Total Gas Consumed: " + theCar.getTotalGasConsumed());
        mTotalGasBoughtDT.setText("Total Gas Bought: " + theCar.getTotalGasBought());
        mTotalMoneySpentDT.setText("Total Money Spent: " + theCar.getTotalMoneySpent());
        mLastMilesDT.setText("Last Miles Driven: " + theCar.getLastMilesDriven());
        mLastGasConsumedDT.setText("Last Gas Consumed: " + theCar.getLastGasConsumed());
        mLastGasBoughtDT.setText("Last Gas Bought: " + theCar.getLastGasBought());
        mLastMoneySpentDT.setText("Last Money Spent: " + theCar.getLastMoneySpent());
        mCarNameDT.setText(theCar.getCarName());

    }

    private final ActivityResultLauncher<Intent> mRefuelResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {

                }
            });
}