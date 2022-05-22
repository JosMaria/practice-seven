package org.genesiscode.practiceseven.view.row.four;

public class RowDataProcessed {

    private double probability;
    private double accumulatedDistribution;
    private String range;
    private int data;

    public RowDataProcessed(double probability, double accumulatedDistribution, String range, int data) {
        this.probability = probability;
        this.accumulatedDistribution = accumulatedDistribution;
        this.range = range;
        this.data = data;
    }

    public double getProbability() {
        return probability;
    }

    public void setProbability(double probability) {
        this.probability = probability;
    }

    public double getAccumulatedDistribution() {
        return accumulatedDistribution;
    }

    public void setAccumulatedDistribution(double accumulatedDistribution) {
        this.accumulatedDistribution = accumulatedDistribution;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
