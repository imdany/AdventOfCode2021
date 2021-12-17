package com.imdany.AdventOfCode2021.day16;

import com.imdany.AdventOfCode2021.day15.CaveGrid;
import com.imdany.utils.ResourceReader;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Challenge16Test {

    ResourceReader resourceReader1;
    int[][] list1;

    {
        try {
            resourceReader1 = new ResourceReader("/AdventOfCode2021/day16/ex1.txt");
            list1 = resourceReader1.resourceToIntGrid();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//
//    @Test
//    public void challenge1Test() {
//
//        assert(grid.result == 40);
//    }
//
//    @Test
//    public void challenge2Test() {
//
//        assert(grid.result == 315);
//    }

}
