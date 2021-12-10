package com.imdany.AdventOfCode2021.day10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SyntaxChecker {

    private List<Line> lineList;
    List<Long> listCost;
    long totalScore;
    Long middleCost;

    SyntaxChecker(List<String> inputLines){
        lineList = new ArrayList<>();
        listCost = new ArrayList<Long>();
        for(String l: inputLines) {
            Line line = new Line(l);
            this.totalScore += line.getTotalScore();
            if(line.getIsIncomplete()){
                this.listCost.add(line.getCost());
            }
            lineList.add(line);
        }

        // Challenge 2
        this.calculateMiddleCost();
    }

    public void calculateMiddleCost(){
        Long[] cost = new Long[this.listCost.size()];
        cost = this.listCost.toArray(cost);
        // Filter 0
        cost = Arrays.stream(cost).filter(x -> x !=0 ).toArray(Long[]::new);
        Arrays.sort(cost);

        this.middleCost = cost[cost.length/2];
    }
}
