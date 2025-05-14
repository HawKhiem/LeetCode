## 112. Path Sum

Given the `root` of a binary tree and an integer `targetSum`, return `true` if the tree has a **root-to-leaf** path such
that adding up all the values along the path equals `targetSum`.  
A **leaf** is a node with no children.

---

### Example 1:

**Input:**  
root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22  
**Output:**  
true  
**Explanation:**  
The tree structure is as follows:
5
/ \
4 8
/ / \
11 13 4
/ \
7 2 1
One path that sums to 22 is:  
`5 -> 4 -> 11 -> 2`

---

### Example 2:

**Input:**  
root = [1,2,3], targetSum = 5  
**Output:**  
false  
**Explanation:**  
The tree structure is as follows:
1
/
2 3
No path from root to leaf adds up to 5.

---

### Example 3:

**Input:**  
root = [], targetSum = 0  
**Output:**  
false  
**Explanation:**  
An empty tree has no root-to-leaf path.

---

### Constraints:

- The number of nodes in the tree is in the range `[0, 5000]`.
- `-1000 <= Node.val <= 1000`
- `-10^9 <= targetSum <= 10^9`
