package lc150;

import java.util.HashSet;

public class HappyNumber {

    public static boolean isHappy(int n) {
        HashSet<Integer> visited = new HashSet<Integer>();

        while(!visited.contains(n)) {
            visited.add(n);
            n = sumOfSquares(n);

            if(n == 1) {
                return true;
            }
        }
        return false;
    }

    public static int sumOfSquares(int n) {
        double sum = 0;

        while(n > 0) {
           int rem = n % 10;
           sum += Math.pow(rem, 2);

           n = n /10;
        }

        return (int) sum;
    }


    public static void main(String[] args) {
        int n = 2;

        if(isHappy(n)) {
            System.out.println("the number is happy");
        }
    }
}
