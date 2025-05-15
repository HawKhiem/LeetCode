## 117. Populating Next Right Pointers in Each Node II

Given a binary tree, populate each `next` pointer to point to its **next right node**.  
If there is no next right node, the `next` pointer should be set to `NULL`.

The tree can be **any binary tree** (not necessarily perfect).  
Initially, all `next` pointers are set to `NULL`.

---

### Example 1:

**Input:**  
root = [1,2,3,4,5,null,7]  
**Output:**  
[1,#,2,3,#,4,5,7,#]  
**Explanation:**  
The tree structure is as follows:
1 -> NULL
/ \
2 -> 3 -> NULL
/ \    \
4-> 5 -> 7 -> NULL

---

### Example 2:

**Input:**  
root = []  
**Output:**  
[]  
**Explanation:**  
An empty tree has no connections to populate.

---

### Constraints:

- The number of nodes in the tree is in the range `[0, 6000]`.
- `-100 <= Node.val <= 100`

---

### Follow-up:

- You may only use **constant extra space**.
- The recursive approach is fine. You may assume implicit stack space does not count as extra space for this problem.
