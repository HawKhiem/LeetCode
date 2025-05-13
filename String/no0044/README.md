## 44. Wildcard Matching

Given an input string `s` and a pattern `p`, implement wildcard pattern matching with support for the following:

- `'?'` matches any single character.
- `'*'` matches any sequence of characters (including the empty sequence).

The matching should **cover the entire input string** (not just a partial match).

---

### Example 1:

**Input:**  
`s = "aa"`, `p = "a"`

**Output:**  
`false`

**Explanation:**  
`"a"` does not match the entire string `"aa"`.

---

### Example 2:

**Input:**  
`s = "aa"`, `p = "*"`

**Output:**  
`true`

**Explanation:**  
`'*'` matches any sequence.

---

### Example 3:

**Input:**  
`s = "cb"`, `p = "?a"`

**Output:**  
`false`

**Explanation:**  
`'?'` matches `'c'`, but the second character `'a'` does not match `'b'`.

---

### Constraints:

- `0 <= s.length, p.length <= 2000`
- `s` contains only lowercase English letters.
- `p` contains only lowercase English letters, `'?'`, or `'*'`.
