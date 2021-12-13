package com.imdany.AdventOfCode2021.day12;

import com.imdany.utils.ResourceReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class NodeTest {

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
    public void createsNodeFromText(){
        HashMap<String, Node> nodeMap = NodeFactory.createNodes(list1);

        assert(nodeMap.size() == 6);
        Node n1 = nodeMap.get("start");
        assert(n1.name.equals("start"));
        assert(n1.isBig == false);
        Assertions.assertEquals(n1.neighbor, Arrays.asList("A", "b"));
    }
}
