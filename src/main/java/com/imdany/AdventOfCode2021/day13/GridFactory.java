package com.imdany.AdventOfCode2021.day13;

import java.util.List;

public class GridFactory {

    public static Grid creategrid(List<String> input) {
        int[][] grid = new int[2000][2000];

        int maxX = 0;
        int maxY = 0;

        for (String line: input) {
            String[] split = line.split(",");
            int x = Integer.valueOf(split[0]);
            int y = Integer.valueOf(split[1]);
            grid[y][x] = 1;
            if(x>maxX) maxX = x;
            if(y>maxY) maxY = y;
        }

        return new Grid(grid, maxX, maxY);
    };
}
