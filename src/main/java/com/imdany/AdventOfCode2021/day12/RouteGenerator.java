package com.imdany.AdventOfCode2021.day12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
        List<Route> visitedRoutes = r.generateRoute(r, type);

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
                List<Route> newRoutes = r1.generateRoute(r1, type);
                if(newRoutes.size() == 0) {
                    invalidRoutes.add(r1);
                }else {
                    visitedRoutes.addAll(newRoutes);
                }
                visitedRoutes.remove(i);
            }

            i++;
            size = visitedRoutes.size();
        }

        this.totalEndedRoutes = endedRoutes.size();
    }

}
