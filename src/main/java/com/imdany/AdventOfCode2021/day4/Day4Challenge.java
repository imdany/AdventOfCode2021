package com.imdany.AdventOfCode2021.day4;

import com.imdany.AdventOfCode2021.Runner;
import com.imdany.AdventOfCode2021.day3.Day3Challenge;
import com.imdany.utils.ResourceReader;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.List;

@Slf4j
public class Day4Challenge extends Runner {

    public static void main(String[] args) throws IOException {
        Day4Challenge day4Challenge = new Day4Challenge();
        day4Challenge.run();
    }

    @Override
    public void Challenge1() throws IOException {
        log.info("Challenge 1");
        ResourceReader resourceReader1 = new ResourceReader("/AdventOfCode2021/day4/ex1.txt");
        List<String> listBoards = resourceReader1.resourceToListString();

        ResourceReader resourceReader2 = new ResourceReader("/AdventOfCode2021/day4/ex2.txt");
        List<String> playedValues = resourceReader1.resourceToListString();

        System.out.println(listBoards);
        System.out.println(playedValues);

        List<BingoBoard> boards = BingoBoardFactory.processList(listBoards);
        System.out.println(boards);
    }

    @Override
    public void Challenge2() throws IOException {

    }
}
