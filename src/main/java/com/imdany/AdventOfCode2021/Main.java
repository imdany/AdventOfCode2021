package com.imdany.AdventOfCode2021;

import com.imdany.AdventOfCode2021.day1.Day1Challenge;
import com.imdany.AdventOfCode2021.day10.Day10Challenge;
import com.imdany.AdventOfCode2021.day2.Day2Challenge;
import com.imdany.AdventOfCode2021.day3.Day3Challenge;
import com.imdany.AdventOfCode2021.day4.Day4Challenge;
import com.imdany.AdventOfCode2021.day5.Day5Challenge;
import com.imdany.AdventOfCode2021.day6.Day6Challenge;
import com.imdany.AdventOfCode2021.day7.Day7Challenge;
import com.imdany.AdventOfCode2021.day8.Day8Challenge;
import com.imdany.AdventOfCode2021.day9.Day9Challenge;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        new Day1Challenge().run("Day 1");

        new Day2Challenge().run("Day 2");

        new Day3Challenge().run("Day 3");

        new Day4Challenge().run("Day 4");

        new Day5Challenge().run("Day 5");

        new Day6Challenge().run("Day 6");

        new Day7Challenge().run("Day 7");

        new Day8Challenge().run("Day 8");

        new Day9Challenge().run("Day 9");

        new Day10Challenge().run("Day 10");
    }
}
