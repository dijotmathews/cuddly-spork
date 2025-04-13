package lc150;

public class MinSubArray {

    public static int minSubArrayLen(int target, int[] nums) {
        int l = 0;
        int result = nums.length + 1;
        int sum = 0;

        for(int r = 0; r < nums.length ; r++){
            sum += nums[r];
            while(sum >= target) {
                result = Integer.min(result, r - l + 1 );
                sum -= nums[l];
                l += 1;
            }
        }

        result = result == nums.length + 1 ? 0 : result;

        return result;
    }
    public static void main(String[] args) {

        int[] nums = {1,2,3,4,5};
        int target = 15;
        System.out.println(minSubArrayLen(target, nums));
    }
}
