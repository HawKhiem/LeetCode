## 110. Balanced Binary Tree

Given a binary tree, determine if it is **height-balanced**.  
A **height-balanced** binary tree is defined as:  
A binary tree in which the **left and right subtrees** of every node differ in height by **no more than 1**.

---

### Example 1:

**Input:**  
root = [3,9,20,null,null,15,7]  
**Output:**  
true  
**Explanation:**  
The tree structure is as follows:
3
/ \
9 20
/  \
15 7
The left and right subtrees of each node differ in height by no more than 1.

---

### Example 2:

**Input:**  
root = [1,2,2,3,3,null,null,4,4]  
**Output:**  
false  
**Explanation:**  
The tree structure is as follows:
1
/ \
2 2
/ \
3 3
/
4 4
The left subtree of the root is not balanced as the height difference between its children is greater than 1.

---

### Example 3:

**Input:**  
root = []  
**Output:**  
true  
**Explanation:**  
An empty tree is considered balanced.

---

### Constraints:

- The number of nodes in the tree is in the range `[0, 5000]`.
- `-10^4 <= Node.val <= 10^4`
