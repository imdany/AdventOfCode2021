package com.imdany.AdventOfCode2021.day2;

import com.imdany.AdventOfCode2021.Runner;
import com.imdany.utils.ResourceReader;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.List;

@Slf4j
public class Day2Challenge extends Runner {

    public static void main(String[] args) throws IOException {
        Day2Challenge challenge = new Day2Challenge();
        challenge.run(challenge.getClass().getName());
    }
    @Override
    public void Challenge1() throws IOException {
        log.info("Challenge 1");
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

        log.info("Final Horizontal: " + xPosition);
        log.info("Final Depth: " + yPosition);
        log.info("Solution: " + (xPosition * yPosition));
    }

    @Override
    public  void Challenge2() throws IOException {
        log.info("Challenge 2");
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

        log.info("Final Horizontal: " + xPosition);
        log.info("Final AIM: " + aim);
        log.info("Final Depth: " + yPosition);
        log.info("Solution: " + (xPosition * yPosition));
    }

}
