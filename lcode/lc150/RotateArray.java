package lc150;


//Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
//
//
//
//        Example 1:
//
//Input: nums = [1,2,3,4,5,6,7], k = 3
//Output: [5,6,7,1,2,3,4]
//Explanation:
//rotate 1 steps to the right: [7,1,2,3,4,5,6]
//rotate 2 steps to the right: [6,7,1,2,3,4,5]
//rotate 3 steps to the right: [5,6,7,1,2,3,4]


import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int[] dest = new int[nums.length];
        int k = 3;

        int[] part1 = Arrays.copyOfRange(nums, -k, nums.length-1);



//        for(int i=0; i < k; i++) {
//            int last = nums.length - 1;
//            int tmp = nums[last];
//
//            for(int j= last; j > 0; j--) {
//                nums[j] = nums[j - 1];
//            }
//
//            nums[0] = tmp;
//        }

        for(int i = 0; i <= part1.length - 1; i++) {
            System.out.println(part1[i]);

        }
    }
}
