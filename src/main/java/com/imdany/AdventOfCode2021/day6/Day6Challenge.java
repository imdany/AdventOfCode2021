package com.imdany.AdventOfCode2021.day6;

import com.imdany.AdventOfCode2021.Runner;
import com.imdany.AdventOfCode2021.day5.PositionChecker;
import com.imdany.utils.ResourceReader;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.List;

@Slf4j
public class Day6Challenge extends Runner {

    public static void main(String[] args) throws IOException {
        Day6Challenge day6Challenge = new Day6Challenge();
        day6Challenge.run();
    }

    @Override
    public void Challenge1() throws IOException {
        log.info("Challenge 1");

        ResourceReader resourceReader1 = new ResourceReader("/AdventOfCode2021/day6/input1.txt");
        List<Integer> listInputs = resourceReader1.lineToIntegerList();

        SimulationRunner sr = new SimulationRunner(listInputs);
        sr.playDays(80);

        log.info("Result after 80 days: {}", sr.getStatus());
    }

    @Override
    public void Challenge2() throws IOException {
        log.info("Challenge 2");

        ResourceReader resourceReader1 = new ResourceReader("/AdventOfCode2021/day6/input1.txt");
        List<Integer> listInputs = resourceReader1.lineToIntegerList();

        SimulationRunner sr = new SimulationRunner(listInputs);
        sr.playDays(256);

        log.info("Result after 256 days: {}", sr.getStatus());
    }
}
