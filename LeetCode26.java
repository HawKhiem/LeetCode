public class LeetCode26 {
    public static void main(String[] args) {
        LeetCode26 leetcode26 = new LeetCode26();
        System.out.println((leetcode26.removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4})));
    }

    public int removeDuplicates(int[] nums) {
        int counter = 0;
        int unique;
        // turn all non-uniques into 101
        for (int i = 0; i < nums.length; i++) {
            // skip the underscore
            while (i < nums.length && nums[i] == 101) {
                i++;
            }
            if (i >= nums.length) {
                break;
            }
            unique = nums[i];
            counter++;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == unique) {
                    nums[j] = 101;
                }
            }
        }

        // shift the array
        int i;
        int j = nums.length;
        for (i = 0; i < nums.length; i++) {
            if (nums[i] == 101 && i < j) {
                j = i;
            } else if (nums[i] != 101 && j != nums.length) {
                swap(nums, i, j);
                int temp = i;
                i = j;
                j = temp;
            }
        }
        return counter;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

// Stolen solution
//     public int removeDuplicates(int[] arr) {
//        int i=0;
//        for(int j=1;j<arr.length;j++){
//            if(arr[i]!=arr[j]){
//                i++;
//                arr[i]=arr[j];
//            }
//        }
//        return i+1;
//
//    }
