public class MajorityElement1 {

    public static int majorityElement1(int[] nums) {

        int result = 0;
        int majority = 0;


        for(int i= 0; i< nums.length; i++){
            if(majority == 0) {
                result = nums[i];
                // System.out.println("\nmajority is 0. so reset result to "+ result);
            }

            majority += nums[i] == result ? 1 : -1;
            // System.out.println("current majority is "+ majority + " and result is "+ result + " num is "+ nums[i]);
            // System.out.println("m: "+ majority + " ");
            // System.out.println("r: "+ result+ " ");
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,3,3,2,3};
        int res = majorityElement1(nums);




        System.out.println(res);
    }
}
