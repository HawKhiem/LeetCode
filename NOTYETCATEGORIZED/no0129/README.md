## 129. Sum Root to Leaf Numbers

You are given the `root` of a binary tree containing digits from `0` to `9` only.

Each root-to-leaf path in the tree represents a number.

- For example, the root-to-leaf path `1 -> 2 -> 3` represents the number `123`.

Return the total sum of all root-to-leaf numbers. A leaf node is a node with no children.

---

### Example 1:

**Input:**

```
    1
   / \
  2   3
```

**Output:**

```
25
```

**Explanation:**

- The root-to-leaf path `1->2` represents the number `12`.
- The root-to-leaf path `1->3` represents the number `13`.
- Sum = 12 + 13 = 25.

---

### Example 2:

**Input:**

```
      4
     / \
    9   0
   / \
  5   1
```

**Output:**

```
1026
```

**Explanation:**

- Paths: `4->9->5 = 495`, `4->9->1 = 491`, `4->0 = 40`.
- Sum = 495 + 491 + 40 = 1026.

---

### Constraints:

- The number of nodes in the tree is in the range `[1, 1000]`.
- `0 <= Node.val <= 9`
- The input tree is guaranteed to have no nodes with only one child.
