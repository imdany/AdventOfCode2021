package com.imdany.AdventOfCode2021.day5;

import java.util.ArrayList;
import java.util.List;

public class PositionFactory {

    boolean diagonals;

    public PositionFactory(boolean diagonals){
        this.diagonals = diagonals;
    }

    public Position createPosition(String elements) {
        String[] values = elements.split(",");
        return new Position(Integer.valueOf(values[0]), Integer.valueOf(values[1]));
    }

    public List<Position> createIntermidiatePositions(Position startP, Position endP, boolean ascending) {
        List<Position> elements = new ArrayList<Position>();
        // Check if movement on X or Y
        if(startP.x == endP.x){
            // Create horizontal points
            for (int i = startP.y; i < endP.y + 1; i++){
                elements.add(new Position(startP.x, i));
            }
        }else if (startP.y == endP.y) {
            // Create vertical points
            for (int i = startP.x; i < endP.x + 1; i++){
                elements.add(new Position(i, startP.y));
            }
        }else {
            if(diagonals) {
                // Create diagonal points
                // Get X and Y distance (should be the same as 45 degrees)
                if (ascending){
                    int currentX = startP.x;
                    for (int y = startP.y; y > endP.y - 1; y--) {
                        elements.add(new Position(currentX, y));
                        currentX++;
                    }
                } else {
                    int currentX = startP.x;
                    for (int y = startP.y; y <endP.y + 1; y++) {
                        elements.add(new Position(currentX, y));
                        currentX++;
                    }
                }

            }
        }
        return elements;
    }

    public List<Position> createLine(String line){
        String[] positions = line.replace(" ", "").split("->");
        Position startP = this.createPosition(positions[0]);
        Position endP = this.createPosition(positions[1]);

        List<Position> positionsList = new ArrayList<>();
        // Reorder points so start X and Start Y are always top left
        int x1 = startP.x;
        int x2 = endP.x;
        int y1 = startP.y;
        int y2 = endP.y;

        int startX = 0;
        int endX = 0;
        int startY = 0;
        int endY = 0;

        if (x1 == x2 || y1 == y2) {
            if ( x1 <= x2) {
                startX = x1;
                endX = x2;
            } else {
                startX = x2;
                endX = x1;
            }
            if(y1<=y2) {
                startY = y1;
                endY = y2;
            } else {
                startY = y2;
                endY = y1;
            }
            positionsList = this.createIntermidiatePositions(new Position(startX, startY), new Position(endX, endY), false);
        } else {
            if(y1 > y2) {
                if(x1 < x2) {
                    positionsList = this.createIntermidiatePositions(startP, endP, true); //
                } else {
                    positionsList = this.createIntermidiatePositions(endP,startP, false); //
                }
            }else{
                if(x1 < x2) {
                    positionsList = this.createIntermidiatePositions(startP, endP , false); //
                } else {
                    positionsList = this.createIntermidiatePositions(endP, startP, true); //
                }

            }
        }
        return positionsList;
    }

}
