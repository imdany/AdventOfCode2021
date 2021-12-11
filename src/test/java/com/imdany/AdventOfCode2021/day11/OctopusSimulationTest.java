package com.imdany.AdventOfCode2021.day11;

import com.imdany.utils.ResourceReader;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class OctopusSimulationTest {

    ResourceReader resourceReader1;
    int[][] inputGrid1;

    ResourceReader resourceReader2;
    int[][] inputGrid2;


    {
        try {
            resourceReader1 = new ResourceReader("/AdventOfCode2021/day11/ex1.txt");
            inputGrid1 = resourceReader1.resourceToIntGrid();

            resourceReader2 = new ResourceReader("/AdventOfCode2021/day11/test1.txt");
            inputGrid2 = resourceReader2.resourceToIntGrid();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void Test1(){
        OctopusSimulation os = new OctopusSimulation(5, 5, inputGrid1);
        os.printGrid();
        os.run(1);
        os.run(1);
    }

    @Test
    public void Test2(){
        OctopusSimulation os = new OctopusSimulation(4, 4, inputGrid2);
        os.printGrid();
        os.run(1);
        os.run(1);
    }
}
