package com.imdany.AdventOfCode2021.day12;

import com.imdany.utils.ResourceReader;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class RouteTest {

    ResourceReader resourceReader1;
    List<String> list1;

    {
        try {
            resourceReader1 = new ResourceReader("/AdventOfCode2021/day12/ex1.txt");
            list1 = resourceReader1.resourceToListString();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void createsRoute(){
        HashMap<String, Node> nodeMap = NodeFactory.createNodes(list1);
        RouteGenerator rg = new RouteGenerator(nodeMap, 0);

        assert(rg.getTotalEndedRoutes() == 10);
    }

    @Test
    public void createsRoute_Type1(){
        HashMap<String, Node> nodeMap = NodeFactory.createNodes(list1);
        RouteGenerator rg = new RouteGenerator(nodeMap, 1);

        assert(rg.getTotalEndedRoutes() == 36);
    }

    @Test
    public void routeContains(){
        HashMap<String, Node> nodeMap = NodeFactory.createNodes(list1);

        Route r = new Route(nodeMap.get("A"), List.of(nodeMap.get("start"), nodeMap.get("b"), nodeMap.get("b")), nodeMap);
        assert(!r.isNodeVisited(nodeMap.get("A")));
        assert(r.isNodeVisited(nodeMap.get("b")));
        assert(r.countNodes(nodeMap.get("b")) == 2);

        assert(r.checkCountSmallNodes(2) == true);
    }
}
