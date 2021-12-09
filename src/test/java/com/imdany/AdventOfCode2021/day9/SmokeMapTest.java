package com.imdany.AdventOfCode2021.day9;

import com.imdany.utils.ResourceReader;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class SmokeMapTest {

    ResourceReader resourceReader1 = new ResourceReader("/AdventOfCode2021/day9/ex1.txt");
    List<String> listInputs = resourceReader1.resourceToListString();

    public SmokeMapTest() throws IOException {
    }

    @Test
    public void calculate_LowPoints(){
        SmokeMap sm = new SmokeMap(listInputs);
        assert(sm.riskLevel == 15);
    }

    @Test
    public void identify_basin(){
        SmokeMap sm = new SmokeMap(listInputs);

        assert(sm.nBasin == 4);
    }

}
