## 97. Interleaving String

Given strings `s1`, `s2`, and `s3`, find whether `s3` is formed by an **interleaving** of `s1` and `s2`.

An **interleaving** of two strings `s` and `t` is a configuration where they are divided into **non-empty** substrings such that:
- `s = s1 + s2 + ... + sn`
- `t = t1 + t2 + ... + tm`
- `|n - m| <= 1`
- The interleaving of `s` and `t` is formed by **interleaving** the substrings in a way that maintains the order of each string.

---

### Example 1:

**Input:**  
s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"  
**Output:**  
true  
**Explanation:**  
One possible way to interleave the strings is:  
s1: aabcc
s2: dbbca
s3: aadbbcbcac

---

### Example 2:

**Input:**  
s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"  
**Output:**  
false  
**Explanation:**  
The strings cannot be interleaved to form the given `s3`.

---

### Example 3:

**Input:**  
s1 = "", s2 = "", s3 = ""  
**Output:**  
true

---

### Constraints:

- `0 <= s1.length, s2.length <= 100`
- `0 <= s3.length <= 200`
- `s1`, `s2`, and `s3` consist of lowercase English letters.
