package com.imdany.AdventOfCode2021.day13;

public class Grid {

    int[][] grid;
    int sizeX;
    int sizeY;

    Grid(int[][] grid, int maxX, int maxY) {
        this.sizeX = maxX + 1;
        this.sizeY = maxY + 1;

        this.grid = new int[sizeY][sizeX];

        for (int i = 0; i<this.sizeY; i++) {
            for (int j = 0; j<this.sizeX; j++) {
                this.grid[i][j] = grid[i][j];
            }
        }
    }

    public void foldX(int x) {
        int newY = x;
        int [][] g = new int[newY][this.sizeX];

        for (int i = 0; i<newY; i++){
            for (int j = 0; j<this.sizeX; j++) {
                g[newY-1 - i][j] += this.grid[newY - 1 - i][j];
                if(newY + 1 + i < this.sizeY) {
                    g[newY - 1 - i][j] += this.grid[newY + 1 + i][j];
                }
            }
        }

        this.grid = g;
        this.sizeY = newY;
    }

    public void foldY(int y) {
        int newX = y;
        int [][] g = new int[this.sizeY][newX];

        for (int i = 0; i<this.sizeY; i++){
            for (int j = 0; j<newX; j++) {
                g[i][newX - 1 - j] += this.grid[i][newX -1 -j];
                if(newX + 1 + j < this.sizeX) {
                    g[i][newX - 1 - j] += this.grid[i][newX + 1 + j];
                }
            }
        }

        this.grid = g;
        this.sizeX = newX;
    }

    public int countVisible(){
        int result = 0;
        for (int i = 0; i < sizeY; i++) {
            for(int j = 0; j<sizeX; j++) {
                int value = this.grid[i][j];
                if(value != 0 ) {
                    result ++;
                }
            }
        }
        return result;
    }

    // Prints the grid for debugging
    public void printGrid(int fold){
        System.out.println("");
        for (int i = 0; i < sizeY; i++) {
            for(int j = 0; j<sizeX; j++) {
                if(i != fold) {
                    int value = this.grid[i][j];
                    if(value == 0 ) {
                        System.out.print(".");
                    }else{
                        System.out.print("#");
                    }
                } else {
                    System.out.print("-");
                }
            }
            System.out.print("\n\r");
        }
    }

}
