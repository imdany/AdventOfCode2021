package com.imdany.AdventOfCode2021.day7;

public class AlignmentChecker2 extends  AlignmentChecker {

    AlignmentChecker2(int centralPosition, int[] positionsToAlign){
        super(centralPosition, positionsToAlign);
    }

    @Override
    public void calculateFuelConsumption(){
        for(int i =0; i< this.getPositionsSize(); i++){
            int dist = Math.abs(this.getCentralPosition() - this.getPosition(i));
            long cost = this.costCalculation(dist);
            this.setFuelConsumption(this.getFuelConsumption() + cost);
        }
    }

    public long costCalculation(int value) {
        return (value * (value +1) /2);
    }

}
