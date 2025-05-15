package Math.no0119;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PascalTriangleII {
    public List<Integer> getRow(int rowIndex) {
        int[] nums = new int[rowIndex + 1];
        int index = 1;
        for (int i = 0; i <= rowIndex; i++) {
            nums[0] = 1;
            nums[i] = 1;
            int prev = 1;
            int cur;
            while (index < i) {
                cur = nums[index];
                nums[index] = prev + nums[index];
                prev = cur;
                index++;
            }
            index = 1;
        }
        return Arrays.stream(nums).boxed().collect(Collectors.toList());
    }
}
