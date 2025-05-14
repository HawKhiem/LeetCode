## 111. Minimum Depth of Binary Tree

Given a binary tree, find its **minimum depth**.  
The **minimum depth** is the number of nodes along the shortest path from the root node down to the nearest leaf node.

A **leaf** is a node with no children.

---

### Example 1:

**Input:**  
root = [3,9,20,null,null,15,7]  
**Output:**  
2  
**Explanation:**  
The tree structure is as follows:
3
/ \
9 20
/  \
15 7
The shortest path to a leaf node is from the root to node `9`, which has a depth of `2`.

---

### Example 2:

**Input:**  
root = [2,null,3,null,4,null,5,null,6]  
**Output:**  
5  
**Explanation:**  
The tree structure is as follows:
2
\
3
\
4
\
5
\
6
The minimum depth is `5`, as the shortest path from the root to a leaf is through nodes `2 -> 3 -> 4 -> 5 -> 6`.

---

### Constraints:

- The number of nodes in the tree is in the range `[0, 10^5]`.
- `-1000 <= Node.val <= 1000`
