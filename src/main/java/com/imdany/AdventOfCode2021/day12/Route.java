package com.imdany.AdventOfCode2021.day12;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Route {

    Node currentPosition;
    List<Node> visitedPositions;
    boolean isEnded;
    boolean isValid;
    boolean visitedSmallTwice;
    HashMap<String, Node> hashMap;

    Route(Node currentPosition, List<Node> visitedPositions, HashMap<String, Node> hashMap) {
        this.currentPosition = currentPosition;
        this.visitedPositions = visitedPositions;
        this.hashMap = hashMap;
        this.isValid = true;
        this.visitedSmallTwice = false;
    }


    public List<Route> generateRoute(Route route){
        // Output list
        List<Route> routeList = new ArrayList<>();

        // Get non visited neighbors
        List<String> neighbor =  route.currentPosition.neighbor;

        List<String> result = new ArrayList<>();
        for (String i: neighbor ){
            if(i.equals("start")){
            }else {
                result.add(i);
            }
        }

        // Create routes with the result as current node, and this this route.currentPosition as visited position
        for (String s: result) {
            Node n = this.hashMap.get(s);
            List<Node> visited = new LinkedList<Node>(route.visitedPositions);
            visited.add(route.currentPosition);

            Route n1 = new Route(n, visited, this.hashMap);

            if(n1.currentPosition.name.equals("end")) {
                n1.isEnded = true;
            }
            routeList.add(n1);
        }
        return routeList;
    }

    public boolean isNodeVisited(Node n){
        if(this.visitedPositions.contains(n)) {
            return true;
        } else {
         return false;
        }
    }

    public long countNodes(Node n) {
        return this.visitedPositions.stream().filter(x -> x == n).count();
    }

    public boolean checkCountSmallNodes(int n) {
        Map<Node, Long> counted = this.visitedPositions.stream().filter(x -> !x.isBig && x != this.hashMap.get("start"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        counted.values().removeIf(l -> l < n);
        return counted.keySet().size() >= 1 ? true : false;

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
