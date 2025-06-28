package lc150;


import java.util.ArrayList;
import java.util.List;

//https://www.youtube.com/watch?v=BJnMZNwUk1M
public class SpiralMatrix {


    public static List<Integer> spiralOrder(int[][] matrix) {
        int top = 0;
        int bottom = matrix.length;

        int left = 0;
        int right = matrix[0].length;
        List<Integer> res = new ArrayList<>();

        while( left < right && top < bottom) {
            for(int i = left; i < right; i++) {
                res.add(matrix[top][i]);
            }
            top += 1;

            for(int i = top; i < bottom; i++) {
                res.add(matrix[i][right - 1]);
            }
            right -= 1;

            if (!(left < right) || !(top < bottom)) {
                break;
            }

            for(int i = right -1; i >= left; i--) {
                res.add(matrix[bottom -1][i]);
            }
            bottom -= 1;

            for(int i = bottom - 1; i >= top; i--) {
                res.add(matrix[i][left]);
            }
            left += 1;
        }

        return res;
    }

    public static void main(String [] args) {
        System.out.println("hello");
        int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};

        List<Integer> res = spiralOrder(matrix);
        System.out.println(res.toString());

    }
}
