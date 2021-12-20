package com.imdany.AdventOfCode2021.day17;

import com.imdany.AdventOfCode2021.Runner;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class Day17Challenge extends Runner {

    public static void main(String[] args) throws IOException {
        Day17Challenge challenge = new Day17Challenge();
        challenge.run(challenge.getClass().getName());
    }

    @Override
    public void Challenge1() throws IOException {
        log.info("Challenge 1");
        //x=70..96, y=-179..-124
        ProbeShot pb = new ProbeShot(70, 96, -179, -124);
        Double result = pb.findPosition();

        log.info("Result: {}", result);

    }

    @Override
    public void Challenge2() throws IOException {
        log.info("Challenge 2");
        ProbeShot pb = new ProbeShot(70, 96, -179, -124);
        int result = pb.findCombinations();

        log.info("Result: {}", result);
    }
}
