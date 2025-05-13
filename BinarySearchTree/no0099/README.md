## 99. Recover Binary Search Tree

You are given the root of a binary search tree (BST), where exactly two nodes of the tree were swapped by mistake. Recover the tree without changing its structure.

---

### Example 1:

**Input:**  
root = [1,3,null,null,2]  
**Output:**  
[3,1,null,null,2]  
**Explanation:**  
The tree structure before the fix:

      1
     / 
    3 
     \ 
      2
After swapping nodes 1 and 3, the structure becomes:

      1
     / 
    3 
     \ 
      2
---

### Example 2:

**Input:**  
root = [3,1,4,null,null,2]  
**Output:**  
[2,1,4,null,null,3]  
**Explanation:**  
The tree structure before the fix:

    3
   / \
  1   4
     /
    2

After swapping nodes 2 and 3, the structure becomes:

    2
   / \
  1   4
     /
    3

---

### Constraints:

- The number of nodes in the tree is in the range `[2, 1000]`.
- `-2^31 <= Node.val <= 2^31 - 1`

---

### Follow-up:

- A solution using **O(n)** space is pretty straightforward. Could you devise a constant **O(1)** space solution?
