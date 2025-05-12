## 94. Binary Tree Inorder Traversal

Given the root of a binary tree, return the inorder traversal of its nodes' values.

---

### Example 1:

**Input:**  
root = [1,null,2,3]  
**Output:**  
[1,3,2]  
**Explanation:**  
The inorder traversal of the given binary tree is [1,3,2].

---

### Example 2:

**Input:**  
root = []  
**Output:**  
[]  
**Explanation:**  
The tree is empty, so the output is an empty list.

---

### Example 3:

**Input:**  
root = [1]  
**Output:**  
[1]  
**Explanation:**  
The tree only has one node.

---

### Constraints:

- The number of nodes in the tree is in the range `[0, 100]`.
- `-100 <= Node.val <= 100`

---

### Follow-up:
Recursive solution is straightforward, could you do it iteratively?
