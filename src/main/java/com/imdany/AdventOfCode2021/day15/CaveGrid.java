package com.imdany.AdventOfCode2021.day15;

import java.util.LinkedList;
import java.util.Queue;

public class CaveGrid {

    int[][] grid;
    int[][] visitedGrid;
    int sizeX;
    int sizeY;

    int result;

    CaveGrid(int[][] grid, int maxX, int maxY) {
        this.sizeX = maxX;
        this.sizeY = maxY;

        this.grid = new int[sizeY][sizeX];
        this.visitedGrid = new int[sizeY][sizeX];

        this.result = 0;

        for (int j = 0; j<this.sizeX; j++) {
            for (int i = 0; i<this.sizeY; i++) {
                this.grid[i][j] = grid[j][i];
                this.visitedGrid[i][j] = Integer.MAX_VALUE;
            }
        }

    }

    public Queue<int[]> getNeighbors(int x, int y) {
        Queue<int[]> neigh = new LinkedList<>();
        if(x > 0) neigh.add(new int[]{x-1, y});
        if(x < this.sizeX - 1) neigh.add(new int[]{x+1, y});
        if(y > 0) neigh.add(new int[]{x, y-1});
        if(y < this.sizeY - 1) neigh.add(new int[]{x, y+1});
        return neigh;
    }

    // Dijkstra algorithm using a queue
    public void pathFinder(){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0,0});

        this.grid[0][0] = 0;
        this.visitedGrid[0][0] = 0;

        while(!queue.isEmpty()) {
            int[] currentPosition = queue.poll();

            // get neighbords
            Queue<int[]> neighbords = this.getNeighbors(currentPosition[0], currentPosition[1]);

            for (int[] n: neighbords) {
                int neighborCost = this.visitedGrid[n[0]][n[1]];
                int costToNeighbor = this.visitedGrid[currentPosition[0]][currentPosition[1]] + this.grid[n[0]][n[1]];
                if(neighborCost > costToNeighbor) {
                    this.visitedGrid[n[0]][n[1]] = costToNeighbor;
                    queue.add(new int[]{ n[0], n[1]} );
                }
            }
        }
        this.result = this.visitedGrid[this.sizeX-1][this.sizeY-1];
    }

    // Prints the grid for debugging
    public void printGrid(int[][] grid){
        System.out.println("");
        for(int j = 0; j<sizeX; j++) {
            for (int i = 0; i < sizeY; i++) {
                int value = grid[j][i];
                System.out.print(value);
            }
            System.out.print("\n\r");
        }
    }

    public void printCave(){
        this.printGrid(this.grid);
    }
    public void printCost(){
        this.printGrid(this.visitedGrid);
    }


    // Challenge 2
    public static int[][] expandGrid(int[][] grid) {
        int size = grid[0].length;
        int[][] newGrid = new int[grid[0].length*5][grid[0].length*5];
        for (int i=0; i<size; i++) {
            for (int j = 0; j < size; j++) {
                for (int dx=0; dx < 5; dx++) {
                    for (int dy = 0; dy < 5; dy++) {
                        int value = grid[i][j] + dx + dy;
                        if(value >= 10) {
                            value -= 9;
                        }
                        newGrid[i+size*dx][j+size*dy] = value;
                    }
                }
            }
        }
        return newGrid;
    }

}
