package com.imdany.AdventOfCode2021.day17;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class ProbeShot {

    // Initial Conditions
    double x0 = 0;
    double y0 = 0;

    // Forces
    double g = -1;
    double d = -1;

    // Shooting area
    double minX;
    double maxX;
    double minY;
    double maxY;

    ProbeShot(double minX, double maxX, double minY, double maxY) {
        this.minX = minX;
        this.minY = minY;
        this.maxX = maxX;
        this.maxY = maxY;
    }

    public double[] checkInitialVelocity(double vx, double vy){
        double[] result = new double[]{0,0};
        boolean check = true;
        double t = 0;
        while(check) {
            double[] position = getPosition(vx, vy, t);
            if(position[0] > this.maxX || position[1] < this.minY) {
                check = false;
            } else {
                if(position[0] <= this.maxX && position[0] >= this.minX && this.minY <= position[1] && position[1] <= this.maxY ) {
                    check = false;
                    result[0] = 1;
                } else {
                    t ++;
                }
            }
            if(position[1] > result[1]) result[1] = position[1];
        }
        return result;
    }

    // Challenge 1
    public double findPosition() {
        List<Double> candidates = new ArrayList<>();
        for (int i = 0; i<1000; i++){
            for (int j = 0; j<1000;j++) {
                candidates.add(this.shoot(i,j));
            }
        }
        return Collections.max(candidates);
    }

    //Challenge2:  Trying a parallel for loop
    public int findCombinations() {
        List<Integer> l = new ArrayList<>();
        IntStream.range(0, 1000).parallel().forEach(x -> {
            IntStream.range(-1000, 1000).parallel().forEach(y -> {
                double[] sh = checkInitialVelocity(x, y);
                if(sh[0]==1) {
                    l.add(1);
                }
            });
        });
        return l.size();
    }

    public double shoot(double vx, double vy) {
        double[] check = this.checkInitialVelocity(vx, vy);
        if(check[0] == 1){
            return check[1];
        } else {
            return 0;
        }
    }

    // Calculate position for initial velocity on time t
    public double[] getPosition(double vx0, double vy0, double t){
        double x = this.x0;
        double y = this.y0;
        double vx = vx0;
        double vy = vy0;
        if(t == 0){
            return new double[]{x, y};
        } else {
            x += vx;
            y += vy;
            for (int i = 1; i<t; i++){
                if(vx == 0){
                    vx = 0;
                } else {
                    vx += this.d;
                }
                vy += this.g;
                x += vx;
                y += vy;
            }
            return new double[]{x, y};
        }
    }

}
