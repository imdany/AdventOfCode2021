package com.imdany.AdventOfCode2021.day17;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ProbeShotTest {

    @Test
    public void test1(){
        ProbeShot pb = new ProbeShot(20, 30, -10, -5);
        assert(pb.checkInitialVelocity(7, 2)[0] == 1);
    }

    @Test
    public void checkGetPosition(){
        ProbeShot pb = new ProbeShot(20, 30, -10, -5);

        System.out.println(Arrays.toString(pb.getPosition(7,2, 0)));
        System.out.println(Arrays.toString(pb.getPosition(7,2, 1)));
        System.out.println(Arrays.toString(pb.getPosition(7,2, 2)));
        System.out.println(Arrays.toString(pb.getPosition(7,2, 3)));
        System.out.println(Arrays.toString(pb.getPosition(7,2, 4)));
        System.out.println(Arrays.toString(pb.getPosition(7,2, 5)));
        System.out.println(Arrays.toString(pb.getPosition(7,2, 6)));
        System.out.println(Arrays.toString(pb.getPosition(7,2, 7)));
        }

    @Test
    public void checkInitialVelocityTest(){
        ProbeShot pb = new ProbeShot(20, 30, -10, -5);

        assert(pb.checkInitialVelocity(7,2)[0] == 1);
        assert(pb.checkInitialVelocity(9,0)[0] == 1);
        assert(pb.checkInitialVelocity(17,-4)[0] == 0);

    }

    @Test
    public void getMaximumHeight(){
        ProbeShot pb = new ProbeShot(20, 30, -10, -5);

        assert(pb.shoot(6,9) == 45);

        assert(pb.checkInitialVelocity(17,-4)[0] == 0);

    }

}
