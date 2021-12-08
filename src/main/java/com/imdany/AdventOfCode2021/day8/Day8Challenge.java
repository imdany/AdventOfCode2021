package com.imdany.AdventOfCode2021.day8;

import com.imdany.AdventOfCode2021.Runner;
import com.imdany.AdventOfCode2021.day7.Aligner;
import com.imdany.utils.ResourceReader;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.List;

@Slf4j
public class Day8Challenge extends Runner {

    public static void main(String[] args) throws IOException {
        Day8Challenge challenge = new Day8Challenge();
        challenge.run(challenge.getClass().getName());
    }

    @Override
    public void Challenge1() throws IOException {
        log.info("Challenge 1");

        ResourceReader resourceReader1 = new ResourceReader("/AdventOfCode2021/day8/input1.txt");
        List<String> listInputs = resourceReader1.resourceToListString();

        EntriesChecker ec = new EntriesChecker(listInputs);
        int result = ec.checkCounts();
        log.info("Result: {}", result); //274
    }

    @Override
    public void Challenge2() throws IOException {
        log.info("Challenge 2");
        ResourceReader resourceReader1 = new ResourceReader("/AdventOfCode2021/day8/input1.txt");
        List<String> listInputs = resourceReader1.resourceToListString();

        EntriesChecker ec = new EntriesChecker(listInputs);
        ec.analizeEntries();

        log.info("Result: {}", ec.result); //1012089
    }
}
