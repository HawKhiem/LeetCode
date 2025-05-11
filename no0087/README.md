## 87. Scramble String

We can scramble a string s to get a string t using the following algorithm:

1. If the length of the string is 1, stop.
2. If the length of the string is > 1, do the following:
    - Split the string into two non-empty substrings at a random index.
    - Swap the two substrings randomly.
    - Recursively scramble each of the two substrings.

Given two strings `s1` and `s2` of the same length, return `true` if `s2` is a scrambled string of `s1`, otherwise,
return `false`.

---

### Example 1:

**Input:**  
s1 = "great", s2 = "rgeat"  
**Output:**  
true  
**Explanation:**  
One possible way to obtain "rgeat" is:

- "great" → "gr/eat"
- "eat" → "e/at"
- "at" → "at" (no change)
- "gr/eat" → "rgeat"

---

### Example 2:

**Input:**  
s1 = "abcde", s2 = "caebd"  
**Output:**  
false

---

### Example 3:

**Input:**  
s1 = "a", s2 = "a"  
**Output:**  
true

---

### Constraints:

- `s1.length == s2.length`
- `1 <= s1.length <= 30`
- `s1` and `s2` consist of lowercase English letters.
