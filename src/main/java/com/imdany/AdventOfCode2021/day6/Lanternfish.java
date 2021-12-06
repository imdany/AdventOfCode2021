package com.imdany.AdventOfCode2021.day6;

public class Lanternfish {

    int cycle;
    boolean isReady;


    Lanternfish(int currentCycle){
        this.cycle = currentCycle;
        this.isReady = false;
    }

    public void resetCycle(){
        this.cycle = 6;
    }

    public boolean createNew(){
        return true;
    }

    public boolean advanceDay(){
        this.cycle--;
        if(this.cycle == -1 ) {
            this.resetCycle();
            return this.createNew();
        } else {
            return false;
        }
    }

}
