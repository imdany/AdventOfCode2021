package com.imdany.AdventOfCode2021.day6;

import org.junit.jupiter.api.Test;

public class LanternfishTest {

    @Test
    public void lanterfish_add_remove(){

        Lanternfish l = new Lanternfish(6, 0);
        assert (l.cycle ==6);

        l.add(1);
        assert (l.population == 1);

        l.add(1);
        assert (l.population == 2);

        l.remove(1);
        assert (l.population == 1);

    }
}
