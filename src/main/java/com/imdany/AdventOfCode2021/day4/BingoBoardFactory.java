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
        for (int i = 0; i<all.size(); i++) {
            if(!all.get(i).equals("")) {
                preboard.add(all.get(i));
                currentCount++;
                if (currentCount == 5) {
                    boards.add(createBoard(preboard));
                    preboard = new ArrayList<>();
                    currentCount = 0;
                }
            }
        }

        return boards;
    }

    public static BingoBoard createBoard(List<String> lines) {
        int[][] preBoard = new int[BingoConstants.BINGO_BOARD_SIZE][BingoConstants.BINGO_BOARD_SIZE];

        for (int y = 0; y<BingoConstants.BINGO_BOARD_SIZE; y++) {
            String[] lValues = lines.get(y).split(" ");
            int xReal = 0;
            for (int x = 0; x< lValues.length;  x++) {
                if(lValues[x] != "") {
                    preBoard[xReal][y] = Integer.valueOf(lValues[x]);
                    xReal++;
                }
            }
        }

        return new BingoBoard(preBoard);
    }

}
