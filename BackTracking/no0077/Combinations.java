package BackTracking.no0077;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public static void main(String[] args) {
        Combinations combinations = new Combinations();
        System.out.println(combinations.combine(4, 2));
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        combineRec(result, new ArrayList<>(), 1, n, k);
        return result;
    }

    public void combineRec(List<List<Integer>> result, List<Integer> temp, int start, int n, int k) {
        if (k == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i <= n; i++) {
            temp.add(i);
            combineRec(result, temp, i + 1, n, k - 1);
            temp.remove(temp.size() - 1);
        }
    }
}
