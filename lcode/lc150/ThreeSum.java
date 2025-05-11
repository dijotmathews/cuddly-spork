package lc150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static Integer[] twoSum(int[] nums, int target, int left, int right) {
        int l = left;
        int r = right;

        while (l < r) {
            int currentSum = nums[r] + nums[l];
            if(currentSum > target) {
                r--;
            } else if(currentSum < target){
                l++;
            } else {
                return new Integer[] {nums[l], nums[r]};
            }

        }
        return new Integer[]{};
    }


    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for(int i  =0; i < nums.length; i++) {
            int target = nums[i] * -1;
            Integer[] res = twoSum(nums, target, i, nums.length-1 );
            if(res.length != 0){
                Integer[] out = new Integer[] { nums[i], res[0], res[1]};
                result.add(Arrays.asList(out));
            }
        }
        return result;


    }



    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};

        List<List<Integer>> result = threeSum(nums);
        System.out.println(result.toString());
    }
}
