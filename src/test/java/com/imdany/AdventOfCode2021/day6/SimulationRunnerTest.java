package com.imdany.AdventOfCode2021.day6;

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
    public void playIndividualDay(){
        SimulationRunner sr = new SimulationRunner(Arrays.asList(8));
        assert(sr.getCurrentDay() == 0);

        long[] l1 = sr.play();
        System.out.println(Arrays.toString(l1));
        Assertions.assertArrayEquals(l1, new long[]{0,0,0,0,0,0,0,1,0});

    }

    @Test
    public void creates_initial_list(){
        SimulationRunner sr = new SimulationRunner(listInputs);
        assert(sr.getStatus() == 5);

        long[] l1 = sr.getCurrentStatusOfLantterfish();
        Assertions.assertArrayEquals(l1, new long[]{0,1,1,2,1,0,0,0,0});

    }

    @Test
    public void plays_advances_firstsDays(){
        SimulationRunner sr = new SimulationRunner(listInputs);
        assert(sr.getStatus() == 5);

        long[] l1 = sr.play();
        Assertions.assertArrayEquals(new long[]{1,1,2,1,0,0,0,0,0}, l1);

        long[]  l2 = sr.play();
        Assertions.assertArrayEquals(new long[]{1,2,1,0,0,0,1,0,1}, l2);

        long[] l3 = sr.play();
        Assertions.assertArrayEquals(new long[]{2,1,0,0,0,1,1,1,1}, l3);


        long[] l4 = sr.play();
        Assertions.assertArrayEquals(new long[]{1,0,0,0,1,1,3,1,2}, l4);

        long[]  l5 = sr.play();
        Assertions.assertArrayEquals(new long[]{0,0,0,1,1,3,2,2,1}, l5);

        long[]  l6 = sr.play();
        Assertions.assertArrayEquals(new long[]{0,0,1,1,3,2,2,1,0}, l6);

        long[]  l7 = sr.play();
        Assertions.assertArrayEquals(new long[]{0,1,1,3,2,2,1,0,0}, l7);

        long[]  l8 = sr.play();
        Assertions.assertArrayEquals(new long[]{1,1,3,2,2,1,0,0,0}, l8);

        long[]  l9 = sr.play();
        Assertions.assertArrayEquals(new long[]{1,3,2,2,1,0,1,0,1}, l9);


        long[]  l10 = sr.play();
        Assertions.assertArrayEquals(new long[]{3,2,2,1,0,1,1,1,1}, l10);

        long[]  l11 = sr.play();
        Assertions.assertArrayEquals(new long[]{2,2,1,0,1,1,4,1,3}, l11);

        long[]  l12 = sr.play();
        long[]  l13 = sr.play();
        long[]  l14 = sr.play();
        long[]  l15 = sr.play();
        long[]  l16 = sr.play();
        long[]  l17 = sr.play();
        long[]  l18 = sr.play();

        Assertions.assertArrayEquals(new long[]{3,5,3,2,2,1,5,1,4}, l18);
    }

}
