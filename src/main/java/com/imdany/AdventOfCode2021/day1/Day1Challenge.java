package com.imdany.AdventOfCode2021.day1;

import com.imdany.AdventOfCode2021.Runner;
import com.imdany.AdventOfCode2021.day2.Day2Challenge;
import com.imdany.utils.ResourceReader;
import lombok.extern.slf4j.Slf4j;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Day1Challenge extends Runner {

    public static void main(String[] args) throws IOException {
        Day1Challenge challenge = new Day1Challenge();
        challenge.run(challenge.getClass().getName());    }

    @Override
    public void Challenge1() throws IOException {
        log.info("Challenge 1");
        ResourceReader resourceReader = new ResourceReader("/AdventOfCode2021/day1/day1.txt");
        List<Integer> depthList = resourceReader.resourceToListInt();

        getIncreaseOrDecrease(depthList);

    }

    @Override
    public void Challenge2() throws IOException {
        log.info("Challenge 2");
        ResourceReader resourceReader = new ResourceReader("/AdventOfCode2021/day1/day1.txt");
        List<Integer> depthList = resourceReader.resourceToListInt();

        // Sliding windows 3
        List<Integer> newList = getSlidingWindow(depthList, 3);
        getIncreaseOrDecrease(newList);
    }

    private static List<Integer> getSlidingWindow(List<Integer> oldList, Integer windowSize) {
        List<Integer> newList = new ArrayList<Integer>();

        for (int i = 0; i<oldList.size() - (windowSize - 1); i++) {
            int provValue = 0;
            for (int j = 0; j<windowSize; j++) {
                provValue = provValue + oldList.get(i+j);
            }
            newList.add(provValue);
        }
        return newList;
    }

    private static void getIncreaseOrDecrease(List<Integer> depthList) {
        int increaseCounter = 0;
        int decreaseCounter = 0;

        int i1 = 1;
        int j1 = 0;
        while(i1 < depthList.size()) {
            if(depthList.get(i1)>depthList.get(j1)){
                increaseCounter ++;
            } else {
                decreaseCounter ++;
            }
            i1 ++;
            j1 ++;
        }
        log.info("Solution - Increases: " + increaseCounter);
        log.info("Solution - Decreases: " + decreaseCounter);
    }

}
