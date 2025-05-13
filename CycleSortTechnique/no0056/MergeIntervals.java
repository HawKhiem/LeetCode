package CycleSortTechnique.no0056;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

    // TODO - naive approach: Sort the intervals based on their starting value, then iterate through the intervals and merge them. Time: O(n*log(n))
    public int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        /// We cannot assume that the intervals are sorted based on their starting value, therefore we have to sort first - O(n*log(n))
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        for (int[] interval : intervals) {
            if (result.isEmpty() || !isOverlapping(result.get(result.size() - 1), interval)) {
                result.add(interval);
            } else {
                result.set(result.size() - 1, merge(result.get(result.size() - 1), interval));
            }
        }
        return result.toArray(new int[result.size()][]);
    }

    private boolean isOverlapping(int[] a, int[] b) {
        return a[0] <= b[1] && b[0] <= a[1];
    }

    private int[] merge(int[] a, int[] b) {
        return new int[]{Math.min(a[0], b[0]), Math.max(a[1], b[1])};
    }

    // TODO - optimized approach:
    public int[][] mergeBetter(int[][] intervals) {
        int max = 0;
        /// find the maximum start value
        for (int[] interval : intervals) {
            max = Math.max(interval[0], max);
        }
        /// worst case, every interval is different
        int[] mp = new int[max + 1];
        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];
            /// similar to cycle sort, putting each interval to its correct position using the start value as index.
            /// We do know that they are greater than 0, therefore we can do this. This basically replaces the slow sorting
            /// Why take the max of end + 1 and mp[start]? It could be the case that two or more intervals start at the same value.
            /// But why end + 1? Because it will make detecting when an interval ends easier in the next step.
            mp[start] = Math.max(end + 1, mp[start]);
        }

        /// The interval is stored directly in the original intervals array (overwriting reused space).
        int r = 0;
        /// have tracks how far the current interval can extend.
        int have = -1;
        /// intervalStart keeps track of the start of a merged interval.
        int intervalStart = -1;
        for (int i = 0; i < mp.length; i++) {
            if (mp[i] != 0) {
                if (intervalStart == -1) {
                    intervalStart = i;
                }
                have = Math.max(mp[i] - 1, have);
            }
            /// When the current index i reaches have, it means the interval ends here.
            if (have == i) {
                intervals[r++] = new int[]{intervalStart, have};
                have = -1;
                intervalStart = -1;
            }
        }

        /// This handles any remaining interval that was still open at the end of the loop.
        if (intervalStart != -1) {
            intervals[r++] = new int[]{intervalStart, have};
        }
        /// If no extra space is used, it just returns the modified original array.
        if (intervals.length == r) {
            return intervals;
        }
        /// Otherwise, creates a new array of the correct size and returns that.
        int[][] res = new int[r][];
        System.arraycopy(intervals, 0, res, 0, r);

        return res;
    }
}
