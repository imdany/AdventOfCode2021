package com.imdany.AdventOfCode2021.day17;

import com.imdany.AdventOfCode2021.day15.CaveGrid;
import com.imdany.utils.ResourceReader;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Challenge17Test {

    @Test
    public void challenge1Test() {
        ProbeShot pb = new ProbeShot(20, 30, -10, -5);

        double result = pb.findPosition();
        assert(result == 45);
    }

    @Test
    public void challenge2Test() {
        ProbeShot pb = new ProbeShot(20, 30, -10, -5);

        int result = pb.findCombinations();
        assert(result == 112);
    }

}
