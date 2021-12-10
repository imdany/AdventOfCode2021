package com.imdany.AdventOfCode2021.day10;

import com.imdany.AdventOfCode2021.Runner;
import com.imdany.AdventOfCode2021.day9.SmokeMap;
import com.imdany.utils.ResourceReader;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.List;

@Slf4j
public class Day10Challenge extends Runner {

    public static void main(String[] args) throws IOException {
        Day10Challenge challenge = new Day10Challenge();
        challenge.run(challenge.getClass().getName());
    }

    @Override
    public void Challenge1() throws IOException {
        log.info("Challenge 1");
        ResourceReader resourceReader1 = new ResourceReader("/AdventOfCode2021/day10/input1.txt");
        List<String> listInputs = resourceReader1.resourceToListString();

        SyntaxChecker sc = new SyntaxChecker(listInputs);

        log.info("Result: " + sc.totalScore);

    }

    @Override
    public void Challenge2() throws IOException {
        log.info("Challenge 2");
        ResourceReader resourceReader1 = new ResourceReader("/AdventOfCode2021/day10/input1.txt");
        List<String> listInputs = resourceReader1.resourceToListString();

        SyntaxChecker sc = new SyntaxChecker(listInputs);

        log.info("Result: " + sc.middleCost);

    }
}
