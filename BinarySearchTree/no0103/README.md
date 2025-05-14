## 103. Binary Tree Zigzag Level Order Traversal

Given the root of a binary tree, return the **zigzag level order traversal** of its nodes' values.  
(i.e., from left to right, then right to left for the next level and alternate between).

---

### Example 1:

**Input:**  
root = [3,9,20,null,null,15,7]  
**Output:**  
[[3],[20,9],[15,7]]  
**Explanation:**  
The tree structure is as follows:
3
/ \
9 20
/  \
15 7
The zigzag level order traversal is:

- Level 1: [3]
- Level 2: [20, 9] (reversed)
- Level 3: [15, 7]

---

### Example 2:

**Input:**  
root = [1]  
**Output:**  
[[1]]  
**Explanation:**  
The tree structure is as follows:
1
The zigzag level order traversal is: [1]

---

### Example 3:

**Input:**  
root = []  
**Output:**  
[]  
**Explanation:**  
The tree is empty, so the output is an empty list.

---

### Constraints:

- The number of nodes in the tree is in the range `[0, 2000]`.
- `-100 <= Node.val <= 100`
