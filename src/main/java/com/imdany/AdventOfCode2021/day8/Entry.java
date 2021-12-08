package com.imdany.AdventOfCode2021.day8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Entry {

    String rawLine;

    List<String> signalPattern;
    List<String> outputValue;

    String outputPattern = "";

    PatternAnalyzer pc;

    int[] counts;

    Entry(String rawLine) {
        this.rawLine = rawLine;
        this.counts = new int[9];

        String[] cut = this.rawLine.split("\\|");
        String preSignal = cut[0].trim();
        String outputValue = cut[1].trim();

        this.signalPattern = Arrays.stream(preSignal.split(" ")).toList();
        this.outputValue = Arrays.stream(outputValue.split(" ")).toList();

        this.countValues();

        this.pc = new PatternAnalyzer(this.signalPattern);
        this.analyze();
    }

    private void analyze(){
        this.outputPattern = this.pc.translateList(this.outputValue);
    }

    public int getOutput(){
        return Integer.valueOf(this.outputPattern);
    }

    public int getCount(int i){
        return this.counts[i];
    }

    private void countValues(){
        for(String e: outputValue) {
            int l = e.length();
            counts[l]++;
        }
    }

    @Override
    public String toString() {
        return "Entry{" +
                "counts=" + Arrays.toString(counts) +
                '}';
    }
}
