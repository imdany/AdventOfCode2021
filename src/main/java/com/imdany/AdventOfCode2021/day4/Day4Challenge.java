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
        Day4Challenge challenge = new Day4Challenge();
        challenge.run(challenge.getClass().getName());
    }

    @Override
    public void Challenge1() throws IOException {
        log.info("Challenge 1");
        ResourceReader resourceReader1 = new ResourceReader("/AdventOfCode2021/day4/input1.txt");
        List<String> listBoards = resourceReader1.resourceToListString();

        ResourceReader resourceReader2 = new ResourceReader("/AdventOfCode2021/day4/input2.txt");
        List<Integer> playedValues = resourceReader2.lineToIntegerList();

        BingoPlayer bp = new BingoPlayer(listBoards, playedValues);
        bp.playStrategy1();
        //6592
    }

    @Override
    public void Challenge2() throws IOException {
        log.info("Challenge 2");
        ResourceReader resourceReader1 = new ResourceReader("/AdventOfCode2021/day4/input1.txt");
        List<String> listBoards = resourceReader1.resourceToListString();

        ResourceReader resourceReader2 = new ResourceReader("/AdventOfCode2021/day4/input2.txt");
        List<Integer> playedValues = resourceReader2.lineToIntegerList();

        BingoPlayer bp = new BingoPlayer(listBoards, playedValues);
        bp.playStrategy2();
        // 31755
    }
}
