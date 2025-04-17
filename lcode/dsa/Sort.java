package dsa;

public class Sort {
    public static void main(String[] args) {
        // int[] nums = {10, 3, 4, 3, 8,6,9,2,4,5};
        int[] nums = {5,3,6,1,4,2};
        // int[] nums = {2,6,5,3,1,4};

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");

        }
        System.out.println();


        int[] sortedNums = mergeSort(nums, 0 , nums.length-1);


        for (int i = 0; i < nums.length; i++) {
            System.out.print(sortedNums[i] + " ");

        }
        System.out.println();

    }

    public static int[] bubbleSort(int[] nums) {
        int n = nums.length;

        for(int h = 0; h < n; h++) {
            for(int i = 0; i <  n - h - 1; i++) {
                if(nums[i] > nums[i+1]) {
                    int tmp = nums[i+1]; 
                    nums[i+1] = nums[i];
                    nums[i] = tmp;
                }
            }
        }


        return nums;
    }

    public static int[] selectionSort(int[] nums) {
        int maxIndex = 0;
        int n =  nums.length;

        for(int i = 0; i < n; i++ ){
            int j = 0;
            for(; j < n - i; j++ ) {
                if(nums[j] > nums[maxIndex]) {
                    maxIndex = j;
                }
            }

            int tmp = nums[maxIndex];
            nums[maxIndex] = nums[j - 1];
            nums[j - 1] = tmp;
            maxIndex = 0;
        }
        return nums;

    }

    public static int[] insertionSort(int[] nums) {
        int n = nums.length;
        for(int i = 1; i < n ; i++) {
            int j = i-1;

            int key = nums[i];

            while( j >=0 && key < nums[j]) {
                nums[j+1] = nums[j];
                j = j -1 ;
            }

            nums[j+1] = key;
        }

        return nums;
    }

    public static int[] quickSort(int[] nums,int low,int high) {
        if(low < high) {
            int pi = partition(0, high, nums);
            quickSort(nums, low, pi -1);
            quickSort(nums, pi+1, high);
        }

        return nums;

    }

    // https://www.youtube.com/watch?v=zyoVdrFW6E8
    public static int partition(int low, int high, int[] nums) {
        int pivot = nums[high];
        int pi = low;


        for (int i = low; i < high; i++) {
            if(pivot > nums[i] ) {
                if( pivot < nums[pi])
                    swap(pi, i, nums);
                pi++;
            }

        }
        swap(high, pi, nums);
        return pi;

    }

    public static void swap(int from, int to, int[] nums) {
        int tmp = nums[to];
        nums[to] = nums[from];
        nums[from] = tmp;
    }


    public static int[] mergeSort(int[] nums, int left, int right) {
        if(left < right) {
            int mid = (left + right) / 2;

            mergeSort(nums, left, mid);
            mergeSort(nums, mid + 1, right);

            merge(nums, left, mid, right);
        }
        return nums;
    }

    public static void merge(int[] nums, int left, int mid,int right ) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int lArr[] = new int[n1];
        int rArr[] = new int[n2];

        for(int x=0; x< n1; x++) {
            lArr[x] = nums[left+x];
        }

        for(int x=0; x < n2 ; x++) {
            rArr[x] = nums[mid + 1 +x];
        }

        int i = 0; 
        int j = 0;

        int k = left;

        while (i < n1 && j < n2 ) {
            if(lArr[i] <= rArr[j]) {
                nums[k] = lArr[i];
                i++;
            } else {
                nums[k] = rArr[j];
                j++;
            }
            k++;

        }

        while (i < n1) {
            nums[k] = lArr[i];
            i++;
            k++;
        }

        while (j < n2) {
            nums[k] = rArr[j];
            j++; 
            k++;
        }


    }
}
