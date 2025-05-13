## 57. Insert Interval

You are given an array of non-overlapping intervals `intervals` where `intervals[i] = [start_i, end_i]` sorted in
ascending order by `start_i`, and a new interval `newInterval = [start, end]`.

Insert `newInterval` into `intervals` such that the result is still a valid list of non-overlapping intervals sorted by
start time.

Return the new list of intervals.

---

### Example 1:

**Input:**  
`intervals = [[1,3],[6,9]], newInterval = [2,5]`

**Output:**  
`[[1,5],[6,9]]`

---

### Example 2:

**Input:**  
`intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]`

**Output:**  
`[[1,2],[3,10],[12,16]]`

**Explanation:**  
The new interval [4,8] overlaps with [3,5],[6,7],[8,10].

---

### Constraints:

- `0 <= intervals.length <= 10^4`
- `intervals[i].length == 2`
- `0 <= start_i <= end_i <= 10^5`
- `intervals` is sorted by `start_i` in ascending order.
- `newInterval.length == 2`
- `0 <= start <= end <= 10^5`
