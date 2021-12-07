package com.imdany.AdventOfCode2021.day7;

import org.junit.jupiter.api.Test;

public class AlignmentChecker2Test {

    @Test
    public void fuelCalculationTest() {
        AlignmentChecker2 ac1 = new AlignmentChecker2(16, new int[]{5});
        assert(ac1.getFuelConsumption() == 66);
    }

}
