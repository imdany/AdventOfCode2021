package com.imdany.AdventOfCode2021.day6;

import com.imdany.utils.ResourceReader;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class Challenge6Test {

    ResourceReader resourceReader1;
    List<Integer> listInputs;

    {
        try {
            resourceReader1 = new ResourceReader("/AdventOfCode2021/day6/ex1.txt");
            listInputs = resourceReader1.lineToIntegerList();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void challenge1Test() {
        SimulationRunner sr = new SimulationRunner(listInputs);

        sr.playDays(18);
        System.out.println(sr.getStatus());
        assert(sr.getStatus() == 26L);

        SimulationRunner sr2 = new SimulationRunner(listInputs);
        sr2.playDays(80);
        System.out.println(sr2.getStatus());
        assert(sr2.getStatus() == 5934L);
    }

    @Test
    public void challenge2Test() {
        SimulationRunner sr = new SimulationRunner(listInputs);

        sr.playDays(256);
        System.out.println(sr.getStatus());
        assert(sr.getStatus() == 26984457539L);

    }


}
