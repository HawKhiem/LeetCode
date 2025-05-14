## 108. Convert Sorted Array to Binary Search Tree

Given an integer array `nums` where the elements are sorted in **ascending order**,  
convert it to a **height-balanced** binary search tree.

A **height-balanced** binary tree is a binary tree in which the depth of the two subtrees of every node never differs by
more than one.

---

### Example 1:

**Input:**  
nums = [-10,-3,0,5,9]  
**Output:**  
[0,-3,9,-10,null,5]  
**Explanation:**  
The tree structure is as follows:
0
/ \
-3 9
/ /
-10 5
The binary search tree is height-balanced.

---

### Example 2:

**Input:**  
nums = [1,3]  
**Output:**  
[3,1]  
**Explanation:**  
The tree structure is as follows:
3
/
1
The binary search tree is height-balanced.

---

### Constraints:

- `1 <= nums.length <= 10^4`
- `-10^4 <= nums[i] <= 10^4`
- `nums` is sorted in a **strictly increasing** order.
