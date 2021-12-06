package com.imdany.AdventOfCode2021.day6;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class SimulationRunner {

    private int status;
    private int currentDay;
    private List<Lanternfish> lanternfishList;

    SimulationRunner(List<Integer> initialStatus) {
        this.lanternfishList = this.createInitialStatus(initialStatus);
        this.currentDay = 0;
        this.status = this.lanternfishList.size();
//        this.getCurrentStatusOfLantterfish();
    }

    public List<Lanternfish> createInitialStatus(List<Integer> initialStatus){
        List<Lanternfish> newList = new ArrayList<>();
        for(Integer e: initialStatus) {
            newList.add(new Lanternfish(e));
        }
        return newList;
    }

    public int getCurrentDay(){
        return this.currentDay;
    }

    public long getStatus() {
        return this.status;
    }

    public List<Integer> play() {
        List<Lanternfish> newFish = new ArrayList<>();
        for(Lanternfish f: this.lanternfishList){
            if (f.advanceDay()){
                newFish.add(new Lanternfish(8));
            }
        }
        this.status = this.lanternfishList.size();
        this.currentDay++;

        // Add new fish to global list
        this.lanternfishList.addAll(newFish);

        //Report final status of the day
        return this.getCurrentStatusOfLantterfish();
    }

    public List<Integer> getCurrentStatusOfLantterfish(){
        List<Integer> cycleList = new ArrayList<>();
        for(Lanternfish f: this.lanternfishList){
            cycleList.add(f.cycle);
        }
//        log.info("After {} day: {}", this.currentDay, cycleList);
        return cycleList;
    }

    public void playDays(int numberDays) {
        log.trace("Advancing {} days", numberDays);
        for (int i = 0; i<numberDays; i++) {
            this.play();
        }
    }

}
