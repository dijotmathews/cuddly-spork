public class RemoveDuplicates2 {
    public static int removeDuplicates(int[] nums) {
        int n = nums.length; 
        if(n <=2) {
            return n;
        }

        int idx = 2;
        for(int i = 2;  i < n; i++) {
            if(nums[i] != nums[idx-2]) {
                nums[idx] = nums[i];
                idx++;        
            } 
        }
        return idx;
    }


    public static void main(String[] args) {
        System.out.println("solved");
        // int[] nums = {0,1,2,2,3,0,4,2}; // {3,2,2,3};
        int[] nums = {0,0,1,1,1,2,2,3,3,4}; // {3,2,2,3};


        int k = removeDuplicates(nums);
        System.out.println(k);
    }
}
