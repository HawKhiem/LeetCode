## 65. Valid Number

A valid number can be split into these components (in order):

1. A **decimal** number or an **integer**.
2. (Optional) An `'e'` or `'E'`, followed by an **integer** (the exponent).

A **decimal** number can be split into:

- Digits followed by a dot and optional digits (e.g., `"123."`, `"123.45"`)
- A dot followed by digits (e.g., `".45"`)

An **integer** consists of:

- (Optional) `'+'` or `'-'` sign, followed by digits (e.g., `"+123"`, `"-456"`)

The exponent must be an **integer** with an optional sign.

Write a function that checks if a given string is a valid number.

---

### Example 1:

**Input:**  
`s = "0"`

**Output:**  
`true`

---

### Example 2:

**Input:**  
`s = "e"`

**Output:**  
`false`

---

### Example 3:

**Input:**  
`s = "."`

**Output:**  
`false`

---

### Constraints:

- `1 <= s.length <= 20`
- `s` consists of only English letters (lower-case and upper-case), digits (`0-9`), `'+'`, `'-'`, and `'.'`.
