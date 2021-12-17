package com.imdany.AdventOfCode2021.day15;

import com.imdany.AdventOfCode2021.Runner;
import com.imdany.AdventOfCode2021.day14.Polymer;
import com.imdany.utils.ResourceReader;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@Slf4j
public class Day15Challenge extends Runner {

    public static void main(String[] args) throws IOException {
        Day15Challenge challenge = new Day15Challenge();
        challenge.run(challenge.getClass().getName());
    }

    @Override
    public void Challenge1() throws IOException {
        log.info("Challenge 1");
        ResourceReader resourceReader1 = new ResourceReader("/AdventOfCode2021/day15/input1.txt");
        int[][] list1 = resourceReader1.resourceToIntGrid();

        CaveGrid grid = new CaveGrid(list1, list1[0].length, list1[0].length);
        grid.pathFinder();

        log.info("Result: {}", grid.result);
    }

    @Override
    public void Challenge2() throws IOException {
        log.info("Challenge 2");
        ResourceReader resourceReader1 = new ResourceReader("/AdventOfCode2021/day15/input1.txt");
        int[][] list1 = resourceReader1.resourceToIntGrid();

        int[][] list2 = CaveGrid.expandGrid(list1);

        CaveGrid grid = new CaveGrid(list2, list2[0].length, list2[0].length);
        grid.pathFinder();

        log.info("Result: {}", grid.result);

    }
}
