## 130. Surrounded Regions

Given an `m x n` matrix `board` containing `'X'` and `'O'`, capture all regions that are 4-directionally surrounded by
`'X'`.

A region is captured by flipping all `'O'`s into `'X'`s in that surrounded region.

---

### Example 1:

**Input:**

```
board = [
  ["X","X","X","X"],
  ["X","O","O","X"],
  ["X","X","O","X"],
  ["X","O","X","X"]
]
```

**Output:**

```
[
  ["X","X","X","X"],
  ["X","X","X","X"],
  ["X","X","X","X"],
  ["X","O","X","X"]
]
```

**Explanation:**

- Surrounded regions should not be on the border.
- Any `'O'` on the border, and any `'O'` connected to an `'O'` on the border, is not flipped.
- The other `'O'`s are flipped to `'X'`.

---

### Example 2:

**Input:**

```
board = [["X"]]
```

**Output:**

```
[["X"]]
```

---

### Constraints:

- `m == board.length`
- `n == board[i].length`
- `1 <= m, n <= 200`
- `board[i][j]` is `'X'` or `'O'`
