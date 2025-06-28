package lc150;

public class MatrixZeros {


    public static void setZeroes(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;


        boolean leftTop = false;

        for(int i = 0; i < m ; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] != 0) {
                    continue;
                }
                matrix[0][j] = 0;

                if(i == 0) {
                    leftTop = true;
                } else {

                    matrix[i][0] = 0;
                }
            }
        }


        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(matrix[0][j] == 0 || matrix[i][0] ==0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if(matrix[0][0] == 0) {
            for(int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }

        if(leftTop) {
            for(int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }

    }
    public static void main(String[] args) {
        int[][] matrix = {{1,0,3}};

       setZeroes(matrix);

       for(int i = 0; i < matrix.length; i++) {
           for(int j = 0; j < matrix[0].length; j++) {
              System.out.println(matrix[i][j] + " ");
           }
           System.out.println();
       }
    }
}
