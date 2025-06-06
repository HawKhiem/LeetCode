## 127. Word Ladder

A **transformation sequence** from word `beginWord` to word `endWord` using a dictionary `wordList` is a sequence of
words such that:

1. The first word is `beginWord`.
2. The last word is `endWord`.
3. Only one letter can be changed at a time.
4. Each transformed word must exist in the word list. Note that `beginWord` is not a transformed word.

Given two words, `beginWord` and `endWord`, and a dictionary `wordList`, return _the number of words in the shortest
transformation sequence from `beginWord` to `endWord`_, or `0` if no such sequence exists.

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
5
```

**Explanation:**
One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> "cog", which is 5 words long.

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
0
```

**Explanation:**
The endWord "cog" is not in wordList, so no valid transformation sequence exists.

---

### Constraints:

- `1 <= beginWord.length <= 10`
- `endWord.length == beginWord.length`
- `1 <= wordList.length <= 5000`
- `wordList[i].length == beginWord.length`
- `beginWord`, `endWord`, and `wordList[i]` consist of lowercase English letters.
- `beginWord != endWord`
- All the words in `wordList` are **unique**.
