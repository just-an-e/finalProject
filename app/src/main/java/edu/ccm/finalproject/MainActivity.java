package edu.ccm.finalproject;

import android.content.Intent;
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
    public static final String ADD_REFUEL = "";
    private TextView mTotalMilesDT;
    private TextView mTotalGasConsumedDT;
    private TextView mTotalGasBoughtDT;
    private TextView mTotalMoneySpentDT;
    private TextView mLastMilesDT;
    private TextView mLastGasConsumedDT;
    private TextView mLastGasBoughtDT;
    private TextView mLastMoneySpentDT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(theCar == null){
            theCar = new Car("placeholder");
        }
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

        mTotalMilesDT.setText("Total Miles Traveled: " + theCar.getTotalMilesDriven());
        mTotalGasConsumedDT.setText("Total Gas Consumed: " + theCar.getTotalGasConsumed());
        mTotalGasBoughtDT.setText("Total Gas Bought: " + theCar.getTotalGasBought());
        mTotalMoneySpentDT.setText("Total Money Spent: " + theCar.getTotalMoneySpent());
        mLastMilesDT.setText("Last Miles Driven: " + theCar.getLastMilesDriven());
        mLastGasConsumedDT.setText("Last Gas Consumed: " + theCar.getLastGasConsumed());
        mLastGasBoughtDT.setText("Last Gas Bought: " + theCar.getLastGasBought());
        mLastMoneySpentDT.setText("Last Money Spent: " + theCar.getLastMoneySpent());

    }

    private final ActivityResultLauncher<Intent> mRefuelResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {

                }
            });
}