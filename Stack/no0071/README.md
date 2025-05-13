## 71. Simplify Path

Given a string `path`, which is an **absolute path** (starting with a slash `'/'`) to a file or directory in a
Unix-style file system, convert it to the **simplified canonical path**.

In a Unix-style file system:

- A period `'.'` refers to the current directory.
- A double period `'..'` refers to the directory up a level.
- Multiple consecutive slashes `'//'` are treated as a single slash `'/'`.
- The canonical path must always start with a single slash `'/'`.
- The canonical path must not end with a trailing `'/'` (unless it's just the root `/`).
- The canonical path must only contain directories on the path from the root, separated by a single slash `'/'`.

---

### Example 1:

**Input:**  
`path = "/home/"`  
**Output:**  
`"/home"`

---

### Example 2:

**Input:**  
`path = "/../"`  
**Output:**  
`"/"`  
**Explanation:**  
Going one level up from the root directory is still `/`.

---

### Example 3:

**Input:**  
`path = "/home//foo/"`  
**Output:**  
`"/home/foo"`

---

### Example 4:

**Input:**  
`path = "/a/./b/../../c/"`  
**Output:**  
`"/c"`

---

### Constraints:

- `1 <= path.length <= 3000`
- `path` consists of English letters, digits, period `'.'`, slash `'/'`, or `'_'`.
- `path` is a valid absolute Unix path.
