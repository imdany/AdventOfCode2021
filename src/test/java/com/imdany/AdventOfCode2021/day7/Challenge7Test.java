package com.imdany.AdventOfCode2021.day7;

import com.imdany.AdventOfCode2021.day6.SimulationRunner;
import com.imdany.utils.ResourceReader;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class Challenge7Test {

    ResourceReader resourceReader1;
    int[] listInputs;

    {
        try {
            resourceReader1 = new ResourceReader("/AdventOfCode2021/day7/ex1.txt");
            listInputs = resourceReader1.lineToIntegerList().stream().mapToInt(i->i).toArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void challenge1Test() {

        Aligner al = new Aligner(listInputs, 1);

        AlignmentChecker ac1 = new AlignmentChecker1(2, listInputs);
        assert(ac1.getFuelConsumption() == 37);
        assert(ac1.getCentralPosition() == 2);

        AlignmentChecker ac2 = new AlignmentChecker1(1, listInputs);
        assert(ac2.getFuelConsumption() == 41);
        assert(ac2.getCentralPosition() == 1);

        AlignmentChecker ac3 = new AlignmentChecker1(3, listInputs);
        assert(ac3.getFuelConsumption() == 39);
        assert(ac3.getCentralPosition() == 3);

        AlignmentChecker ac4 = new AlignmentChecker1(10, listInputs);
        assert(ac4.getFuelConsumption() == 71);
        assert(ac4.getCentralPosition() == 10);

        assert(al.leastConsumptionFuel == 37);
        assert(al.leastConsumptionPosition == 2);

    }

    @Test
    public void challenge2Test() {

        Aligner al = new Aligner(listInputs, 2);

        AlignmentChecker ac1 = new AlignmentChecker2(5, listInputs);
        assert(ac1.getFuelConsumption() == 168);
        assert(ac1.getCentralPosition() == 5);

        AlignmentChecker ac2 = new AlignmentChecker2(2, listInputs);
        assert(ac2.getFuelConsumption() == 206);
        assert(ac2.getCentralPosition() == 2);
    }


}
