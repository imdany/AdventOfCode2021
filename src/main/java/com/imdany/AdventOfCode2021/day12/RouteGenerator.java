package com.imdany.AdventOfCode2021.day12;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RouteGenerator {

    HashMap<String, Node> nodeMap;
    List<Route> endedRoutes;
    List<Route> invalidRoutes;

    int totalEndedRoutes;

    RouteGenerator(HashMap<String, Node> nodeMap, int type) {
        this.nodeMap = nodeMap;
        this.invalidRoutes  = new ArrayList<>();
        this.endedRoutes = new ArrayList<>();
        this.totalEndedRoutes = 0;

        this.generateRoutes(type);
    }

    public int getTotalEndedRoutes(){
        return this.totalEndedRoutes;
    }

    // Challenge 1
    public void generateRoutes(int type){
        Node n1 = nodeMap.get("start");

        // Initial Route
        Route r = new Route(n1, List.of(), nodeMap);
        List<Route> visitedRoutes = r.generateRoute(r);

        int size = visitedRoutes.size();
        int i = 0;
        while(size != 0){
            if(i >= size){
                i = 0;
            }
            // Check Route
            Route r1 = visitedRoutes.get(i);
            if (r1.isEnded) {
                endedRoutes.add(r1);
                visitedRoutes.remove(i);
            } else {
                List<Route> newRoutes = r1.generateRoute(r1);
                if(newRoutes.size() == 0) {
                    invalidRoutes.add(r1);
                }else {
                    visitedRoutes.addAll(newRoutes);
                }
                visitedRoutes.remove(i);
            }

            visitedRoutes = this.validateRoutes(visitedRoutes, type);

            i++;
            size = visitedRoutes.size();
        }

        this.totalEndedRoutes = endedRoutes.size();
    }

    public List<Route> validateRoutes(List<Route> visitedRoutes, int type){
        List<Route> validatedList = new ArrayList<>();

        if(type == 0){
            // Challenge 1 condition // Small Caves only once
            for(Route r: visitedRoutes) {

                if(!r.isNodeVisited(r.currentPosition)){
                    // First time we are seeing it... add it
                    validatedList.add(r);
                } else{
                    // If it's there, count how many times
                    if(!r.currentPosition.isBig) {
                        boolean c = r.checkCountSmallNodes(1);
                        if(c == false){
                            validatedList.add(r);
                        }
                    } else {
                        validatedList.add(r);
                    }
                }
            }
        } else {
            // Challenge 2 condition
            for(Route r: visitedRoutes) {

                if(!r.isNodeVisited(r.currentPosition)){
                    // First time we are seeing it... add it
                    validatedList.add(r);
                } else{
                    // If it's there, count how many times
                    if(!r.currentPosition.isBig) {
                        boolean c = r.checkCountSmallNodes(2);
                        if(c == false){
                            validatedList.add(r);
                        }
                    } else {
                        validatedList.add(r);
                    }
                }
            }
        }
        return validatedList;
    }

}
