package com.imdany.AdventOfCode2021;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public abstract class Runner {

    public void run() throws IOException {
        long startTime = System.currentTimeMillis();

        this.Challenge1();
        this.Challenge2();

        long endTime = System.currentTimeMillis();
        log.info("Processing Time: " + (endTime-startTime) + " ms");
    }

    public abstract void Challenge1() throws IOException;

    public abstract void Challenge2() throws IOException;

}
