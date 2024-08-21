public class LeetCode6 {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        StringBuilder result = new StringBuilder();
        int count = 0;
        int rep = (numRows + numRows - 2);
        int rest = (s.length() % rep) > numRows ? 1 + (s.length() % rep) % numRows : 1;
        int n = s.length() / rep * (numRows - 1) + rest;
        Character[][] arr = new Character[numRows][n];
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < numRows; x++) {
                if (count < s.length()) {
                    if (y % (numRows - 1) == 0) {
                        arr[x][y] = s.charAt(count++);
                    } else if ((x + y) % (numRows - 1) == 0) {
                        arr[x][y] = s.charAt(count++);
                    }
                }
            }
        }
        for (int x = 0; x < numRows; x++) {
            for (int y = 0; y < n; y++) {
                if (arr[x][y] != null) {
                    result.append(arr[x][y]);
                }
            }
        }
        return result.toString();
    }
}
