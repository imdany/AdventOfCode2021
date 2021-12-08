package com.imdany.AdventOfCode2021.day8;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class PatternAnalyzerTest {

    @Test
    public void checkAnalizer(){

        String pattern = "acedgfb cdfbe gcdfa fbcad dab cefabd cdfgeb eafb cagedb ab";
        PatternAnalyzer pa = new PatternAnalyzer(List.of(pattern.split(" ")));
        pa.analyze();
        System.out.println(pa);

        assert(pa.N1.equals("ab"));
        assert(pa.N4.equals("eafb"));
        assert(pa.N7.equals("dab"));
        assert(pa.N8.equals("acedgfb"));
        assert(pa.N6.equals("cdfgeb"));
        assert(pa.N5.equals("cdfbe"));
        assert(pa.N2.equals("gcdfa"));
        assert(pa.N3.equals("fbcad"));
        assert(pa.N9.equals("cefabd"));
        assert(pa.N0.equals("cagedb"));

        assert(pa.translateElement("cdfeb") == 5);
        assert(pa.translateElement("fcadb") == 3);
        assert(pa.translateElement("cdfeb") == 5);
        assert(pa.translateElement("cdbaf") == 3);

        assert(pa.translateList(Arrays.asList("cdfeb", "fcadb", "cdfeb", "cdbaf")).equals("5353"));
    }

}
