package com.imdany.AdventOfCode2021.day3;

import lombok.Data;

@Data
public class ReportNumber {

    private char[] positions;

    public ReportNumber(String number) {
        this.positions = number.toCharArray();
    }

    public char getPosition(int i) {
        return positions[i];
    }

}
