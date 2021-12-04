package com.imdany.AdventOfCode2021.day4;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class BingoPlayer {

    List<BingoBoard> bingoBoardList;
    List<Integer> positions;

    BingoPlayer(List<String> lines, List<Integer> positions) {
        this.bingoBoardList = BingoBoardFactory.processList(lines);
        this.positions = positions;

    }

    public void playStrategy1(){
        boolean haveWinner = false;
        for(int play: positions){
            for(BingoBoard bb: bingoBoardList) {
                bb.addPosition(play);
                if(bb.getIsWinner()) {
                    log.info("Winner!!");
                    haveWinner = true;
                }
                if (haveWinner) break;
            }
            if (haveWinner) break;
        }
    }

    public void playStrategy2(){
        for(int play: positions){
            for(BingoBoard bb: bingoBoardList) {
                bb.addPosition(play);
            }
        }
    }

}
