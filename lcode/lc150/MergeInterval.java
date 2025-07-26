package lc150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeInterval {

  public static int[][] merge(int[][] intervals) {
   Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
   List<int[]> merged = new ArrayList<>();
    int[] prev = intervals[0];

    for(int i = 1; i < intervals.length; i++) {
      if(intervals[i][0] <= prev[1]) {
        prev[i]  = Math.max(prev[1], intervals[i][1]);
      } else {
        merged.add(prev);
        prev = intervals[i] ;

      }
    }

    merged.add(prev);
    return merged.toArray(new int[merged.size()][]);
  }

  public static void main(String[] args) {
    int[][] intervals = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
    int[][] res = merge(intervals);


  }
}