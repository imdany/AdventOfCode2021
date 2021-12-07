package com.imdany.AdventOfCode2021.day7;


public class Aligner {

    long leastConsumptionFuel;
    int leastConsumptionPosition;

    int[] positions;

    int challenge;

    Aligner(int[] positions, int challenge){
        this.leastConsumptionFuel = 9999999999999L;
        this.leastConsumptionPosition = 0;

        this.positions = positions;
        this.challenge = challenge;

        this.calculateLeastConsumption();
    }

    public void calculateLeastConsumption(){
        for (int i = 0; i<this.positions.length; i++) {
            AlignmentChecker ac;

            if(this.challenge == 1 ){
                ac = new AlignmentChecker1(this.positions[i], this.positions);

            } else {
                ac = new AlignmentChecker2(this.positions[i], this.positions);

            }

            long cf = ac.getFuelConsumption();
            int cp = ac.getCentralPosition();

            if(cf < this.leastConsumptionFuel) {
                this.leastConsumptionFuel = cf;
                this.leastConsumptionPosition = cp;
            }
        }
    }
}
