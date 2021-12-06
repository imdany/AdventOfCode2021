package com.imdany.AdventOfCode2021.day5;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class PositionChecker {

    List<String> lines;
    Diagram diagram;

    PositionFactory positionFactory;

    boolean diagonals;
    int result1 = 0;
    int result2 = 0;

    PositionChecker(List<String> lines, boolean diagonals) {
        this.lines = lines;
        this.diagonals = diagonals;

        this.diagram = new Diagram(1000, 1000);
        this.positionFactory = new PositionFactory(diagonals);
    }

    public void processLines(){

        for(String line: lines){
            log.trace("Processing: {}", line );
            List<Position> positions = this.positionFactory.createLine(line);
            for (Position p: positions){
                this.diagram.addPosition(p);
            }
        }

    }

    public void checkDiagram(){
        int result = this.diagram.getOverlapingLines();
        log.info("Number of overlapping lines: {}", result);

        if(diagonals) {
            this.result2 = result;
        } else {
            this.result1 = result;
        }
    }

}
