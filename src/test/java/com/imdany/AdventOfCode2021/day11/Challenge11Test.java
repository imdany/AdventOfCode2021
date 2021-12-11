package com.imdany.AdventOfCode2021.day11;

import com.imdany.AdventOfCode2021.day10.SyntaxChecker;
import com.imdany.utils.ResourceReader;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class Challenge11Test {

    ResourceReader resourceReader1;
    int[][] inputGrid;

    {
        try {
            resourceReader1 = new ResourceReader("/AdventOfCode2021/day11/ex2.txt");
            inputGrid = resourceReader1.resourceToIntGrid();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void challenge1Test() {
        OctopusSimulation os = new OctopusSimulation(10, 10, inputGrid);
        os.run(10);

        assert(os.getFlahes() == 204);

        OctopusSimulation os2 = new OctopusSimulation(10, 10, inputGrid);
        os2.run(100);

        assert(os2.getFlahes() == 1656);
    }

    @Test
    public void challenge2Test() {
        OctopusSimulation os = new OctopusSimulation(10, 10, inputGrid);
        os.runUntilSync();

        assert(os.getDaysUntilSync() == 195);
    }


}
