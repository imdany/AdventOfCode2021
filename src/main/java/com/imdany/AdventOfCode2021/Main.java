package com.imdany.AdventOfCode2021;

import com.imdany.AdventOfCode2021.day1.Day1Challenge;
import com.imdany.AdventOfCode2021.day2.Day2Challenge;
import com.imdany.AdventOfCode2021.day3.Day3Challenge;
import com.imdany.AdventOfCode2021.day4.Day4Challenge;
import com.imdany.AdventOfCode2021.day5.Day5Challenge;
import com.imdany.AdventOfCode2021.day6.Day6Challenge;
import com.imdany.AdventOfCode2021.day7.Day7Challenge;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        new Day1Challenge().run("Challenge 1");

        new Day2Challenge().run("Challenge 2");

        new Day3Challenge().run("Challenge 3");

        new Day4Challenge().run("Challenge 4");

        new Day5Challenge().run("Challenge 5");

        new Day6Challenge().run("Challenge 6");

        new Day7Challenge().run("Challenge 7");
    }
}
