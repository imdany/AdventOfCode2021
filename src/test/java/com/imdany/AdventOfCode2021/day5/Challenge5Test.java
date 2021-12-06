package com.imdany.AdventOfCode2021.day5;

import com.imdany.utils.ResourceReader;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class Challenge5Test {

    ResourceReader resourceReader1;
    List<String> listInputs;

    {
        try {
            resourceReader1 = new ResourceReader("/AdventOfCode2021/day5/ex1.txt");
             listInputs = resourceReader1.resourceToListString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void challenge1Test() {
        PositionChecker pc = new PositionChecker(listInputs, false);

        pc.processLines();
        pc.checkDiagram();

        assert(pc.result1 == 5);
    }

    @Test
    public void challenge2Test() {
        PositionChecker pc = new PositionChecker(listInputs, true);

        pc.processLines();
        pc.checkDiagram();

        assert(pc.result2 == 12);
    }

}
