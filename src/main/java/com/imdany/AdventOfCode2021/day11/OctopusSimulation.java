package com.imdany.AdventOfCode2021.day11;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class OctopusSimulation {

    private int sizeX;
    private int sizeY;
    private Octopus[][] grid;
    private long flahes;
    private long daysUntilSync;

    // Contruct grid simulation
    OctopusSimulation(int sizeX, int sizeY, int[][] grid){
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.flahes = 0;
        this.daysUntilSync = 0;
        this.grid = new Octopus[this.sizeX][this.sizeY];

        // Creating Grid with al octopus
        for(int i = 0; i<sizeX; i++) {
            for(int j = 0; j<sizeX; j++) {
                this.grid[i][j] = new Octopus(grid[i][j], i+","+j);
            }
        }
    }

    //Challenge 1 solution -  Get number of total flashes
    public long getFlahes() {
        return this.flahes;
    }

    //Challenge 2 solution - Get days until sync
    public long getDaysUntilSync(){
        return this.daysUntilSync;
    }

    // General Day simulation
    private long runDay() {
        //First step. Increase energy of all octopus and check if flashes
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeX; j++) {
                this.grid[i][j].increaseEnergy(1);
                this.grid[i][j].checkEnergyLevel();
            }
        }

        // For each octopus, check the adjacents and adjust energy level again
        int modifications = -1;
        while (modifications != 0) {
            modifications = 0;
            for (int i = 0; i < sizeX; i++) {
                for (int j = 0; j < sizeX; j++) {
                    if (!this.grid[i][j].isFlashing()) {
                        List<String> adjust = this.checkAdjacents(i, j);
                        if (adjust.size() != 0) {
                            for (String id : adjust) {
                                if (this.grid[i][j].listOfFlashes.contains(id)) {
                                    // Already flashed by this fish, do nothing
                                } else {
                                    this.grid[i][j].listOfFlashes.add(id);
                                    this.grid[i][j].increaseEnergy(1);
                                    modifications++;
                                }
                            }
                        }
                    }
                }
            }
        }

        //Third step. Reset Octopus
        long runFlahes = 0;
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeX; j++) {
                this.grid[i][j].listOfFlashes.clear();
                if (this.grid[i][j].isFlashing()) {
                    this.grid[i][j].resetEnergyLevel();
                    this.grid[i][j].alreadyFlashed = false;
                    runFlahes ++;
                }
            }
        }
        //this.printGrid();
        this.flahes += runFlahes;
        return runFlahes;
    }

    // Challenge 2
    public void run(int days){
        for (int d = 0; d<days; d++) {
            this.runDay();
        }
    }


    // Challenge 2
    public void runUntilSync(){
        int totalFlashes = this.sizeX * this.sizeY;
        int day = 0;
        long currentFlahes = 0;
        while (currentFlahes != totalFlashes) {
            currentFlahes = this.runDay();
            day ++;
        }
        log.info("Current day: {} - Flashes: {}", day, currentFlahes);
        this.daysUntilSync = day;
    }


    // Check all cells surrounding the i, j position and adds the ID to a list.
    private List<String> checkAdjacents(int i , int j) {
        List<String> flash = new ArrayList<>();
        if (i > 0 && j > 0 && this.grid[i - 1][j - 1].isFlashing()) flash.add(this.grid[i - 1][j - 1].id);
        if (i > 0 && this.grid[i - 1][j].isFlashing()) flash.add(this.grid[i - 1][j].id);
        if (i > 0 && j < this.sizeY - 1 && this.grid[i - 1][j + 1].isFlashing()) flash.add(this.grid[i - 1][j + 1].id);
        if (i < this.sizeX - 1 && j > 0 && this.grid[i + 1][j - 1].isFlashing()) flash.add(this.grid[i + 1][j - 1].id);
        if (i < this.sizeX - 1 && this.grid[i + 1][j].isFlashing()) flash.add(this.grid[i + 1][j].id);
        if (i < this.sizeX - 1 && j < this.sizeY - 1 && this.grid[i + 1][j + 1].isFlashing()) flash.add(this.grid[i + 1][j + 1].id);
        if (j > 0 && this.grid[i][j - 1].isFlashing()) flash.add(this.grid[i][j - 1].id);
        if (j < this.sizeY - 1 && this.grid[i][j + 1].isFlashing()) flash.add(this.grid[i][j + 1].id) ;
        return flash;
    }

    // Prints the grid for debugging
    public void printGrid(){
        System.out.println("");
        for(int j = 0; j<sizeX; j++) {
            for (int i = 0; i < sizeY; i++) {
                int energy = this.grid[i][j].getCurrentEnery();
                if(energy > 9) {
                    System.out.print("X");
                }else{
                    System.out.print(energy);
                }
            }
            System.out.print("\n\r");
        }
    }

}
