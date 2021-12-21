package edu.ccm.finalproject;

public class Car {

    //all the variables
    private int totalMilesDriven = 0, totalGasConsumed = 0, totalMoneySpent = 0, totalGasBought = 0, lastMilesDriven = 0, lastGasConsumed = 0, lastMoneySpent= 0, lastGasBought = 0;
    private int mileage = 30;
    private String carName;

    //deprecated constructor
    public Car(String theCarName){
        carName = theCarName;
    }

    //the constructor used in main activity
    public Car(String theCarName, int cTotalMilesDriven, int cTotalGasConsumed, int cTotalMoneySpent, int cTotalGasBought, int cLastMilesDriven, int cLastGasConsumed, int cLastMoneySpent, int cLastGasBought){
        carName = theCarName;
        totalMilesDriven = cTotalMilesDriven;
        totalMoneySpent = cTotalMoneySpent;
        totalGasBought = cTotalGasBought;
        totalGasConsumed = cTotalGasConsumed;
        lastMilesDriven = cLastMilesDriven;
        lastGasConsumed = cLastGasConsumed;
        lastMoneySpent = cLastMoneySpent;
        lastGasBought = cLastGasBought;
    }

    //sets mileage
    public void setMileage(int newMileage){
        mileage = newMileage;
    }

    //sets car name
    public void setCarName(String pCarName){
        carName = pCarName;
    }

    //adds a trip by setting the last trip to the inputted variables and adding the trip to the totals
    public void addTrip(int milesDriven, int gasConsumed){
        lastMilesDriven = milesDriven;
        lastGasConsumed = gasConsumed;

        totalMilesDriven += lastMilesDriven;
        totalGasConsumed += lastGasConsumed;
    }

    //adds a refuel by setting the last trip to the inputted variables and adding the trip to the totals
    public void addRefuel(int gasBought, int moneySpent){
        lastGasBought = gasBought;
        lastMoneySpent = moneySpent;

        totalGasBought += lastGasBought;
        totalMoneySpent += lastMoneySpent;
    }

    //the rest of these are getter methods for either equations or just straight variables. name are self-explanatory.

    public double getLastMilesPerGallon(){
        return lastMilesDriven / lastGasConsumed;
    }

    public double getLastMilesPerDollar(){
        return lastMilesDriven / lastMoneySpent;
    }

    public double getTotalMilesPerGallon(){
        return totalMilesDriven / totalGasConsumed;
    }

    public double getTotalMilesPerDollar(){
        return totalMilesDriven / totalMoneySpent;
    }

    public double getTotalMileageRatio() {return this.getTotalMilesPerGallon() / this.getMileage();}

    public double getLastMileageRatio() {return this.getLastMilesPerGallon() / this.getMileage();}

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
