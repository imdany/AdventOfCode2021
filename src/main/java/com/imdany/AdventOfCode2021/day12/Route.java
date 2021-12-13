package com.imdany.AdventOfCode2021.day12;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Route {

    Node currentPosition;
    List<String> visitedPositions;
    boolean isEnded;
    boolean isValid;
    boolean visitedSmallTwice;
    HashMap<String, Node> hashMap;

    Route(Node currentPosition, List<String> visitedPositions, HashMap<String, Node> hashMap) {
        this.currentPosition = currentPosition;
        this.visitedPositions = visitedPositions;
        this.hashMap = hashMap;
        this.isValid = true;
        this.visitedSmallTwice = false;
    }


    public List<Route> generateRoute(Route route, int type){
        // Output list
        List<Route> routeList = new ArrayList<>();

        // Get non visited neighbors
        List<String> neighbor =  route.currentPosition.neighbor;

        List<String> result = new ArrayList<>();
        for (String i: neighbor ){
            if(i.equals("start")){
            }else {
                if (route.visitedPositions.contains(i)) {
                    if (hashMap.get(i).isBig) {
                        result.add(i);
                    } else {
                        List<String> smallCaves = route.visitedPositions.stream().filter(x -> x.equals(i)).toList();
                        if(type == 1 && !this.visitedSmallTwice) {
                            if(smallCaves.size() == 1) {
                                result.add(i);
//                                this.visitedSmallTwice = true;
                            }
                        }

                    }
                } else {
                    result.add(i);
                }
            }
        }


        // Create routes with the result as current node, and this this route.currentPosition as visited position
        for (String s: result) {
            Node n = this.hashMap.get(s);
            List<String> visited = new LinkedList<String>(route.visitedPositions);
            visited.add(route.currentPosition.name);

            Map<String, Long> counted = visited.stream().filter(x -> !this.hashMap.get(x).isBig)
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

            Route n1 = new Route(n, visited, this.hashMap);
            for (Long v : counted.values()) {
                if(v >= 2) {
                    n1.visitedSmallTwice = true;
                }
            }

            if(n1.currentPosition.name.equals("end")) {
                n1.isEnded = true;
            }

            routeList.add(n1);
        }
        // if next position is "end"... set route to isEnded

        return routeList;
    }

    @Override
    public String toString() {
        return "Route{" + Arrays.asList(visitedPositions) +", " +this.currentPosition.name + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Route route = (Route) o;
        return isEnded == route.isEnded && currentPosition.equals(route.currentPosition) && visitedPositions.equals(route.visitedPositions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currentPosition, visitedPositions, isEnded);
    }
}
