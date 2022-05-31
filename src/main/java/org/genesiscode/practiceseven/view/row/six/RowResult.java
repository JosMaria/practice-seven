package org.genesiscode.practiceseven.view.row.six;

public class RowResult {

    private int week;
    private String unitsReceived;
    private int initialInventory;
    private double numberRandomOne;
    private int demand;
    private int finalInventory;
    private int lostSales;
    private String sort;
    private String numberRandomTwo;
    private String deliveryTime;

    public RowResult(int week, String unitsReceived, int initialInventory, double numberRandomOne, int demand,
                     int finalInventory, int lostSales, String sort, String numberRandomTwo, String deliveryTime) {
        this.week = week;
        this.unitsReceived = unitsReceived;
        this.initialInventory = initialInventory;
        this.numberRandomOne = numberRandomOne;
        this.demand = demand;
        this.finalInventory = finalInventory;
        this.lostSales = lostSales;
        this.sort = sort;
        this.numberRandomTwo = numberRandomTwo;
        this.deliveryTime = deliveryTime;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public String getUnitsReceived() {
        return unitsReceived;
    }

    public void setUnitsReceived(String unitsReceived) {
        this.unitsReceived = unitsReceived;
    }

    public int getInitialInventory() {
        return initialInventory;
    }

    public void setInitialInventory(int initialInventory) {
        this.initialInventory = initialInventory;
    }

    public double getNumberRandomOne() {
        return numberRandomOne;
    }

    public void setNumberRandomOne(double numberRandomOne) {
        this.numberRandomOne = numberRandomOne;
    }

    public int getDemand() {
        return demand;
    }

    public void setDemand(int demand) {
        this.demand = demand;
    }

    public int getFinalInventory() {
        return finalInventory;
    }

    public void setFinalInventory(int finalInventory) {
        this.finalInventory = finalInventory;
    }

    public int getLostSales() {
        return lostSales;
    }

    public void setLostSales(int lostSales) {
        this.lostSales = lostSales;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getNumberRandomTwo() {
        return numberRandomTwo;
    }

    public void setNumberRandomTwo(String numberRandomTwo) {
        this.numberRandomTwo = numberRandomTwo;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }
}
