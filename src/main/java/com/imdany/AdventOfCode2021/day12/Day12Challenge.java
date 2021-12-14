package com.imdany.AdventOfCode2021.day12;

import com.imdany.AdventOfCode2021.Runner;
import com.imdany.AdventOfCode2021.day11.OctopusSimulation;
import com.imdany.utils.ResourceReader;
import lombok.extern.slf4j.Slf4j;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@Slf4j
public class Day12Challenge extends Runner {

    public static void main(String[] args) throws IOException {
        Day12Challenge challenge = new Day12Challenge();
        challenge.run(challenge.getClass().getName());
    }

    @Override
    public void Challenge1() throws IOException {
        log.info("Challenge 1");

        ResourceReader resourceReader1 = new ResourceReader("/AdventOfCode2021/day12/input1.txt");
        List<String> list1 = resourceReader1.resourceToListString();;

        HashMap<String, Node> nodeMap = NodeFactory.createNodes(list1);
        RouteGenerator rg = new RouteGenerator(nodeMap, 0);

        log.info("Result: {}", rg.getTotalEndedRoutes());

    }

    @Override
    public void Challenge2() throws IOException {
        log.info("Challenge 2");
        ResourceReader resourceReader1 = new ResourceReader("/AdventOfCode2021/day12/input1.txt");
        List<String> list1 = resourceReader1.resourceToListString();;

        HashMap<String, Node> nodeMap = NodeFactory.createNodes(list1);
        RouteGenerator rg = new RouteGenerator(nodeMap, 1);

        log.info("Result: {}", rg.getTotalEndedRoutes());
    }
}
