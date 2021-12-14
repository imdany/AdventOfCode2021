package com.imdany.AdventOfCode2021.day14;

import com.imdany.AdventOfCode2021.day13.Grid;
import com.imdany.AdventOfCode2021.day13.GridFactory;
import com.imdany.utils.ResourceReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class Challenge14Test {

    ResourceReader resourceReader1;
    List<String> list1;

    {
        try {
            resourceReader1 = new ResourceReader("/AdventOfCode2021/day14/ex1.txt");
            list1 = resourceReader1.resourceToListString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void challenge1Test() {
        HashMap<String, Character> mapRules = Polymer.rulesCreator(list1);
        Polymer p = new Polymer("NNCB", mapRules);

        p.challenge1(10);
        assert(p.challenge1Calculation() == 1588);
    }

    @Test
    public void challenge2Test() {
        HashMap<String, Character> mapRules = Polymer.rulesCreator(list1);
        Polymer p = new Polymer("NNCB", mapRules);

        p.challenge2(10);
        assert(p.challenge2Calculation() == 1588);
    }
}
