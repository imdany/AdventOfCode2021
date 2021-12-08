package com.imdany.AdventOfCode2021.day8;

import com.imdany.AdventOfCode2021.day7.Aligner;
import com.imdany.AdventOfCode2021.day7.AlignmentChecker;
import com.imdany.AdventOfCode2021.day7.AlignmentChecker1;
import com.imdany.AdventOfCode2021.day7.AlignmentChecker2;
import com.imdany.utils.ResourceReader;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class Challenge8Test {

    ResourceReader resourceReader1;
    List<String> listInputs;

    {
        try {
            resourceReader1 = new ResourceReader("/AdventOfCode2021/day8/ex2.txt");
            listInputs = resourceReader1.resourceToListString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void challenge1Test() {
        EntriesChecker ec = new EntriesChecker(listInputs);
        assert(ec.checkCounts() == 26);

    }

    @Test
    public void challenge2Test() {
        EntriesChecker ec = new EntriesChecker(listInputs);
        ec.analizeEntries();

        assert(ec.entriesResults.get(0).equals("[[fdgacbe, cefdb, cefbgd, gcbe]]: 8394"));
        assert(ec.entriesResults.get(1).equals("[[fcgedb, cgb, dgebacf, gc]]: 9781"));
        assert(ec.entriesResults.get(2).equals("[[cg, cg, fdcagb, cbg]]: 1197"));
        assert(ec.entriesResults.get(3).equals("[[efabcd, cedba, gadfec, cb]]: 9361"));
        assert(ec.entriesResults.get(4).equals("[[gecf, egdcabf, bgf, bfgea]]: 4873"));
        assert(ec.entriesResults.get(5).equals("[[gebdcfa, ecba, ca, fadegcb]]: 8418"));
        assert(ec.entriesResults.get(6).equals("[[cefg, dcbef, fcge, gbcadfe]]: 4548"));
        assert(ec.entriesResults.get(7).equals("[[ed, bcgafe, cdgba, cbgef]]: 1625"));
        assert(ec.entriesResults.get(8).equals("[[gbdfcae, bgc, cg, cgb]]: 8717"));
        assert(ec.entriesResults.get(9).equals("[[fgae, cfgab, fg, bagce]]: 4315"));

        assert(ec.result == 61229);
    }


}
