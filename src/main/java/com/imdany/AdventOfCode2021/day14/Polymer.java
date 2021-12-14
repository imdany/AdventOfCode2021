package com.imdany.AdventOfCode2021.day14;

import com.imdany.AdventOfCode2021.day12.Node;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Polymer {

    char[] initialSequence;
    char[] currentSequence;

    HashMap<String, Character> mapRule;
    HashMap<String, String[]> mapInsertions;

    long[] freq;

    Polymer(String initialSequence, HashMap<String, Character> mapRule) {
        this.initialSequence = initialSequence.toCharArray();
        this.currentSequence = this.initialSequence;

        this.mapRule  = mapRule;
        this.mapInsertions = this.getInsertionMap();
        this.freq = new long[26];

    }

    public HashMap<String, String[]> getInsertionMap(){
        HashMap<String, String[]> mapInsertions = new HashMap<>();

        for (Map.Entry<String, Character> entry : this.mapRule.entrySet()) {
            String key = entry.getKey();
            String value = String.valueOf(entry.getValue());

            mapInsertions.put(key, new String[]{key.charAt(0) + value, value + key.charAt(1)});

        }
        return mapInsertions;
    }

    public void challenge2(int x) {
        HashMap<String, Long> pairs = IntStream
                .range(0, String.valueOf(this.currentSequence).length() - 1)
                .mapToObj(i -> String.valueOf(this.currentSequence).substring(i, i + 2))
                .collect(Collectors.groupingBy(Function.identity(), () -> new HashMap<>(), Collectors.counting()));

        HashMap<String, Long> pairsNext = new HashMap<String, Long>();

        for (char c : this.currentSequence) {
            this.freq[c - 'A']++;
        }

        for (int step = 0; step < x; step++) {
            pairsNext.clear();

            HashMap<String, Long> finalPairsNext = pairsNext;
            pairs.forEach((pair, count) -> {

                String[] toInsert = this.mapInsertions.get(pair);

                String left = toInsert[0];
                String right = toInsert[1];

                    finalPairsNext.compute(left, (__, v) -> v == null ? count : v + count);
                finalPairsNext.compute(right, (__, v) -> v == null ? count : v + count);

                this.freq[right.charAt(0) - 'A'] += count;
            });

            HashMap<String, Long> tmp = pairs;
            pairs = pairsNext;
            pairsNext = tmp;
        }


    }

    public void challenge1(int x){
        // Non optimized attempt
        for (int i = 0; i<x; i++) {
            this.checkRules();
        }
    }

    public long challenge2Calculation() {
        long max = Long.MIN_VALUE;
        long min = Long.MAX_VALUE;

        for(long v: this.freq){
            if(v < min && v != 0) min = v;
            if(v >= max) max = v;
        }
        return (max - min);
    }

    // Non optimized attempt. Fine for part 1 but doesn't work for part 2
    public long challenge1Calculation() {
        long max = 0;
        long min = 999999;
        HashMap<Character, Long> counted = new HashMap<>();
        for (char c : this.currentSequence) {
            long count = counted.containsKey(c) ? counted.get(c) : 0;
            counted.put(c, count + 1);

        }

        for(long v: counted.values()){
            if(v < min) min = v;
            if(v >= max) max = v;
        }

        return (max - min);
    }

    // Non optimized attempt. Fine for part 1 but doesn't work for part 2
    public void insertValue(int position, char value ){
        char[] newSequence = new char[this.currentSequence.length + 1];
        boolean isInserted = false;

        for (int i = 0; i< this.currentSequence.length; i++) {
            if(i == position){
                newSequence[i] = value;
                isInserted = true;
            }
            if(isInserted) {
                newSequence[i+1] = this.currentSequence[i];
            } else {
                newSequence[i] = this.currentSequence[i];
            }
        }
        this.currentSequence = newSequence;
    }

    // Non optimized attempt. Fine for part 1 but doesn't work for part 2
    public void checkRules(){
        // Create new secuence to modificate the current one
        char [] cS = new char[this.currentSequence.length];
        for (int i = 0; i<this.currentSequence.length; i++) {
            cS[i] = this.currentSequence[i];
        }

        // Iterate pair to pair on current sequence
        int j = -1;
        for (int i = 0; i<cS.length - 1; i++){
            j++;
            String pair = String.valueOf(new char[]{cS[i], cS[i+1]});
            // Try to get Pair from map list
            Character insertion = mapRule.getOrDefault(pair, null);

            if (insertion == null) {
                // There is no rule for this. Go to the next pair
            } else {
                j ++;
                this.insertValue(j, insertion);
            }
        }
    }

    public static HashMap<String, Character> rulesCreator(List<String> inputList) {
        HashMap<String, Character> mapRule = new HashMap<>();
        for (String l: inputList) {
            String[] split = l.split("->");
            String value = split[0].trim();
            Character c = split[1].trim().toCharArray()[0];
            mapRule.put(value, c);
        }
        return mapRule;
    }

    @Override
    public String toString() {
        return "Polymer{" +
                Arrays.toString(currentSequence) +
                '}';
    }
}
