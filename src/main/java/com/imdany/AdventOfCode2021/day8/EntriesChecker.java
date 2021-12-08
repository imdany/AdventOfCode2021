package com.imdany.AdventOfCode2021.day8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EntriesChecker {

    List<Entry> entryList;

    // For unit testing
    List<String> entriesResults;
    long result = 0;


    EntriesChecker(List<String> input){
        this.entryList = new ArrayList<>();
        this.entriesResults = new ArrayList<>();
        for(String e: input) {
            entryList.add(new Entry(e));
        }

    }

    // Challenge 2
    public void analizeEntries(){
        for (Entry e: entryList) {
            result += e.getOutput();
            this.entriesResults.add(Arrays.asList(e.outputValue).toString() + ": " + e.getOutput());
        }
    }

    //Challenge 1
    public int checkCounts(){
        int count = 0;
        for (Entry e: entryList) {
            count += e.getCount(2);
            count += e.getCount(3);
            count += e.getCount(4);
            count += e.getCount(7);
        }
        return count;
    }

}
