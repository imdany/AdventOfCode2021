package com.imdany.AdventOfCode2021.day12;

import com.imdany.AdventOfCode2021.day11.OctopusSimulation;
import com.imdany.utils.ResourceReader;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class Challenge12Test {

    ResourceReader resourceReader1;
    ResourceReader resourceReader2;
    List<String> list1;
    List<String> list2;

    {
        try {
            resourceReader1 = new ResourceReader("/AdventOfCode2021/day12/ex2.txt");
            list1 = resourceReader1.resourceToListString();
            resourceReader2 = new ResourceReader("/AdventOfCode2021/day12/ex3.txt");
            list2 = resourceReader2.resourceToListString();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void challenge1Test() {
        // Example 1
        HashMap<String, Node> nodeMap = NodeFactory.createNodes(list1);
        RouteGenerator rg = new RouteGenerator(nodeMap, 0);

        assert(rg.getTotalEndedRoutes() == 19);

        //Example 2
        HashMap<String, Node> nodeMap2 = NodeFactory.createNodes(list2);
        RouteGenerator rg2 = new RouteGenerator(nodeMap2, 0);

        assert(rg2.getTotalEndedRoutes() == 226 );
    }

    @Test
    public void challenge2Test() {

        // Example 1
        HashMap<String, Node> nodeMap = NodeFactory.createNodes(list1);
        RouteGenerator rg = new RouteGenerator(nodeMap, 1);

        assert(rg.getTotalEndedRoutes() == 103);

        //Example 2
        HashMap<String, Node> nodeMap2 = NodeFactory.createNodes(list2);
        RouteGenerator rg2 = new RouteGenerator(nodeMap2, 1);

        assert(rg2.getTotalEndedRoutes() == 3509 );

    }


}
