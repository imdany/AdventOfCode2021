package com.imdany.AdventOfCode2021.day13;

import com.imdany.AdventOfCode2021.Runner;
import com.imdany.AdventOfCode2021.day12.Node;
import com.imdany.AdventOfCode2021.day12.NodeFactory;
import com.imdany.AdventOfCode2021.day12.RouteGenerator;
import com.imdany.utils.ResourceReader;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@Slf4j
public class Day13Challenge extends Runner {

    public static void main(String[] args) throws IOException {
        Day13Challenge challenge = new Day13Challenge();
        challenge.run(challenge.getClass().getName());
    }

    @Override
    public void Challenge1() throws IOException {
        log.info("Challenge 1");
        ResourceReader resourceReader1 = new ResourceReader("/AdventOfCode2021/day13/input1.txt");
        List<String> list1 = resourceReader1.resourceToListString();;

        Grid grid = GridFactory.creategrid(list1);
        grid.foldY(655);

        log.info("Result: {}", grid.countVisible());
    }

    @Override
    public void Challenge2() throws IOException {
        log.info("Challenge 2");
        ResourceReader resourceReader1 = new ResourceReader("/AdventOfCode2021/day13/input1.txt");
        List<String> list1 = resourceReader1.resourceToListString();;

        Grid grid = GridFactory.creategrid(list1);
        grid.foldY(655);
        grid.foldX(447);
        grid.foldY(327);
        grid.foldX(223);
        grid.foldY(163);
        grid.foldX(111);
        grid.foldY(81);
        grid.foldX(55);
        grid.foldY(40);
        grid.foldX(27);
        grid.foldX(13);
        grid.foldX(6);
        grid.printGrid(-1);
    }
}
