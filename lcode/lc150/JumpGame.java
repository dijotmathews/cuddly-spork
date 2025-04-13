package lc150;

public class JumpGame {


    public static boolean canJump(int[] nums) {
        int goal = nums.length -1;

        for(int i = nums.length - 1; i >=0; i--) {
            int biggestJumpPossible = i + nums[i];
            if (biggestJumpPossible >= goal){
                goal = i;
            }

        }

        if(goal == 0) {
            return true;
        } else {
            return false;
        }

    }

    public static void main(String[] args){
//        int[] nums = {2,3,1,1,4};
        int[] nums = {1,2}; //true
//        int[] nums = {0,1}; // false
//        int[] nums = {3,2,1,0,4};
//        int[] nums = {0};

        System.out.println(canJump(nums));
    }
}
