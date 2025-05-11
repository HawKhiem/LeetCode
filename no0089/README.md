## 89. Gray Code

The **Gray code** is a binary numeral system where two successive values differ in only one bit. Given a non-negative
integer `n` representing the total number of bits in the code, return the sequence of **Gray code** in **reflected
binary code**.

---

### Example 1:

**Input:**  
n = 2  
**Output:**  
[0,1,3,2]  
**Explanation:**  
The Gray code sequence for n = 2 is:  
[00, 01, 11, 10] in binary, which corresponds to the decimal numbers [0,1,3,2].

---

### Example 2:

**Input:**  
n = 1  
**Output:**  
[0,1]

---

### Constraints:

- `1 <= n <= 16`
- The answer is guaranteed to be in the range `[0, 2^n - 1]`
