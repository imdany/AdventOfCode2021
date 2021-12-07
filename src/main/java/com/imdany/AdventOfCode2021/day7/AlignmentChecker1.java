package com.imdany.AdventOfCode2021.day7;

public class AlignmentChecker1 extends AlignmentChecker {

    AlignmentChecker1(int centralPosition, int[] positionsToAlign){
        super(centralPosition, positionsToAlign);
    }

    @Override
    public void calculateFuelConsumption(){
        for(int i =0; i< this.getPositionsSize(); i++){
            this.setFuelConsumption(this.getFuelConsumption() + Math.abs(this.getCentralPosition() - this.getPosition(i)));
        }
    }

}
