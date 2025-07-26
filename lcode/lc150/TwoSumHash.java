package lc150;

import java.util.HashMap;

public class TwoSumHash {
   public static int[] twoSum(int[] nums, int target) {
       HashMap<Integer, Integer> cplmnt = new HashMap<>();
        HashMap<String, Integer[]> indices = new HashMap<>();


      for(int i = 0; i < nums.length; i++) {
          int diff = target - nums[i];

          if(cplmnt.containsKey(nums[i])) {
            return new int[]{i, cplmnt.get(nums[i])} ;
          }

          cplmnt.put(diff, i);

      }
      return new int[] {};
   }
    public static void main(String[] args) {
        int[] nums = {2,7,1,15};
        int target = 9;

        int[] res = twoSum(nums, target);
        for (int r : res) {
            System.out.println(r);
        }
    }
}
