## 113. Path Sum II

Given the `root` of a binary tree and an integer `targetSum`,  
return **all root-to-leaf paths** where each path's sum equals `targetSum`.  
A **leaf** is a node with no children.

---

### Example 1:

**Input:**  
root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22  
**Output:**  
[[5,4,11,2],[5,8,4,5]]  
**Explanation:**  
The tree structure is as follows:
5
/ \
4 8
/ / \
11 13 4
/ \ /
7 2 5 1
There are two paths that sum to 22:

- `5 -> 4 -> 11 -> 2`
- `5 -> 8 -> 4 -> 5`

---

### Example 2:

**Input:**  
root = [1,2,3], targetSum = 5  
**Output:**  
[]  
**Explanation:**  
The tree structure is as follows:
1
/
2 3
No root-to-leaf path sums to 5.

---

### Example 3:

**Input:**  
root = [1,2], targetSum = 0  
**Output:**  
[]  
**Explanation:**  
No path from root to leaf adds up to 0.

---

### Constraints:

- The number of nodes in the tree is in the range `[0, 5000]`.
- `-1000 <= Node.val <= 1000`
- `-10^9 <= targetSum <= 10^9`

