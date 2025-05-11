
package lc150;

class MaxSumSubarray {

  public static int nSquarSol(int[] nums) {
    int max_sum = 0;
    for (int i = 0; i < nums.length; i++) {
      int sum = nums[i];
      for (int j = i + 1; j < nums.length; j++) {
        int new_sum = sum + nums[j];
        System.out.printf("sum %d, new sum  %d,  max %d", sum, new_sum, max_sum);
        System.out.println();
        if (new_sum > max_sum) {
          max_sum = new_sum;
        }
        sum = new_sum;
      }
    }
    return max_sum;
  }


  public static int kadanesSol(int[] nums) {
    int maxSub = nums[0];
    int curSum = 0;
    for (int n : nums) {
      if(curSum < 0) {
        curSum = 0;
      }
      curSum += n;
      maxSub = Math.max(curSum, maxSub);
    }
    return maxSub;

  }
  public static void main(String[] args) {
    int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
    int maxSub = kadanesSol(nums);

    System.out.println(maxSub);
  }

}
