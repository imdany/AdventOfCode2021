package com.imdany.AdventOfCode2021.day8;

import java.util.*;
import java.util.stream.Collectors;

public class PatternAnalyzer {

    List<String> signalList;
    List<Integer> signalLengths;

    String N1 = "";
    String N2 = "";
    String N3 = "";
    String N4 = "";
    String N5 = "";
    String N6 = "";
    String N7 = "";
    String N8 = "";
    String N9 = "";
    String N0 = "";

    String a = "";
    String b = "";
    String c = "";
    String d = "";
    String e = "";
    String f = "";
    String g = "";

    PatternAnalyzer(List<String> signalList) {
        this.signalList = signalList;

        this.signalLengths = new ArrayList<>();
        this.analyze();
    }

    public boolean checkContent(String e, String check) {
        if (e.length() == check.length()) {
            HashSet<String> c1 = new HashSet<String>(Arrays.asList(e.split("")));
            List<String> c2 = Arrays.asList(check.split(""));
            c1.removeAll(c2);
            if(c1.size() == 0) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }

    }

    public int translateElement(String e) {
        if(this.checkContent(e, this.N1)){
            return 1;
        }else if(this.checkContent(e, this.N2)){
            return 2;
        }else if(this.checkContent(e, this.N3)){
            return 3;
        }else if(this.checkContent(e, this.N4)){
            return 4;
        }else if(this.checkContent(e, this.N5)){
            return 5;
        }else if(this.checkContent(e, this.N6)){
            return 6;
        }else if(this.checkContent(e, this.N7)){
            return 7;
        }else if(this.checkContent(e, this.N8)){
            return 8;
        }else if(this.checkContent(e, this.N9)){
            return 9;
        }else if(this.checkContent(e, this.N0)){
            return 0;
        }else {
            return -9;
        }
    }

    public String translateList(List<String> pattern){
        String result = "";
        for (String e: pattern) {
            String pre  = String.valueOf(this.translateElement(e));
            result = result.concat(pre);
        }
        return result;
    }

    public void analyze(){
        this.getLength();

        // FOllowing this exact order
        this.extract1();
        this.extract4();
        this.extract7();
        this.extract8();

        this.extract6();

        this.extract5();

        this.extract2();
        this.extract3();

        this.extract9();
        this.extract0();
    }


    public void extract1(){
        int index = this.signalLengths.indexOf(2);
        this.N1 = this.signalList.get(index);
    }

    public void extract2(){
        for (int i = 0; i < this.signalList.size(); i ++ ) {
            if(this.signalLengths.get(i) == 5){
                String c = this.signalList.get(i);
                if(!c.equals(this.N5)) {
                    if(!c.contains(this.c) ){
                        this.N2 = c;
                    }
                }
            }
        }
    }

    public void extract3(){
        for (int i = 0; i < this.signalList.size(); i ++ ) {
            if(this.signalLengths.get(i) == 5){
                String c = this.signalList.get(i);
                if(!c.equals(this.N5)) {
                    if(c.contains(this.c) ){
                        this.N3 = c;
                    }
                }
            }
        }
    }

    public void extract4(){
        int index = this.signalLengths.indexOf(4);
        this.N4 = this.signalList.get(index);
    }

    public void extract5(){
        for (int i = 0; i < this.signalList.size(); i ++ ) {
            if(this.signalLengths.get(i) == 5){
                String c = this.signalList.get(i);
                if(!c.contains(this.b) ){
                    this.N5 = c;
                }
            }
        }
    }

    public void extract6(){
        String[] n1Values = this.N1.split("");

        for (int i = 0; i < this.signalList.size(); i ++ ) {
            if(this.signalLengths.get(i) == 6){
                String c = this.signalList.get(i);
                if(!c.contains(n1Values[0]) || !c.contains(n1Values[1])){
                    this.N6 = c;
                }
            }
        }

        // Getting B
        HashSet<String> biggerSet = new HashSet<String>(Arrays.asList(this.N8.split("")));
        HashSet<String> smallerSet = new HashSet<String>(Arrays.asList(this.N6.split("")));

        biggerSet.removeAll(smallerSet);
        this.b = biggerSet.stream().toList().get(0);

        // Getting C
        HashSet<String> biggerSet2 = new HashSet<String>(Arrays.asList(this.N7.split("")));
        HashSet<String> smallerSet2 = new HashSet<String>(Arrays.asList(this.a, this.b));

        biggerSet2.removeAll(smallerSet2);
        this.c = biggerSet2.stream().toList().get(0);

    }



    public void extract7(){
        int index = this.signalLengths.indexOf(3);
        this.N7 = this.signalList.get(index);

        HashSet<String> biggerSet = new HashSet<String>(Arrays.asList(this.N7.split("")));
        HashSet<String> smallerSet = new HashSet<String>(Arrays.asList(this.N1.split("")));

        // Getting A
        biggerSet.removeAll(smallerSet);
        this.a = biggerSet.stream().toList().get(0);
    }

    public void extract8(){
        int index = this.signalLengths.indexOf(7);
        this.N8 = this.signalList.get(index);
    }

    public void extract9(){
        for (int i = 0; i < this.signalList.size(); i ++ ) {
            if(this.signalLengths.get(i) == 6){
                String c = this.signalList.get(i);
                if(!c.equals(this.N6)){
                    List<String> a = Arrays.asList(this.N5.concat(this.b).split(""));
                    HashSet<String> biggerSet = new HashSet<String>(a);
                    biggerSet.removeAll(Arrays.asList(c.split("")));
                    if(biggerSet.size() == 0) {
                        this.N9 = c;
                    }
                }
            }
        }
    }

    public void extract0(){
        for (int i = 0; i < this.signalList.size(); i ++ ) {
            if(this.signalLengths.get(i) == 6){
                String c = this.signalList.get(i);
                if(!c.equals(this.N6) && !c.equals(this.N9)){
                        this.N0 = c;
                }
            }
        }
    }

    public void getLength(){
        for (String e: this.signalList) {
            this.signalLengths.add(e.length());
        }
    }

    @Override
    public String toString() {
        return "PatternAnalyzer{" +
                "N1='" + N1 + '\'' +
                ", N2='" + N2 + '\'' +
                ", N3='" + N3 + '\'' +
                ", N4='" + N4 + '\'' +
                ", N5='" + N5 + '\'' +
                ", N6='" + N6 + '\'' +
                ", N7='" + N7 + '\'' +
                ", N8='" + N8 + '\'' +
                ", N9='" + N9 + '\'' +
                ", N0='" + N0 + '\'' +
                '}';
    }
}
