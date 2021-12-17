package com.imdany.AdventOfCode2021.day15;

import com.imdany.AdventOfCode2021.day13.Grid;
import com.imdany.AdventOfCode2021.day13.GridFactory;
import com.imdany.utils.ResourceReader;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class Challenge15Test {

    ResourceReader resourceReader1;
    int[][] list1;

    {
        try {
            resourceReader1 = new ResourceReader("/AdventOfCode2021/day15/ex1.txt");
            list1 = resourceReader1.resourceToIntGrid();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void challenge1Test() {
        CaveGrid grid = new CaveGrid(list1, 10, 10);

        grid.printCave();
        grid.pathFinder();

        assert(grid.result == 40);
    }

    @Test
    public void challenge2Test() {
        int[][] newGrid = CaveGrid.expandGrid(list1);
        CaveGrid grid = new CaveGrid(newGrid, 50, 50);

        grid.printCave();
        grid.pathFinder();

        assert(grid.result == 315);
    }

}
