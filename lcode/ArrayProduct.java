package misc;

import java.util.Arrays;

public class ArrayProduct {
    public static int[] productExceptSelf(int[] nums) {
        int s = nums.length;
        int prefixProduct = 1;
        int postfixProduct = 1;

        int[] answer = new int[nums.length];
        answer[0] = 1;

        for(int i = 1; i <= s -1; i++) {
            answer[i] = prefixProduct;
            prefixProduct = prefixProduct * nums[i];
        }
        for(int i = s -2; i >= 0; i--) {

            answer[i] = answer[i] * postfixProduct;
            postfixProduct = postfixProduct * nums[i];

        }

        return answer;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
//        int[] nums = {-1,1,0,-3,3};

        int[] answer = productExceptSelf(nums);
        System.out.println(Arrays.toString(answer));
    }
}
