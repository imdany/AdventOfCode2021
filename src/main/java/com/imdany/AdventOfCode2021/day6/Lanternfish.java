package com.imdany.AdventOfCode2021.day6;

public class Lanternfish {

    int cycle;
    long population;

    Lanternfish(int currentCycle, long population){
        this.cycle = currentCycle;
        this.population = population;
    }

    public void add(long individuals) {
        this.population = this.population + individuals;
    }

    public void remove(long individuals) {
        this.population = this.population - individuals;
    }

}
