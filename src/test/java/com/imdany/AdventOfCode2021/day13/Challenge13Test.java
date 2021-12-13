package com.imdany.AdventOfCode2021.day13;

import com.imdany.AdventOfCode2021.day12.Node;
import com.imdany.AdventOfCode2021.day12.NodeFactory;
import com.imdany.AdventOfCode2021.day12.RouteGenerator;
import com.imdany.utils.ResourceReader;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class Challenge13Test {

    ResourceReader resourceReader1;
    List<String> list1;

    {
        try {
            resourceReader1 = new ResourceReader("/AdventOfCode2021/day13/ex1.txt");
            list1 = resourceReader1.resourceToListString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void challenge1Test() {
        Grid grid = GridFactory.creategrid(list1);
        grid.foldX(7);
        assert(grid.countVisible() == 17);
    }
}
