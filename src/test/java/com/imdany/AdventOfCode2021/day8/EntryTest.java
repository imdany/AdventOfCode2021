package com.imdany.AdventOfCode2021.day8;

import com.imdany.utils.ResourceReader;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

public class EntryTest {

    ResourceReader resourceReader1;
    String listInputs;

    {
        try {
            resourceReader1 = new ResourceReader("/AdventOfCode2021/day8/ex1.txt");
            listInputs = resourceReader1.resourceToListString().get(0);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void countsTest() {
        Entry e = new Entry(listInputs);
        assert(e.getCount(5) == 4);
        assert(e.getCount(7) == 0);
    }

    @Test
    public void checkOutputPatternTest() {
        Entry e = new Entry(listInputs);
        assert(e.outputPattern.equals("5353"));

    }
}
