import java.util.HashMap;

public class MajorityElement {

    public static int majorityElement(int[] nums){
        int n = nums.length;
        int majority = n/ 2;
        int higest = 0;
        int found = 0;

        HashMap<Integer, Integer> count = new HashMap<>();

        for(int i = 0; i<n; i++){
            if(count.containsKey(nums[i])) {
                int currentCount = count.get(nums[i]) + 1;
                count.put(nums[i],  currentCount);
                if(currentCount >= majority && currentCount > higest){
                    higest = currentCount;
                    found = nums[i];
                }
            } else {
                count.put(nums[i], 1);
            }
        }


        return found;

    }
    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        int res = majorityElement(nums);




        System.out.println(res);
    }
}
