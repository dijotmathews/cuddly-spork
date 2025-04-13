package lc150;


public class GameOfLife {
    private static int[][] today= {{0,0,1,0}, {0,1,1,1}, {0,0,0,0}, {0,0,0,0}};
    private static int[][] tomorrow = new int[4][4];

    public static void main(String[] args){
        for(int i =0; i < 4; i++) {
            for(int j=0; j < 4; j++) {
                System.out.print(today[i][j]+ " ");
            }
        }
    }

}
