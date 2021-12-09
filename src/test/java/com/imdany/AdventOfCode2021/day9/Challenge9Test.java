package com.imdany.AdventOfCode2021.day9;

import com.imdany.AdventOfCode2021.day8.EntriesChecker;
import com.imdany.utils.ResourceReader;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class Challenge9Test {

    ResourceReader resourceReader1;
    List<String> listInputs;

    {
        try {
            resourceReader1 = new ResourceReader("/AdventOfCode2021/day9/ex1.txt");
            listInputs = resourceReader1.resourceToListString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void challenge1Test() {
        SmokeMap sm = new SmokeMap(listInputs);

        assert(sm.map[0][0] == 2);
        assert(sm.map[9][4] == 8);
        assert(sm.riskLevel == 15);
    }

    @Test
    public void challenge2Test() {
        SmokeMap sm = new SmokeMap(listInputs);

        assert(sm.largestBasinSize == 1134);
    }


}
