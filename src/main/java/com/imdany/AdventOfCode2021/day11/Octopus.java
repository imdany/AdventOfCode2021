package com.imdany.AdventOfCode2021.day11;

import java.util.ArrayList;
import java.util.List;

public class Octopus {

    private int maxEnergy = 9;

    private int currentEnergy;
    private boolean isFlashing;
    public boolean alreadyFlashed;
    String id;

    public List<String> listOfFlashes;


    Octopus(int energy, String id) {
        this.isFlashing = false;
        this.currentEnergy = energy;
        this.alreadyFlashed = false;
        this.id = id;
        this.listOfFlashes = new ArrayList<>();
    }

    public int getCurrentEnery(){
        return this.currentEnergy;
    }

    public boolean isFlashing(){
        return this.isFlashing;
    }

    public void increaseEnergy(int value){
        if(!this.isFlashing){
            this.currentEnergy = this.currentEnergy + value;
        }
        this.checkEnergyLevel();
    }

    public boolean checkEnergyLevel(){
        if(this.currentEnergy > this.maxEnergy) {
            this.isFlashing = true;
            return true;
        }
        return false;
    }

    public void resetEnergyLevel(){
        this.currentEnergy = 0;
        this.isFlashing = false;
    }
}
