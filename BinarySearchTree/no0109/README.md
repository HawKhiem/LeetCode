## 109. Convert Sorted List to Binary Search Tree

Given the head of a singly linked list where elements are sorted in **ascending order**,  
convert it to a **height-balanced** binary search tree.

A **height-balanced** binary tree is a binary tree in which the depth of the two subtrees of every node never differs by
more than one.

---

### Example 1:

**Input:**  
head = [-10,-3,0,5,9]  
**Output:**  
[0,-3,9,-10,null,5]  
**Explanation:**  
The linked list is as follows:
-10 -> -3 -> 0 -> 5 -> 9
The tree structure is as follows:
0
/ \
-3 9
/ /
-10 5

---

### Example 2:

**Input:**  
head = []  
**Output:**  
[]  
**Explanation:**  
The linked list is empty, so the binary search tree is also empty.

---

### Constraints:

- The number of nodes in the linked list is in the range `[0, 10^4]`.
- `-10^5 <= Node.val <= 10^5`
