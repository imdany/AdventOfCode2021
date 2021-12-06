package com.imdany.AdventOfCode2021.day6;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class SimulationRunner {

    private long status;
    private int currentDay;
    private List<Lanternfish> lanternfishList;


    SimulationRunner(List<Integer> initialStatus) {

        lanternfishList = new ArrayList<>();

        lanternfishList.add(new Lanternfish(0, 0L));
        lanternfishList.add(new Lanternfish(1, 0L));
        lanternfishList.add(new Lanternfish(2, 0L));
        lanternfishList.add(new Lanternfish(3, 0L));
        lanternfishList.add(new Lanternfish(4, 0L));
        lanternfishList.add(new Lanternfish(5, 0L));
        lanternfishList.add(new Lanternfish(6, 0L));
        lanternfishList.add(new Lanternfish(7, 0L));
        lanternfishList.add(new Lanternfish(8, 0L));

        this.createInitialStatus(initialStatus);
        this.currentDay = 0;

        this.status = 0L;
        for (Lanternfish f: this.lanternfishList) {
            this.status = this.status + f.population;
        }

        this.getCurrentStatusOfLantterfish();
    }

    public void createInitialStatus(List<Integer> initialStatus){
        List<Lanternfish> newList = new ArrayList<>();
        for(Integer e: initialStatus) {
            lanternfishList.get(e).add(1);
        }
    }

    public int getCurrentDay(){
        return this.currentDay;
    }

    public long getStatus() {
        return this.status;
    }

    public long[] play() {
        // Get a copy of the list for doing the modifications
        List<Lanternfish> tmpList = new ArrayList<>();
        this.copyList(this.lanternfishList, tmpList);
        for (int i = 8; i>-1; i--) {
            Lanternfish current = this.lanternfishList.get(i);
            long tmpPopulation = current.population;
            // Remove population and add it to next element
            tmpList.get(i).remove(tmpPopulation);
            if(i ==0) {
                // New fishes
                tmpList.get(6).add(tmpPopulation);
                tmpList.get(8).add(tmpPopulation);
            }else {
                tmpList.get(i-1).add(tmpPopulation);
            }
        }
        this.copyList(tmpList, this.lanternfishList);

        this.lanternfishList = tmpList;
        this.currentDay++;

        //Report final status of the day
        return this.getCurrentStatusOfLantterfish();
    }

    public long[] getCurrentStatusOfLantterfish(){
        StringBuilder sb = new StringBuilder();
        sb.append("Number of Lanternfish: ");
        long[] cycleList = new long[9];
        this.status = 0L;
        for(Lanternfish f: this.lanternfishList){
            this.status = this.status + f.population;
            cycleList[f.cycle] = f.population;
            sb.append("(" + f.cycle + " - P:    " + f.population +")" );
        }
        //log.info(sb.toString());
        return cycleList;
    }

    public void playDays(int numberDays) {
        log.trace("Advancing {} days", numberDays);
        for (int i = 0; i<numberDays; i++) {
            this.play();
        }
    }

    public void copyList(List<Lanternfish> src, List<Lanternfish> dest) {
        dest.clear();
        for(int i=0;i<src.size();i++){
            dest.add((new Lanternfish(src.get(i).cycle, src.get(i).population)));
        }
    }

}
