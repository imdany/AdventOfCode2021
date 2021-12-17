package com.imdany.AdventOfCode2021.day16;

import com.imdany.AdventOfCode2021.Runner;
import com.imdany.AdventOfCode2021.day15.CaveGrid;
import com.imdany.utils.ResourceReader;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class Day16Challenge extends Runner {

    public static void main(String[] args) throws IOException {
        Day16Challenge challenge = new Day16Challenge();
        challenge.run(challenge.getClass().getName());
    }

    @Override
    public void Challenge1() throws IOException {
        log.info("Challenge 1");
        ResourceReader resourceReader1 = new ResourceReader("/AdventOfCode2021/day16/input1.txt");

    }

    @Override
    public void Challenge2() throws IOException {
        log.info("Challenge 2");
        ResourceReader resourceReader1 = new ResourceReader("/AdventOfCode2021/day16/input1.txt");
    }
}
