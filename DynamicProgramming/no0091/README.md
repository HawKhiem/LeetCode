## 91. Decode Ways

A message containing letters from `A-Z` can be encoded into numbers using the following mapping:

- 'A' -> "1"
- 'B' -> "2"
- ...
- 'Z' -> "26"

To decode an encoded message, all the possible ways are counted.

Given a string `s` consisting of digits, return the total number of ways to decode it.

Since the answer may be very large, return it modulo 109 + 7.

---

### Example 1:

**Input:**  
s = "12"  
**Output:**  
2  
**Explanation:**  
It could be decoded as "AB" (1 2) or "L" (12).

---

### Example 2:

**Input:**  
s = "226"  
**Output:**  
3  
**Explanation:**  
It could be decoded as "BBF" (2 2 6), "BZ" (2 26), or "VF" (22 6).

---

### Example 3:

**Input:**  
s = "06"  
**Output:**  
0  
**Explanation:**  
"06" cannot be decoded because "6" is not a valid encoding for any letter.

---

### Constraints:

- `1 <= s.length <= 100`
- `s[i]` is a digit from '0' to '9'
- `s` does not contain leading zeros.
