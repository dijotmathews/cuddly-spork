package lc150;

import java.util.*;

public class LongestConsecutive {
   public static int longestConsecutive(int[] nums)  {
       Set<Integer> numSet = new HashSet<>();
       for (int n : nums) {
           numSet.add(n);
       }
        int lenLongestSeq = 0;


       for(int n : numSet) {
          if(!numSet.contains(n - 1)) {
              List<Integer> seq = new ArrayList<>();
              seq.add(n);
              int s = n;
              while (numSet.contains(++s)) {
                  seq.add(s);
              }
              lenLongestSeq = Math.max(seq.size(), lenLongestSeq);

          }

       }

       return lenLongestSeq;
   }
    public  static void main(String[] args) {

       int[] nums = {0,0,-1};

       int max = longestConsecutive(nums);

       System.out.println(max);
    }
}
