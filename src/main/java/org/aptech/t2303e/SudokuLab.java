package org.aptech.t2303e;

public class SudokuLab {
    private static final  int BOARD_SIZE = 9;
    private static final int SUBAREA_SIZE = 3; // SIZE CUA O VUONG CO RANG BUOC
    private static final int BOARD_START_INDEX = 0;
    // value of cell
    private static final int NO_VALUE = 0;
    private static final int MIN_VALUE  = 1;
    private static final int MAX_VALUE  = 9;
    // have some  value
//    private static int[][] board = {
//            {0,0,0,0,0,0,0,0,0},
//            {0,0,0,0,0,0,0,0,0},
//            {0,0,0,0,0,0,0,0,0},
//            {0,0,0,0,0,0,0,0,0},
//            {0,0,0,0,0,0,0,0,0},
//            {0,0,0,0,0,0,0,0,0},
//            {0,0,0,0,0,0,0,0,0},
//            {0,0,0,0,0,0,0,0,0},
//            {0,0,0,0,0,0,0,0,0}
//    };
//    private void printBoard(){
//        for(int row = 0; row < BOARD_SIZE ; row++){
//            for (int column  = 0 ; column < BOARD_SIZE ; column++){
//                System.out.print(board[row][column]+" ");
//            }
//            System.out.println();
//        }
//    }
    // process board  -> result
    private boolean processBoard(int[][] board){
        for(int row = 0; row < BOARD_SIZE ; row++){
            for (int column  = 0 ; column < BOARD_SIZE ; column++){
                if(board[row][column] == NO_VALUE){
                    for(int  k  = MIN_VALUE ; k <= MAX_VALUE ; k++ ){
                        board[row][column] = k;
                        if(isValid(board, row, column) && processBoard(board)){
                            return true;
                        }
                        board[row][column] = NO_VALUE;
                    }
                    return false;
                }
            }
        }
        return true;
    }
    boolean isValid(int[][] board , int row , int column){
        // todo write detail
        return true;
    }
}
