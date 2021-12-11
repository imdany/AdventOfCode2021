package com.imdany.AdventOfCode2021.day11;

import org.junit.jupiter.api.Test;

public class OctopusTest {

    @Test
    public void createOctopus_passes(){
        Octopus o1 = new Octopus(1, "");

        assert (o1.getCurrentEnery() == 1);

        o1.increaseEnergy(1);
        assert (o1.getCurrentEnery() == 2);

        o1.resetEnergyLevel();
        assert (o1.getCurrentEnery() == 0);
    }

    @Test
    public void checkFlashing_passes(){
        Octopus o2 = new Octopus(9, "");

        o2.increaseEnergy(1);
        assert(o2.isFlashing());

        o2.increaseEnergy(1);
        assert(o2.getCurrentEnery() == 10);
    }

}
