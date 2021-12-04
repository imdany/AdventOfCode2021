package com.imdany.AdventOfCode2021.day4;

import java.util.ArrayList;
import java.util.List;

public class BingoBoardFactory {

    public static void BingoBoardFactory(){

    }

    public static List<BingoBoard> processList(List<String> all) {
        List<BingoBoard> boards = new ArrayList<>();

        int currentCount = 0;
        List<String> preboard = new ArrayList<>();
        for (int i = 0; i<5; i++) {
//            for (int i = 0; i<all.size(); i++) {
            preboard.add(all.get(i));
            currentCount ++;
        }
        boards.add(createBoard(preboard));
        return boards;
    }

    public static BingoBoard createBoard(List<String> lines) {
        int[][] pre_board = null;

        return new BingoBoard(pre_board);
    }

}
