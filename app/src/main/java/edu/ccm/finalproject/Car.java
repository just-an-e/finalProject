package edu.ccm.finalproject;

public class Car {

    private int totalMilesDriven = 0, totalGasConsumed = 0, totalMoneySpent = 0, totalGasBought = 0, lastMilesDriven = 0, lastGasConsumed = 0, lastMoneySpent= 0, lastGasBought = 0;
    private int mileage;
    private String carName;

    public Car(String theCarName){
        carName = theCarName;
    }

    public void setMileage(int newMileage){
        mileage = newMileage;
    }

    public void addTrip(int milesDriven, int gasConsumed){
        lastMilesDriven = milesDriven;
        lastGasConsumed = gasConsumed;

        totalMilesDriven += lastMilesDriven;
        totalGasConsumed += lastGasConsumed;
    }

    public void addRefuel(int gasBought, int moneySpent){
        lastGasBought = gasBought;
        lastMoneySpent = moneySpent;

        totalGasBought += lastGasBought;
        totalMoneySpent += lastMoneySpent;
    }

    public double lastMilesPerGallon(){
        return lastMilesDriven / lastGasConsumed;
    }

    public double lastMilesPerDollar(){
        return lastMilesDriven / lastMoneySpent;
    }

    public int getMileage() {
        return mileage;
    }
    public String getCarName() {
        return carName;
    }

    public int getTotalMilesDriven(){
        return totalMilesDriven;
    }
    public int getTotalGasBought() {
        return totalGasBought;
    }
    public int getTotalGasConsumed() {
        return totalGasConsumed;
    }
    public int getTotalMoneySpent() {
        return totalMoneySpent;
    }
    public int getLastGasBought() {
        return lastGasBought;
    }
    public int getLastGasConsumed() {
        return lastGasConsumed;
    }
    public int getLastMilesDriven() {
        return lastMilesDriven;
    }
    public int getLastMoneySpent() {
        return lastMoneySpent;
    }
}
