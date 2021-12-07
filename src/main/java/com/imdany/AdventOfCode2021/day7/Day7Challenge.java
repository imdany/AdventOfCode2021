package com.imdany.AdventOfCode2021.day7;

import com.imdany.AdventOfCode2021.Runner;
import com.imdany.AdventOfCode2021.day6.SimulationRunner;
import com.imdany.utils.ResourceReader;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.List;

@Slf4j
public class Day7Challenge extends Runner {

    public static void main(String[] args) throws IOException {
        Day7Challenge challenge = new Day7Challenge();
        challenge.run(challenge.getClass().getName());
    }

    @Override
    public void Challenge1() throws IOException {
        log.info("Challenge 1");

        ResourceReader resourceReader1 = new ResourceReader("/AdventOfCode2021/day7/input1.txt");
        int[] listInputs = resourceReader1.lineToIntegerList().stream().mapToInt(i->i).toArray();

        Aligner al = new Aligner(listInputs, 1);
        log.info("Result: {}", al.leastConsumptionFuel); //348996
    }

    @Override
    public void Challenge2() throws IOException {
        log.info("Challenge 2");
        ResourceReader resourceReader1 = new ResourceReader("/AdventOfCode2021/day7/input1.txt");
        int[] listInputs = resourceReader1.lineToIntegerList().stream().mapToInt(i->i).toArray();

        Aligner al = new Aligner(listInputs, 2);
        log.info("Result: {}", al.leastConsumptionFuel); //98231647

    }
}
