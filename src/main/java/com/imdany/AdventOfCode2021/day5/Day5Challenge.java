package com.imdany.AdventOfCode2021.day5;

import com.imdany.AdventOfCode2021.Runner;
import com.imdany.AdventOfCode2021.day4.BingoPlayer;
import com.imdany.utils.ResourceReader;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.List;

@Slf4j
public class Day5Challenge extends Runner {

    public static void main(String[] args) throws IOException {
        Day5Challenge day5Challenge = new Day5Challenge();
        day5Challenge.run();
    }

    @Override
    public void Challenge1() throws IOException {
//        log.info("Challenge 1");
//        ResourceReader resourceReader1 = new ResourceReader("/AdventOfCode2021/day5/input1.txt");
//        List<String> listInputs = resourceReader1.resourceToListString();
//
//        System.out.println(listInputs);
//
//        PositionChecker pc = new PositionChecker(listInputs, false);
//
//        pc.processLines();
//        pc.checkDiagram();
        //6005
    }

    @Override
    public void Challenge2() throws IOException {
        log.info("Challenge 2");
        ResourceReader resourceReader1 = new ResourceReader("/AdventOfCode2021/day5/input1.txt");
        List<String> listInputs = resourceReader1.resourceToListString();

        System.out.println(listInputs);

        PositionChecker pc = new PositionChecker(listInputs, true);

        pc.processLines();
        pc.checkDiagram();
    }
}
