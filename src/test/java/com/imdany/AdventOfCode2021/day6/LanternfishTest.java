package com.imdany.AdventOfCode2021.day6;

import org.junit.jupiter.api.Test;

public class LanternfishTest {

    @Test
    public void lanterfish_resetscycle(){

        Lanternfish l = new Lanternfish(6);
        assert (l.cycle ==6);

        assert (l.advanceDay() == false);
        assert (l.cycle ==5);

        assert (l.advanceDay() == false);
        assert (l.cycle ==4);

        assert (l.advanceDay() == false);
        assert (l.cycle ==3);

        assert (l.advanceDay() == false);
        assert (l.cycle ==2);

        assert (l.advanceDay() == false);
        assert (l.cycle ==1);

        assert (l.advanceDay() == true);
        assert (l.cycle ==6);
    }
}
