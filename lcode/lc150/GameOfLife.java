package lc150;

import java.util.Arrays;

public class GameOfLife {
//    https://www.youtube.com/watch?v=fei4bJQdBUQ
    private static int[][] today = {
        { 0, 0, 1, 0 },
        { 0, 1, 1, 1 },
        { 0, 0, 0, 0 },
        { 0, 0, 0, 0 },
    };
    private static int[][] tomorrow = new int[4][4];

//   old  new  rep
//   0    0     0
//   0    1     1
//   1    0     2
//   1    1     3

    public static void gameOfLife(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        Integer[] life = {2,3};


        for(int r =0 ; r < rows; r++ ) {
            for(int c = 0 ; c < cols; c++) {

                int neiCount = getNeigbourCount(r, c) ;

                if(Arrays.asList(life).contains(neiCount)) {

                }
            }
        }

    }


    public static void main(String[] args) {
    }
}
