package com.imdany.AdventOfCode2021.day9;

import com.imdany.AdventOfCode2021.day8.EntriesChecker;
import com.imdany.utils.ResourceReader;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class Challenge9Test {

    ResourceReader resourceReader1;
    List<String> listInputs;

    {
        try {
            resourceReader1 = new ResourceReader("/AdventOfCode2021/day9/ex1.txt");
            listInputs = resourceReader1.resourceToListString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void challenge1Test() {
        assert(true);
    }

    @Test
    public void challenge2Test() {
        assert(true);
    }


}
