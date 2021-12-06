package com.imdany.AdventOfCode2021.day5;

import org.junit.jupiter.api.Test;

import java.util.List;

public class PositionFactoryTest {

    PositionFactory pfStraights = new PositionFactory(false);
    PositionFactory pfDiagonals = new PositionFactory(true);

    @Test
    public void createPositionTest() {
        String input = "9,12";

        Position p = pfStraights.createPosition(input);

        assert(p.x == 9);
        assert(p.y == 12);
    }

    @Test
    public void createStraightLinesTest(){
        String input = "0,9 -> 5,9";
        List<Position> positionList = pfStraights.createLine(input);
        assert(positionList.get(0).x == 0 && positionList.get(0).y == 9 );
        assert(positionList.get(1).x == 1 && positionList.get(1).y == 9 );
        assert(positionList.get(2).x == 2 && positionList.get(2).y == 9 );
        assert(positionList.get(3).x == 3 && positionList.get(3).y == 9 );
        assert(positionList.get(4).x == 4 && positionList.get(4).y == 9 );
        assert(positionList.get(5).x == 5 && positionList.get(5).y == 9 );

        String input2 = "7,0 -> 7,4";
        List<Position> positionList2 = pfStraights.createLine(input2);
        assert(positionList2.get(0).x == 7 && positionList2.get(0).y == 0 );
        assert(positionList2.get(1).x == 7 && positionList2.get(1).y == 1 );
        assert(positionList2.get(2).x == 7 && positionList2.get(2).y == 2 );
        assert(positionList2.get(3).x == 7 && positionList2.get(3).y == 3 );
        assert(positionList2.get(4).x == 7 && positionList2.get(4).y == 4 );

        String input3 = "2,2 -> 2,1";
        List<Position> positionList3 = pfStraights.createLine(input3);
        assert(positionList3.get(0).x == 2 && positionList3.get(0).y == 1 );
        assert(positionList3.get(1).x == 2 && positionList3.get(1).y == 2 );
    }

    @Test
    public void createDiagonalLinesTest(){
        String input = "8,0 -> 0,8";
        List<Position> positionList = pfDiagonals.createLine(input);
        assert(positionList.get(0).x == 0 && positionList.get(0).y == 8 );
        assert(positionList.get(1).x == 1 && positionList.get(1).y == 7 );
        assert(positionList.get(2).x == 2 && positionList.get(2).y == 6 );
        assert(positionList.get(3).x == 3 && positionList.get(3).y == 5 );
        assert(positionList.get(4).x == 4 && positionList.get(4).y == 4 );
        assert(positionList.get(5).x == 5 && positionList.get(5).y == 3 );
        assert(positionList.get(6).x == 6 && positionList.get(6).y == 2 );
        assert(positionList.get(7).x == 7 && positionList.get(7).y == 1 );
        assert(positionList.get(8).x == 8 && positionList.get(8).y == 0 );

        String input2 = "0,0 -> 8,8";
        List<Position> positionList2 = pfDiagonals.createLine(input2);
        assert(positionList2.get(0).x == 0 && positionList2.get(0).y == 0 );
        assert(positionList2.get(1).x == 1 && positionList2.get(1).y == 1 );
        assert(positionList2.get(2).x == 2 && positionList2.get(2).y == 2 );
        assert(positionList2.get(3).x == 3 && positionList2.get(3).y == 3 );
        assert(positionList2.get(4).x == 4 && positionList2.get(4).y == 4 );
        assert(positionList2.get(5).x == 5 && positionList2.get(5).y == 5 );
        assert(positionList2.get(6).x == 6 && positionList2.get(6).y == 6 );
        assert(positionList2.get(7).x == 7 && positionList2.get(7).y == 7 );
        assert(positionList2.get(8).x == 8 && positionList2.get(8).y == 8 );

        String input3 = "6,4 -> 2,0";
        List<Position> positionList3 = pfDiagonals.createLine(input3);
        assert(positionList3.get(0).x == 2 && positionList3.get(0).y == 0 );
        assert(positionList3.get(1).x == 3 && positionList3.get(1).y == 1 );
        assert(positionList3.get(2).x == 4 && positionList3.get(2).y == 2 );
        assert(positionList3.get(3).x == 5 && positionList3.get(3).y == 3 );
        assert(positionList3.get(4).x == 6 && positionList3.get(4).y == 4 );

        String input4 = "5,5 -> 8,2";
        List<Position> positionList4 = pfDiagonals.createLine(input4);
        assert(positionList4.get(0).x == 5 && positionList4.get(0).y == 5 );
        assert(positionList4.get(1).x == 6 && positionList4.get(1).y == 4 );
        assert(positionList4.get(2).x == 7 && positionList4.get(2).y == 3 );
        assert(positionList4.get(3).x == 8 && positionList4.get(3).y == 2 );
    }
}
