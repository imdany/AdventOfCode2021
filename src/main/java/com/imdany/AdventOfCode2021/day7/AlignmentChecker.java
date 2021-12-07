package com.imdany.AdventOfCode2021.day7;

public abstract class AlignmentChecker {

    private int centralPosition;
    private long fuelConsumption;
    private int[] positionsToAlign;

    AlignmentChecker(int centralPosition, int[] positionsToAlign) {
        this.centralPosition = centralPosition;
        this.positionsToAlign = positionsToAlign;
        this.fuelConsumption = 0;

        this.calculateFuelConsumption();
    }

    public void setFuelConsumption(long fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }


    public long getFuelConsumption() {
        return this.fuelConsumption;
    };

    public int getCentralPosition(){
        return this.centralPosition;
    }

    public int getPosition(int i) {
        return this.positionsToAlign[i];
    }

    public int getPositionsSize(){
        return this.positionsToAlign.length;
    }

    public abstract void calculateFuelConsumption();

    @Override
    public String toString() {
        return "AlignmentChecker{" +
                "centralPosition=" + centralPosition +
                ", fuelConsumption=" + fuelConsumption + '}';
    }
}
