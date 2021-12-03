package com.imdany.AdventOfCode2021.day3;

import com.imdany.AdventOfCode2021.Runner;
import com.imdany.utils.ResourceReader;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.List;

@Slf4j
public class Day3Challenge extends Runner {

    public static void main(String[] args) throws IOException {
        Day3Challenge day3Challenge = new Day3Challenge();
        day3Challenge.run();
    }

    @Override
    public void Challenge1() throws IOException {
        log.info("Challenge 1");
        ResourceReader resourceReader = new ResourceReader("/AdventOfCode2021/day3/input.txt");
        List<String> elementsList = resourceReader.resourceToListString();

        DiagnosticReport dr = new DiagnosticReport(elementsList);
        dr.processPowerCosumption();
        dr.getReportPowerConsumption();

        // 1071734
    }

    @Override
    public void Challenge2() throws IOException {
        log.info("Challenge 2");
        ResourceReader resourceReader = new ResourceReader("/AdventOfCode2021/day3/input.txt");
        List<String> elementsList = resourceReader.resourceToListString();

        DiagnosticReport dr = new DiagnosticReport(elementsList);
        dr.processLifeSupport();
        dr.getReportLifeSupport();

        // 6124992
    }
}
