package lc150;


// https://www.youtube.com/watch?v=El4DhjI9J3U&list=PLot-Xpze53lfJlNm5S0fq3AmoyugNGqPk


import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        System.out.println(hasDuplicate(nums));


    }

    public static boolean hasDuplicate(int[] nums) {

        Map<Integer, Boolean> uniqs = new HashMap<>();

        for(Integer n: nums) {
            if(uniqs.containsKey(n)) {
                return true;
            }
            uniqs.put(n, true);
        }
        return false;
    }
}
