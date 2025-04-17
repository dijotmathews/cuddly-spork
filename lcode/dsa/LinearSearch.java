package dsa;

public class LinearSearch {
    public static void main(String[] args) {
        int[] nums = {4,5,6,9,12};
        int target = 9;

        int result = binarySearch(nums, target);
        System.out.println(result);



    }

    public static int linearSearch(int[] nums, int target) {
        for( int i = 0; i <= nums.length - 1; i++) {
            if(target == nums[i])
                return i;
        }
        return -1;
    }


    public static int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while(left <= right) {
            int mid = (left + right)/2;

            if(nums[mid] > target) {
                right = mid;
            }

            if(nums[mid] < target) {
                left = mid + 1;
            }

             if(nums[mid] == target) {
                 return mid;
             }

        }

        return -1;
    }
}
