package lc150;

import java.util.HashMap;

public class ContainsDuplicate2 {


    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer>  visited = new HashMap<>() ;


        for(int i = 0; i < nums.length; i++) {
            if(visited.containsKey(nums[i])) {

                int diff = i - visited.get(nums[i]);
                if(diff <= k )
                    return  true;
            }
            visited.put(nums[i], i);
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1,2,3};

        int k = 2;

       if(containsNearbyDuplicate(nums, k)) {
           System.out.println("found duplicate");
       }

    }
}
