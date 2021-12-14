package com.imdany.AdventOfCode2021.day14;

import com.imdany.utils.ResourceReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class PolymerTest {

    ResourceReader resourceReader1;
    List<String> list1;

    {
        try {
            resourceReader1 = new ResourceReader("/AdventOfCode2021/day14/ex1.txt");
            list1 = resourceReader1.resourceToListString();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    HashMap<String, Character> mapRule = new HashMap<>();

    @Test
    public void creates_polymer(){
        Polymer p = new Polymer("NNCB", mapRule);
        Assertions.assertArrayEquals(p.currentSequence, "NNCB".toCharArray());
    }

    @Test
    public void inserts_value(){
        Polymer p = new Polymer("NNCB", mapRule);
        p.insertValue(1, 'C');
        Assertions.assertArrayEquals(p.currentSequence, "NCNCB".toCharArray());
    }

    @Test
    public void check_rules(){
        Polymer p = new Polymer("NNCB", mapRule);
        mapRule.put("NN", 'C');
        mapRule.put("NC", 'B');
        mapRule.put("CB", 'H');

        p.checkRules();
        Assertions.assertArrayEquals(p.currentSequence, "NCNBCHB".toCharArray());
    }

    @Test
    public void creates_rulesMap(){
        HashMap<String, Character> mapRules = Polymer.rulesCreator(list1);

        assert(mapRules.size() == 16);
    }

    @Test
    public void checkRules_1() {
        HashMap<String, Character> mapRules = Polymer.rulesCreator(list1);
        Polymer p = new Polymer("NNCB", mapRules);

        p.checkRules();
        Assertions.assertArrayEquals(p.currentSequence, "NCNBCHB".toCharArray());

        p.checkRules();
        Assertions.assertArrayEquals(p.currentSequence, "NBCCNBBBCBHCB".toCharArray());

        p.checkRules();
        Assertions.assertArrayEquals(p.currentSequence, "NBBBCNCCNBBNBNBBCHBHHBCHB".toCharArray());

        p.checkRules();
        Assertions.assertArrayEquals(p.currentSequence, "NBBNBNBBCCNBCNCCNBBNBBNBBBNBBNBBCBHCBHHNHCBBCBHCB".toCharArray());

    }

    @Test
    public void checkRules_2() {
        HashMap<String, Character> mapRules = Polymer.rulesCreator(list1);
        Polymer p = new Polymer("NNCB", mapRules);

        p.challenge1(4);
        Assertions.assertArrayEquals(p.currentSequence, "NBBNBNBBCCNBCNCCNBBNBBNBBBNBBNBBCBHCBHHNHCBBCBHCB".toCharArray());

    }
}
