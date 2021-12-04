package com.imdany.AdventOfCode2021.day4;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BingoBoard {

    private int[][] board;
    private int[][] checkedBoard;

    private int boardSize = BingoConstants.BINGO_BOARD_SIZE;

    private boolean isWinner = false;
    private boolean isPlayable = true;

    public BingoBoard(int[][] board){
        this.board = board;
        this.checkedBoard = new int[this.boardSize][this.boardSize];
    }

    public boolean getIsWinner(){
        return this.isWinner;
    }

    public void addPosition(int p) {
        if(isPlayable) {
            for(int i = 0; i<this.boardSize; i++){
                for(int j = 0; j<this.boardSize; j++){
                    if(this.board[i][j] == p) {
                        this.checkedBoard[i][j] = 1;
                    }
                }
            }
            this.checkWin(p);
        }
    }

    public void checkWin(int p){
        for(int i = 0; i<this.boardSize; i++) {
            int rowCount = 0;
            int columnCount = 0;
            for (int j = 0; j < this.boardSize; j++) {
                rowCount = checkedBoard[i][j] + rowCount;
                columnCount = checkedBoard[j][i] + columnCount;
            }
            if(rowCount == this.boardSize ||columnCount == this.boardSize) {
                this.isWinner = true;
                this.isPlayable = false;
                log.info("We have a winner!");
                this.calculateScore(p);
            }
        }
    }

    public void calculateScore(int p){
        // Get unmarked numbers
        int preScore = 0;
        for(int i = 0; i<this.boardSize; i++) {
            for(int j = 0; j<this.boardSize; j++) {
                if(this.checkedBoard[i][j] == 0){
                    preScore = this.board[i][j] + preScore;
                }
            }
        }
        int finalScore = preScore * p;
        log.info("Play: "+ p);
        log.info("Unmarked: "+ preScore);
        log.info("Score: "+ finalScore);
    }

}
