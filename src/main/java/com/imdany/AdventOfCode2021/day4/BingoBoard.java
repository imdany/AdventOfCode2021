package com.imdany.AdventOfCode2021.day4;

public class BingoBoard {

    private int[][] board;
    private int[][] checkedBoard;

    private int boardSize = BingoConstants.BINGO_BOARD_SIZE;

    private boolean isWinner = false;

    public BingoBoard(int[][] board){
        this.board = board;
    }

    public boolean getIsWinner(){
        return this.isWinner;
    }

    public void addPosition(int p) {
        for(int i = 0; i<this.boardSize; i++){
            for(int j = 0; j<this.boardSize; j++){
                if(this.board[i][j] == p) {
                    this.checkedBoard[i][j] = 1;
                }
            }
        }
        this.checkWin();
    }

    public void checkWin(){
        for(int i = 0; i<this.boardSize; i++) {
            int rowCount = 0;
            int columnCount = 0;
            for (int j = 0; j < this.boardSize; j++) {
                rowCount = checkedBoard[i][j] + rowCount;
                columnCount = checkedBoard[j][i] + columnCount;
            }
            if(rowCount == this.boardSize ||columnCount == this.boardSize) {
                this.isWinner = true;
            }
        }
    }

}
