package lc150;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
  public static List<String> summaryRanges(int[] nums) {
    List<String> result = new ArrayList<>();

    int i = 0;

    while (i < nums.length) {
      int start = nums[i];
      while (i < nums.length - 1 && nums[i + 1] == nums[i] + 1) {
        i++;
      }

      if (start == nums[i]) {
        result.add(String.valueOf(start));
      } else {
        result.add(start + "->" + nums[i]);
      }
      i++;

    }
    return result;
  }

  public static void main(String[] args) {

    int[] nums = { 0, 1, 2, 4, 5, 7 };

    List<String> summary = summaryRanges(nums);
    System.out.println(summary);
  }
}
