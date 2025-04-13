package lc150;

import java.util.Arrays;
//https://www.youtube.com/watch?v=lJwbPZGo05A
public class GasStation {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        if( sum(gas) < sum(cost)) {
            return -1;
        }


        int total = 0;
        int start = 0;
        for(int i = 0; i< gas.length; i++) {
            total =  total + gas[i] - cost[i];

            if (total < 0) {
                total = 0;
                start = i+1;
            }
        }
        return start;
    }

    public static void main(String[] args) {
//        int[] gas = {1,2,3,4,5};
//        int[] cost = {3,4,5,1,2};

        int[] gas = {3,1,1};
        int[] cost = {1,2,2};
        System.out.println(canCompleteCircuit(gas, cost));
    }

    public static int sum(int[] a) {
        return Arrays.stream(a).sum();
    }
}
