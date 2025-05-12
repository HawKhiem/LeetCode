## 98. Validate Binary Search Tree

Given the root of a binary tree, determine if it is a **valid binary search tree (BST)**.

A **valid BST** is defined as follows:
1. The left subtree of a node contains only nodes with keys **less than** the node's key.
2. The right subtree of a node contains only nodes with keys **greater than** the node's key.
3. Both the left and right subtrees must also be binary search trees.

---

### Example 1:

**Input:**  
root = [2,1,3]  
**Output:**  
true  
**Explanation:**  
The tree structure is as follows:

    2
1       3

The given tree is a valid BST.

---

### Example 2:

**Input:**  
root = [5,1,4,null,null,3,6]  
**Output:**  
false  
**Explanation:**  
The tree structure is as follows:

    5   
1       4
    3       6

The node with value 4 is in the right subtree of 5 but has a left child 3, which violates the BST property.

---

### Constraints:

- The number of nodes in the tree is in the range `[1, 10^4]`.
- `-2^31 <= Node.val <= 2^31 - 1`


