package com.imdany.AdventOfCode2021;

import java.io.IOException;

public abstract class Runner {

    public void Run(int day) throws IOException {
        long startTime = System.currentTimeMillis();
        System.out.println("---Day " + day + " Challenge---");

        this.Challenge1();
        this.Challenge2();

        long endTime = System.currentTimeMillis();
        System.out.println("Processing Time: " + (endTime-startTime) + " ms");

    }

    public abstract void Challenge1() throws IOException;

    public abstract void Challenge2() throws IOException;

}
