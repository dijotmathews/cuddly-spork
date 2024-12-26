import java.util.Arrays;

public class RotateArray1 {

    public static void flip(int[] nums,int l ,int r) {
        System.out.println(Arrays.toString(nums));
        while(l < r) {
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
            l++;
            r--;
        }


    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        int l = 0;
        int r = nums.length - 1;

        flip(nums, l, r);
        System.out.println(Arrays.toString(nums));

        flip(nums, 0 , k-1);
        System.out.println(Arrays.toString(nums));

        flip(nums, k, nums.length -1);
        System.out.println(Arrays.toString(nums));


    }
}
