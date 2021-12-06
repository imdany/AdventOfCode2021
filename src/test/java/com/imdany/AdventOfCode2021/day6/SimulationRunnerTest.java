package com.imdany.AdventOfCode2021.day6;

import com.imdany.AdventOfCode2021.day5.PositionChecker;
import com.imdany.utils.ResourceReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class SimulationRunnerTest {

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
    public void playDays_advancesDays(){
        SimulationRunner sr = new SimulationRunner(listInputs);
        assert(sr.getCurrentDay() == 0);

        sr.playDays(3);
        assert(sr.getCurrentDay() == 3);
    }

    @Test
    public void creates_initial_list(){
        SimulationRunner sr = new SimulationRunner(listInputs);
        assert(sr.getStatus() == 5);

        List<Integer> l1 = sr.getCurrentStatusOfLantterfish();
        Assertions.assertIterableEquals(l1, Arrays.asList(3, 4, 3, 1, 2));

    }

    @Test
    public void plays_advances_firstsDays(){
        SimulationRunner sr = new SimulationRunner(listInputs);
        assert(sr.getStatus() == 5);

        List<Integer> l1 = sr.play();
        Assertions.assertIterableEquals(l1, Arrays.asList(2, 3, 2, 0, 1));

        List<Integer> l2 = sr.play();
        Assertions.assertIterableEquals(l2, Arrays.asList(1, 2, 1, 6, 0, 8));

        List<Integer> l3 = sr.play();
        Assertions.assertIterableEquals(l3, Arrays.asList(0, 1, 0, 5, 6, 7, 8));

        List<Integer> l4 = sr.play();
        Assertions.assertIterableEquals(l4, Arrays.asList(6, 0, 6, 4, 5, 6, 7, 8, 8));

        List<Integer> l5 = sr.play();
        Assertions.assertIterableEquals(l5, Arrays.asList(5,6,5,3,4,5,6,7,7,8));


        List<Integer> l6 = sr.play();
        Assertions.assertIterableEquals(l6, Arrays.asList(4,5,4,2,3,4,5,6,6,7));
    }

    @Test
    public void challenge1Test() {
        SimulationRunner sr = new SimulationRunner(listInputs);

        sr.playDays(19);
        assert(sr.getStatus() == 26L);

        sr.playDays(80-18);
        assert(sr.getStatus() == 5934L);
    }

    @Test
    public void challenge2Test() {
        SimulationRunner sr = new SimulationRunner(listInputs);

        sr.playDays(257);
        assert(sr.getStatus() == 26984457539L);

    }

}
