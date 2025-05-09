package BackTracking.no0079;

import java.util.HashSet;
import java.util.Set;

public class WordSearch {
    public static void main(String[] args) {
        WordSearch wordSearch = new WordSearch();
        char[][] board = {{'A', 'B', 'C', 'E' }, {'S', 'F', 'C', 'S' }, {'A', 'D', 'E', 'E' }};
        String word = "ABCB";
        System.out.println(wordSearch.exist(board, word));
    }

    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        Set<Tuple<Integer, Integer>> path = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                /// if any starting position would return true, it means that the word can be found
                if (existRec(board, word, path, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    // TODO: use backtracking to test out all the directions we could go
    //  index denotes the index of the character to be found in the string word.
    //  If index ever reach the length of the word, it means we have found
    //  all the character in the word. Row and col denotes the position we want to test
    //  path contains all the positions we have tried so far. Obviously we could not use the same cell twice
    private boolean existRec(char[][] board, String word, Set<Tuple<Integer, Integer>> path, int index, int row, int col) {
        /// index reach the length of the word -> word has been matched completely
        if (index == word.length()) {
            return true;
        }
        /// if the coordinate is out of bound of the character at the position is different from the character at index
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] != word.charAt(index) || path.contains(new Tuple<>(row, col))) {
            return false;
        }
        Tuple<Integer, Integer> trialStartingPosition = new Tuple<>(row, col);
        path.add(trialStartingPosition);
        /// go down
        if (existRec(board, word, path, index + 1, row + 1, col)) {
            return true;
        }
        /// go right
        if (existRec(board, word, path, index + 1, row, col + 1)) {
            return true;
        }
        /// go up
        if (existRec(board, word, path, index + 1, row - 1, col)) {
            return true;
        }
        /// go left
        if (existRec(board, word, path, index + 1, row, col - 1)) {
            return true;
        }
        path.remove(trialStartingPosition);
        return false;
    }

    public static class Tuple<X, Y> {
        private final X first;
        private final Y second;

        public Tuple(X first, Y second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Tuple tuple = (Tuple) o;
            return first.equals(tuple.first) && second.equals(tuple.second);
        }

        @Override
        public int hashCode() {
            return first.hashCode() ^ second.hashCode();
        }
    }
}
