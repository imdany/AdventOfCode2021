package com.imdany.AdventOfCode2021.day12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NodeFactory {

    public static HashMap<String, Node> createNodes(List<String> inputList) {
        HashMap<String, Node>  nodes = new HashMap<>();

        for (String e : inputList) {
            String[] parts = e.split("-");
            String source = parts[0];
            String destination = parts[1];

            Node s1;
            Node s2;
            if(nodes.containsKey(source)) {
                s1 = nodes.get(source);
            } else {
                s1 = new Node(source);
            }
            if(nodes.containsKey(destination)) {
                s2 = nodes.get(destination);
            } else {
                 s2 = new Node(destination);
            }

            for (String e2: inputList) {
                    String[] split = e2.split("-");
                    if(split[0].equals(source) || split[1].equals(source)) {
                        String[] parts1 = e2.split("-");
                        String source1 = parts1[0];
                        String destination1 = parts1[1];
                        if (source.equals(source1)) {
                            s1.addNeigbor(destination1);
                        } else {
                            s1.addNeigbor(source1);
                        }
                    }
                    if(split[0].equals(destination) || split[1].equals(destination)) {
                        String[] parts1 = e2.split("-");
                        String source1 = parts1[0];
                        String destination1 = parts1[1];
                        if (destination.equals(destination1)) {
                            s2.addNeigbor(source1);
                        } else {
                            s2.addNeigbor(destination1);
                        }
                    }
                }
            nodes.put(source, s1);
            nodes.put(destination, s2);
        }
        return nodes;
    }
}