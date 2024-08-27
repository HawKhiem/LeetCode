import java.util.Arrays;

public class LeetCode27 {
    public static void main(String[] args) {
        LeetCode27 leetcode = new LeetCode27();
        System.out.println((leetcode.removeElement(new int[]{10, 12, 14, 1, 2, 3, 4, 6, 6, 6, 1, 1, 2, 47}, 1)));
    }

    public int removeElement(int[] nums, int val) {
        Arrays.sort(nums);
        int i;
        int j = 0;
        while (j < nums.length) {
            if (nums[j] == val) {
                i = j;
                while (i < nums.length && nums[i] == val) {
                    i++;
                }
                while (i < nums.length) {
                    swap(nums, i, j);
                    i++;
                    j++;
                }
                return j;
            } else {
                j++;
            }
        }
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
// Stolen solution
//     public int removeElement(int[] nums, int val) {
//        int len = nums.length;
//        int cnt = 0,j=0;
//        int[] nums2 = new int[len];
//        for(int i = 0; i < len; i++){
//            nums2[i] = nums[i];
//        }
//        for(int i = 0; i < len; i++){
//            if(nums[i] == val){
//                cnt++;
//
//            }else{
//                nums[j++] = nums[i];
//            }
//
//        }
//        return len-cnt;
//    }