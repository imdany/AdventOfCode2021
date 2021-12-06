package com.imdany.AdventOfCode2021.day5;

import org.junit.jupiter.api.Test;

public class DiagramTest {

    Diagram d = new Diagram(10, 10);

    @Test
    public void addPositionTest() {
        d.addPosition(new Position(1, 1));
        assert(d.positions[1][1] == 1);

        d.addPosition(new Position(1, 1));
        assert(d.positions[1][1] == 2);
    }

    @Test
    public void getOverlapingLinesTest() {
        d.addPosition(new Position(1, 1));
        assert(d.getOverlapingLines() == 0);

        d.addPosition(new Position(1, 1));
        assert(d.getOverlapingLines() == 1);

        d.addPosition(new Position(1, 1));
        assert(d.getOverlapingLines() == 1);

    }
}
