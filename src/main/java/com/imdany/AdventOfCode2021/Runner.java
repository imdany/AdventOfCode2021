package com.imdany.AdventOfCode2021;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public abstract class Runner {

    public void run(String name) throws IOException {
        log.info("Running: {}", name);

        long startTime = System.currentTimeMillis();
        this.Challenge1();
        long endTime = System.currentTimeMillis();
        log.info("Timing 1: " + (endTime-startTime) + " ms");

        long startTime2 = System.currentTimeMillis();
        this.Challenge2();
        long endTime2 = System.currentTimeMillis();
        log.info("Timing 2: " + (endTime2-startTime2) + " ms");
    }

    public abstract void Challenge1() throws IOException;

    public abstract void Challenge2() throws IOException;

}
