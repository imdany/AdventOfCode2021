package com.imdany.AdventOfCode2021.day2;

import com.imdany.AdventOfCode2021.Runner;
import com.imdany.AdventOfCode2021.day3.Day3Challenge;
import com.imdany.utils.ResourceReader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class Day2Challenge extends Runner {

    public static void main(String[] args) throws IOException {
        Day2Challenge day2Challenge = new Day2Challenge();
        day2Challenge.Run(2);
    }
    @Override
    public void Challenge1() throws IOException {
        System.out.println("--- + Challenge 1---");
        ResourceReader resourceReader = new ResourceReader("/AdventOfCode2021/day2/1.txt");
        List<String> movementList = resourceReader.resourceToListString();

        // Parse commands
        int xPosition = 0;
        int yPosition = 0;
        for (String element: movementList) {
            String[] split = element.split(" ");
            String command =  split[0];
            int value = Integer.parseInt(split[1]);

            // update position
            switch (command) {
                case "forward":
                    xPosition = xPosition + value;
                    break;
                case "down":
                    yPosition = yPosition + value;
                    break;
                case "up":
                    yPosition = yPosition - value;
                    break;
            }
        }

        System.out.println("Final Horizontal: " + xPosition);
        System.out.println("Final Depth: " + yPosition);
        System.out.println("Result: " + (xPosition * yPosition));
    }

    @Override
    public  void Challenge2() throws IOException {
        System.out.println("--- + Challenge 2---");
        ResourceReader resourceReader = new ResourceReader("/AdventOfCode2021/day2/1.txt");
        List<String> movementList = resourceReader.resourceToListString();

        // Parse commands
        int xPosition = 0;
        int yPosition = 0;
        int aim = 0;
        for (String element: movementList) {
            String[] split = element.split(" ");
            String command =  split[0];
            int value = Integer.parseInt(split[1]);

            // update position
            switch (command) {
                case "forward":
                    xPosition = xPosition + value;
                    yPosition = aim * value + yPosition;
                    break;
                case "down":
                    aim = aim  + value;
                    break;
                case "up":
                    aim = aim - value;
                    break;
            }
        }

        System.out.println("Final Horizontal: " + xPosition);
        System.out.println("Final AIM: " + aim);
        System.out.println("Final Depth: " + yPosition);
        System.out.println("Result: " + (xPosition * yPosition));
    }

}
