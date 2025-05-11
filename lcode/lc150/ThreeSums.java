package lc150;

import java.util.Arrays;

public class ThreeSums {

    public static void main(String[] args) {
        int[] nums = new int[] {-1,0,1,3,-1,-4};
        Arrays.sort(nums);
        int[] result= twoSum(nums, 4);
        for(int r : result){
            System.out.print(r + " ");
        }
    }
    

    public static void threeSum(int[] nums) {
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));

        int[] result = twoSum(Arrays.copyOfRange(nums, 1, nums.length - 1), nums[0]);

        for(int r : result){
            System.out.print(r + " ");
        }


    }

    public static int[] twoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while(left < right) {
            int sum = nums[left] + nums[right];

            if(sum == target) 
                return new int[] { nums[left], nums[right]};
            else if(sum > target) {
                right--;
            } else if (sum < target) {
                left++;
            }
        }
        return new int[] {};
    }

}
