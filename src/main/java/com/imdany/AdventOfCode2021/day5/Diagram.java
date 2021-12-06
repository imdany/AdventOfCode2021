package com.imdany.AdventOfCode2021.day5;

public class Diagram {

    int[][] positions;
    int sizeX;
    int sizeY;

    public Diagram(int sizeX, int sizeY){
        this.sizeY = sizeY;
        this.sizeX = sizeX;
        this.positions = new int[this.sizeY][this.sizeX];
    }

    public void addPosition(Position p) {
        this.positions[p.y][p.x]++;
    }

    public int getOverlapingLines() {
        int counter = 0;
        for (int i = 0; i<this.sizeY; i++) {
            for (int j = 0; j<this.sizeX; j++) {
                if(positions[i][j] > 1) {
                    counter ++;
                }
            }
        }
        return counter;
    }

}
