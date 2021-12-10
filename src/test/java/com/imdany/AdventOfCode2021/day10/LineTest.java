package com.imdany.AdventOfCode2021.day10;

import org.junit.jupiter.api.Test;

public class LineTest {

    @Test
    public void checkBasicChucks(){
        String chuck1 = "([])";
        Line line = new Line(chuck1);
        assert(line.getIsValid() == true);

        String chuck2 = "{()()()}";
        Line line2 = new Line(chuck2);
        assert(line2.getIsValid() == true);

        String chuck3 = "(((((((((())))))))))";
        Line line3 = new Line(chuck3);
        assert(line3.getIsValid() == true);
    }

    @Test
    public void checkLine_test(){
        String input1 = "{([(<{}[<>[]}>{[]{[(<()>";
        Line line = new Line(input1);
        assert(line.getIsValid() == false);

        String input2 = "[[<[([]))<([[{}[[()]]]";
        Line line2 = new Line(input2);
        assert(line2.getIsValid() == false);

        String input3 = "[{[{({}]{}}([{[{{{}}([]";
        Line line3 = new Line(input3);
        assert(line3.getIsValid() == false);

        String input4 = "[<(<(<(<{}))><([]([]()";
        Line line4 = new Line(input4);
        assert(line4.getIsValid() == false);

        String input5 = "<{([([[(<>()){}]>(<<{{";
        Line line5 = new Line(input5);
        assert(line4.getIsValid() == false);

        // Valid lines
        String input6 = "[({(<(())[]>[[{[]{<()<>>";
        Line line6 = new Line(input6);
        assert(line6.getIsValid() == true);

        String input7 = "[(()[<>])]({[<{<<[]>>(";
        Line line7 = new Line(input7);
        assert(line7.getIsValid() == true);

    }

    @Test
    public void completeLine_Test(){
        String input1 = "<{([{{}}[<[[[<>{}]]]>[]]";
        Line line1 = new Line(input1);
        assert(line1.getMissingChar().equals("])}>"));
        assert(line1.getCost() == 294);

        String input2 = "[({(<(())[]>[[{[]{<()<>>";
        Line line2 = new Line(input2);
        assert(line2.getMissingChar().equals("}}]])})]"));
        assert(line2.getCost() == 288957);

        String input3 = "[(()[<>])]({[<{<<[]>>(";
        Line line3 = new Line(input3);
        assert(line3.getMissingChar().equals(")}>]})"));
        assert(line3.getCost() == 5566);

        String input4 = "(((({<>}<{<{<>}{[]{[]{}";
        Line line4 = new Line(input4);
        assert(line4.getMissingChar().equals("}}>}>))))"));
        assert(line4.getCost() == 1480781);

        String input5 = "{<[[]]>}<{[{[{[]{()[[[]";
        Line line5 = new Line(input5);
        assert(line5.getMissingChar().equals("]]}}]}]}>"));
        assert(line5.getCost() == 995444);
    }
}
