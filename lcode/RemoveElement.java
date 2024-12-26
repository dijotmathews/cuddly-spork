public class RemoveElement {
    
    public static int removeElement(int[] nums, int  val) {
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != val) {
                nums[idx] = nums[i];
                idx++;
            }
        }
        return idx;
    }


    public static void main(String[] args) {
        System.out.println("solved");
        // int[] nums = {0,1,2,2,3,0,4,2}; // {3,2,2,3};
        int[] nums = {1}; // {3,2,2,3};
        int val = 1;
        // int[] expectedNums;

        int k = removeElement(nums,val);
        System.out.println(k);
    }
}
