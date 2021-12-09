package com.imdany.AdventOfCode2021.day9;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class SmokeMap {

    int[][] map;
    int[][] lowPoints;
    int[][] basinList;
    Integer[] basinSize;
    int maxX;
    int maxY;

    int nBasin = 0;
    long riskLevel = 0;

    long largestBasinSize = 0;

    SmokeMap(List<String> preMap) {
        this.createMap(preMap);

        this.lowPoints = new int[this.maxX][this.maxY];
        for (int[] row : this.lowPoints)
            Arrays.fill(row, -1);

        this.basinList = new int[this.maxX][this.maxY];
        for (int[] row : this.basinList)
            Arrays.fill(row, -1);

        // Challenge 1
        this.calculateRiskPoints();
        this.calculateRiskLevel();

        this.basinSize = new Integer[this.nBasin];

        // Challenge 2
        this.calculateBasin();
        this.calculateLargestBasing();
    }

    // Challenge 2: Get the three largest Basins
    private void calculateLargestBasing() {
        Arrays.sort(this.basinSize, Collections.reverseOrder());

        // Get three first elements
        this.largestBasinSize = this.basinSize[0] * this.basinSize[1] * this.basinSize[2];
    }

    // Create the initial map from the input data
    private void createMap(List<String> preMap) {
        this.maxX = preMap.get(0).length();
        this.maxY = preMap.size();

        int[][] preBoard = new int[this.maxX][this.maxY];
        for (int y = 0; y<maxY; y++) {
            String[] lValues = preMap.get(y).split("");
            for (int x = 0; x< lValues.length;  x++) {
                    preBoard[x][y] = Integer.valueOf(lValues[x]);
            }
        }
        this.map = preBoard;
    }

    // Challenge 1: Calculate Risk Level getting lowest Point
    private void calculateRiskLevel(){
        for (int x = 0; x<this.maxX; x++) {
            for (int y = 0; y < this.maxY; y++) {
                if(this.lowPoints[x][y] != -1){
                    this.nBasin ++;
                    this.riskLevel = this.lowPoints[x][y] +1 + this.riskLevel;
                }
            }
        }
    }

    // Discover the Risk Points from the map
    private void calculateRiskPoints(){
        for (int x = 0; x<this.maxX; x++){
            for (int y = 0; y<this.maxY; y++){
                int p = this.map[x][y];

                int pL = 9;
                int pR = 9;
                int pU = 9;
                int pD = 9;

                //Get adjacent points
                if(x > 0) { pR = this.map[x-1][y];}
                if(x+1 < this.maxX) { pL = this.map[x+1][y];}
                if(y>0) {pU = this.map[x][y-1];}
                if(y+1<this.maxY) {pD = this.map[x][y+1]; }

                // Checks
                if(p < pL && p < pR && p < pU && p<pD){
                    this.lowPoints[x][y] = p;
                }
            }
        }
    }

    // Dicover the Basin from the Map
    private void calculateBasin(){
        for (int x = 0; x<this.maxX; x++) {
            for (int y = 0; y < this.maxY; y++) {
                if(this.map[x][y] != 9) {
                    this.basinList[x][y] = this.map[x][y];
                }
            }
        }
        int[] basinSizes = new int[this.nBasin];

        int[][] positionsToVisit = new int[this.maxX][this.maxY];
        int currentBasin = 0;
        boolean isOnBasin = false;
        // Count sizes
        for (int x = 0; x<this.maxX; x++) {
            for (int y = 0; y<this.maxY; y++) {
                if(this.lowPoints[x][y] != -1) {
                    //We're ona basin. iterate on from the center
                    positionsToVisit[x][y] = 1;
                    positionsToVisit = this.checkPosition(x, y, positionsToVisit);
                    while(this.morePositionsToCheck(positionsToVisit)){
                        this.basinSize[currentBasin] = 1;
                        int x1 = 0;
                        while(x1<this.maxX) {
                            for (int y1 = 0; y1 < this.maxY; y1++) {
                                if(positionsToVisit[x1][y1] == 1) {
                                    this.basinSize[currentBasin] ++;
                                    positionsToVisit = this.checkPosition(x1, y1, positionsToVisit);
                                    x1 = 0;
                                }
                            }
                            x1++;
                        }
                    }
                    currentBasin++;
                }
            }
        }
    }

    // Check if there are more positions to check in the current basin
    private boolean morePositionsToCheck(int[][] positions) {
        for (int x = 0; x<this.maxX; x++) {
            for (int y = 0; y < this.maxY; y++) {
                if(positions[x][y] == 1){
                    return true;
                }
            }
        }
        return false;
    }

    // Check adjacent positions in the current basin
    private int[][] checkPosition(int x, int y, int[][] positionsToVisit){
        int[][] prePos = positionsToVisit;
        prePos[x][y] = -1;
        int pL = -1;
        int pR = -1;
        int pU = -1;
        int pD = -1;
        // Check Up
        if(y>0) {pU = this.basinList[x][y-1];}
        // Check Down
        if(y+1<this.maxY) {pD = this.basinList[x][y+1]; }
        // Check Left
        if(x+1 < this.maxX) { pL = this.basinList[x+1][y];}
        // Check Right
        if(x > 0) { pR = this.basinList[x-1][y];}

        if(pU != -1 && prePos[x][y-1] != -1) prePos[x][y-1] = 1;
        if(pD != -1 && prePos[x][y+1] != -1) prePos[x][y+1] = 1;
        if(pL != -1 && prePos[x+1][y] != -1) prePos[x+1][y] = 1;
        if(pR != -1 && prePos[x-1][y] != -1) prePos[x-1][y] = 1;

        return prePos;
    }

}
