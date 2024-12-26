import java.util.Arrays;


//https://leetcode.com/problems/rotate-array/submissions/1487436764
public class RotateArray {

    public static void rotate(int[] nums, int k){
        int s = nums.length;
        int[] p1 = new int[s];

        for(int i = 0; i < s; i++ ) {
            int pos = ( i + k) % s;
            p1[pos] = nums[i];
        }

        System.arraycopy(p1, 0, nums, 0, s);

        System.out.println(Arrays.toString(nums));
    }
    public static void main(String[] args) {
//        int[] nums = {-1,-100,3,99};
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;

        rotate(nums, k);

        System.out.println("working");
    }
}
