package com.imdany.AdventOfCode2021.day14;

import com.imdany.AdventOfCode2021.Runner;
import com.imdany.AdventOfCode2021.day13.Grid;
import com.imdany.AdventOfCode2021.day13.GridFactory;
import com.imdany.utils.ResourceReader;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@Slf4j
public class Day14Challenge extends Runner {

    public static void main(String[] args) throws IOException {
        Day14Challenge challenge = new Day14Challenge();
        challenge.run(challenge.getClass().getName());
    }

    @Override
    public void Challenge1() throws IOException {
        log.info("Challenge 1");
        ResourceReader resourceReader1 = new ResourceReader("/AdventOfCode2021/day14/input1.txt");
        List<String> list1 = resourceReader1.resourceToListString();;

        HashMap<String, Character> mapRules = Polymer.rulesCreator(list1);
        Polymer p = new Polymer("KFFNFNNBCNOBCNPFVKCP", mapRules);

        p.challenge1(10);

        log.info("Result: {}", p.challenge1Calculation());
    }

    @Override
    public void Challenge2() throws IOException {
        log.info("Challenge 2");
        ResourceReader resourceReader1 = new ResourceReader("/AdventOfCode2021/day14/input1.txt");
        List<String> list1 = resourceReader1.resourceToListString();

        HashMap<String, Character> mapRules = Polymer.rulesCreator(list1);
        Polymer p = new Polymer("KFFNFNNBCNOBCNPFVKCP", mapRules);

        p.challenge2(40);
        log.info("Result: {}", p.challenge2Calculation());
    }
}
