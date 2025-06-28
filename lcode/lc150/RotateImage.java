package lc150;
//https://www.youtube.com/watch?v=fMSJSS7eO1w
public class RotateImage {

    public static void rotate(int[][] matrix) {
        int left = 0;
        int right = matrix.length;

        while (left < right) {
            int top = left;
            int bottom = right;
            for (int i = 0; i < right - left; i++ ) {
                int leftTop = matrix[top][left + i];

                matrix[top][left + i] = matrix[bottom - i -1][left];
                matrix[bottom -i - 1][left] = matrix[bottom -1][right - i - 1];
                matrix[bottom -1][right - i - 1] = matrix[top + i][right -1];
                matrix[top + i][right -1] = leftTop;

            }
            left += 1;
            right -= 1;
        }
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix.length; j++) {

                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int[][] m  ={ {1,2,3}, { 4,5,6}, {7,8,9} };

       rotate(m);

    }
}
