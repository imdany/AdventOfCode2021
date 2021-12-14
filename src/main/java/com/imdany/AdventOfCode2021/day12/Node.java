package com.imdany.AdventOfCode2021.day12;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Node {

    String name;
    Boolean isBig;
    List<String> neighbor;


    Node(String name) {
        this.name = name;
        this.neighbor = new ArrayList<>();
        if(this.name.equals(this.name.toLowerCase(Locale.ROOT))) {
            this.isBig = false;
        }else{
            this.isBig = true;
        }
    }

    public void addNeigbor(String name){
        if(!this.neighbor.contains(name)) {
            this.neighbor.add(name);
        }
    }


    @Override
    public String toString() {
        return "{" + name + "}";
    }
}
