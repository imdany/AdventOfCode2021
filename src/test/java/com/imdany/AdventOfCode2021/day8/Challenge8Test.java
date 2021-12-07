package com.imdany.AdventOfCode2021.day8;

import com.imdany.AdventOfCode2021.day7.Aligner;
import com.imdany.AdventOfCode2021.day7.AlignmentChecker;
import com.imdany.AdventOfCode2021.day7.AlignmentChecker1;
import com.imdany.AdventOfCode2021.day7.AlignmentChecker2;
import com.imdany.utils.ResourceReader;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Challenge8Test {

    ResourceReader resourceReader1;
    int[] listInputs;

    {
        try {
            resourceReader1 = new ResourceReader("/AdventOfCode2021/day7/ex1.txt");
            listInputs = resourceReader1.lineToIntegerList().stream().mapToInt(i->i).toArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void challenge1Test() {
        assert(0 == 0);
    }

    @Test
    public void challenge2Test() {
        assert(0 == 0);
    }


}
