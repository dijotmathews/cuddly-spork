import java.util.Arrays;

public class TwoSumm11 {
    public static int[] twoSum(int[] numbers, int target) {

        int l = 0;
        int r = numbers.length-1;

        while(l<r) {
            int currentSum = numbers[l] + numbers[r];

            if(currentSum > target)
                r = r -1;
            else if(currentSum < target)
                l = l + 1;
            else
                return new  int[] {l+1, r+1};
        }
        return new int[]{};
    }

    public static void main(String[] args){
        int[] numbers = {2,3,4};

        int target = 6;

        int[] result = twoSum(numbers, target);
        for (int r: result) {
            System.out.println(r);
        }
    }
}
