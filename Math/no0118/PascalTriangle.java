package Math.no0118;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        if (numRows == 1) {
            return List.of(Arrays.asList(1));
        }
        if (numRows == 2) {
            return List.of(Arrays.asList(1), Arrays.asList(1, 1));
        }
        List<List<Integer>> result = new ArrayList<>();
        result.add(Arrays.asList(1));
        result.add(Arrays.asList(1, 1));
        int i = 3;
        while (i <= numRows) {
            List<Integer> current = new ArrayList<>();
            current.add(0, 1);
            List<Integer> prev = result.get(i - 2);
            for (int j = 0; j < prev.size() - 1; j++) {
                current.add(j + 1, prev.get(j) + prev.get(j + 1));
            }
            current.add(1);
            result.add(current);
            i++;
        }
        return result;
    }
}
