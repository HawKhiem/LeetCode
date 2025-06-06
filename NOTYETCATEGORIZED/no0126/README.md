## 126. Word Ladder II

A **transformation sequence** from word `beginWord` to word `endWord` using a dictionary `wordList` is a sequence of
words such that:

1. The first word in the sequence is `beginWord`.
2. The last word is `endWord`.
3. Only one letter is changed at a time.
4. Each transformed word must exist in the word list. Note that `beginWord` is not a transformed word.

Return _all the shortest transformation sequences from `beginWord` to `endWord`_. You may return the answer in **any
order**.

---

### Example 1:

**Input:**

```
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log","cog"]
```

**Output:**

```
[
  ["hit","hot","dot","dog","cog"],
  ["hit","hot","lot","log","cog"]
]
```

---

### Example 2:

**Input:**

```
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]
```

**Output:**

```
[]
```

**Explanation:** The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.

---

### Constraints:

- `1 <= beginWord.length <= 5`
- `endWord.length == beginWord.length`
- `1 <= wordList.length <= 500`
- `wordList[i].length == beginWord.length`
- `beginWord`, `endWord`, and `wordList[i]` consist of lowercase English letters.
- `beginWord != endWord`
- All the words in `wordList` are **unique**.
- The **sum of all** `wordList[i].length` is **less than or equal to 5 * 10^5`.
