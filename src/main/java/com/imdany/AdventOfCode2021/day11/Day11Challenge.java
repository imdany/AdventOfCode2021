package com.imdany.AdventOfCode2021.day11;

import com.imdany.AdventOfCode2021.Runner;
import com.imdany.AdventOfCode2021.day10.SyntaxChecker;
import com.imdany.utils.ResourceReader;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.List;

@Slf4j
public class Day11Challenge extends Runner {

    public static void main(String[] args) throws IOException {
        Day11Challenge challenge = new Day11Challenge();
        challenge.run(challenge.getClass().getName());
    }

    @Override
    public void Challenge1() throws IOException {
        log.info("Challenge 1");
        ResourceReader resourceReader1 = new ResourceReader("/AdventOfCode2021/day11/input1.txt");
        int[][] grid = resourceReader1.resourceToIntGrid();

        OctopusSimulation os = new OctopusSimulation(10, 10, grid);
        os.run(100);

        log.info("Result: {}", os.getFlahes());

    }

    @Override
    public void Challenge2() throws IOException {
        log.info("Challenge 2");

        ResourceReader resourceReader1 = new ResourceReader("/AdventOfCode2021/day11/input1.txt");
        int[][] grid = resourceReader1.resourceToIntGrid();

        OctopusSimulation os = new OctopusSimulation(10, 10, grid);
        os.runUntilSync();
        log.info("Result: {}", os.getDaysUntilSync());

    }
}
