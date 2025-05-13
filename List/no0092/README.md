## 92. Reverse Linked List II

Given the head of a singly linked list and two integers `left` and `right` where `1 <= left <= right <= n`, reverse the
nodes of the list from position `left` to position `right`, and return its head.

**Do it in one-pass.**

---

### Example 1:

**Input:**  
head = [1,2,3,4,5], left = 2, right = 4  
**Output:**  
[1,4,3,2,5]  
**Explanation:**  
The nodes from position 2 to 4 are reversed:  
[2,3,4] -> [4,3,2].

---

### Example 2:

**Input:**  
head = [5], left = 1, right = 1  
**Output:**  
[5]

---

### Constraints:

- The number of nodes in the list is n.
- `1 <= n <= 500`
- `-500 <= Node.val <= 500`
- `1 <= left <= right <= n`
