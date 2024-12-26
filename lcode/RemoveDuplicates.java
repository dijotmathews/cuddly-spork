public class RemoveDuplicates {
    public static int removeDuplicates(int[] nums) {
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            System.out.println("i is at " + i + " with value " + nums[i]);
            if(nums[i] != nums[idx]) {
                System.out.println("value at idx " + nums[idx] + " found at " + idx + " not equal to "+ nums[i]);
                nums[++idx] = nums[i];
                System.out.println("idx moved to "+ idx);
                // idx++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+ " ,");
        }
        return idx+1;
    }


    public static void main(String[] args) {
        System.out.println("solved");
        // int[] nums = {0,1,2,2,3,0,4,2}; // {3,2,2,3};
        int[] nums = {0,0,1,1,1,2,2,3,3,4}; // {3,2,2,3};


        int k = removeDuplicates(nums);
        System.out.println(k);
    }
}
