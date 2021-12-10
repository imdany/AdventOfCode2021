package com.imdany.AdventOfCode2021.day10;

import com.imdany.AdventOfCode2021.day9.SmokeMap;
import com.imdany.utils.ResourceReader;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class Challenge10Test {

    ResourceReader resourceReader1;
    List<String> listInputs;

    {
        try {
            resourceReader1 = new ResourceReader("/AdventOfCode2021/day10/ex1.txt");
            listInputs = resourceReader1.resourceToListString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void challenge1Test() {
        SyntaxChecker sc = new SyntaxChecker(listInputs);
        assert(sc.totalScore==26397);
    }

    @Test
    public void challenge2Test() {
        SyntaxChecker sc = new SyntaxChecker(listInputs);
        assert(sc.middleCost == 288957);
    }


}
