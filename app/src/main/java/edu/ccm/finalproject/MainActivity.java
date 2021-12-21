package edu.ccm.finalproject;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

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
    private TextView mTotalMileageDT;
    private TextView mTotalMilesPerDollarDT;
    private TextView mTotalMileRatioDT;
    private TextView mLastMileageDT;
    private TextView mLastMilesPerDollarDT;
    private TextView mLastMileRatioDT;
    private TextView mCarNameDT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //creating the sharedprefrences editor and file
        SharedPreferences defaultSharedPref = getSharedPreferences("storage", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = defaultSharedPref.edit();

        //setting the theCar object to the correct variables and adding the variables to shared pref file
            theCar = new Car(defaultSharedPref.getString("carName", "Honda Civic"), defaultSharedPref.getInt("totalMilesDriven", 0), defaultSharedPref.getInt("totalGasConsumed", 0), defaultSharedPref.getInt("totalMoneySpent", 0), defaultSharedPref.getInt("totalGasBought", 0), defaultSharedPref.getInt("lastMilesDriven", 0), defaultSharedPref.getInt("lastGasConsumed", 0), defaultSharedPref.getInt("lastMoneySpent", 0), defaultSharedPref.getInt("lastGasBought", 0));
            editor.putString("carName", theCar.getCarName());
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

        //updating the main display
        updateDisplay();
    }

    //sends you to the settings activity
    public void settingsClick(View view){
        Intent intent = new Intent(this, settingsActivity.class);
        startActivity(intent);
    }

    //sends you to the add trip activity
    public void addTripClick(View view){
        Intent intent = new Intent(this, addTripActivity.class);
        startActivity(intent);
    }

    //sends you to the add refuel activity
    public void addRefuelClick(View view){
        Intent intent = new Intent(this, addRefuelActivity.class);
        startActivity(intent);
    }

    //updates the main display with all of the most current variables and stats.
    public void updateDisplay(){
        mTotalMilesDT = findViewById(R.id.totalMilesTraveledDisplayText);
        mTotalGasConsumedDT = findViewById(R.id.totalGasConsumedDisplayText);
        mTotalGasBoughtDT = findViewById(R.id.totalGasBoughtDisplayText);
        mTotalMoneySpentDT = findViewById(R.id.totalMoneySpentDisplayText);
        mLastMilesDT = findViewById(R.id.lastMilesTraveledDisplayText);
        mLastGasConsumedDT = findViewById(R.id.lastGasConsumedDisplayText);
        mLastGasBoughtDT = findViewById(R.id.lastGasBoughtDisplayText);
        mLastMoneySpentDT = findViewById(R.id.lastMoneySpentDisplayText);
        mTotalMileageDT = findViewById(R.id.totalMileageDisplayText);
        mTotalMilesPerDollarDT = findViewById(R.id.totalMilesPerDollarDisplayText);
        mTotalMileRatioDT = findViewById(R.id.totalMileRatioDisplayText);
        mLastMileageDT = findViewById(R.id.lastMileageDisplayText);
        mLastMilesPerDollarDT = findViewById(R.id.lastMilesPerDollarDisplayText);
        mLastMileRatioDT = findViewById(R.id.lastMileRatioDisplayText);
        mCarNameDT = findViewById(R.id.carNameDisplayText);

        mTotalMilesDT.setText("Total Miles Traveled: " + theCar.getTotalMilesDriven());
        mTotalGasConsumedDT.setText("Total Gas Consumed: " + theCar.getTotalGasConsumed());
        mTotalGasBoughtDT.setText("Total Gas Bought: " + theCar.getTotalGasBought());
        mTotalMoneySpentDT.setText("Total Money Spent: " + theCar.getTotalMoneySpent());
        mLastMilesDT.setText("Last Miles Driven: " + theCar.getLastMilesDriven());
        mLastGasConsumedDT.setText("Last Gas Consumed: " + theCar.getLastGasConsumed());
        mLastGasBoughtDT.setText("Last Gas Bought: " + theCar.getLastGasBought());
        mLastMoneySpentDT.setText("Last Money Spent: " + theCar.getLastMoneySpent());
        mTotalMileageDT.setText("Total Current Mileage: " + theCar.getTotalMilesPerGallon());
        mTotalMilesPerDollarDT.setText("Total Miles Per Dollar: " + theCar.getTotalMilesPerDollar());
        //if the listed car mileage is 2, and the actual car mileage is 2, the ratio should be 1. If the listed car mileage is 2 and the actual car mileage is 4, the ratio should be 2, because you're traveled twice as far as you've need to.
        mTotalMileRatioDT.setText("Actual Total Car Mileage Ratio to Listed Car Mileage: " + theCar.getTotalMileageRatio());
        mLastMileageDT.setText("Last Current Mileage: " + theCar.getLastMilesPerGallon());
        mLastMilesPerDollarDT.setText("Last Miles Per Dollar: " + theCar.getLastMilesPerDollar());
        mLastMileRatioDT.setText("Actual Last Car Mileage Ratio to Listed Car Mileage: " + theCar.getLastMileageRatio());
        mCarNameDT.setText(theCar.getCarName());

    }
}