package BackTracking.no0093;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
    public static void main(String[] args) {
        RestoreIPAddresses leetcode = new RestoreIPAddresses();
        System.out.println(leetcode.restoreIpAddresses("101023"));
    }


    // TODO - naive approach: backtracking
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backtracking(s, 3, result, "");
        return result;
    }

    private void backtracking(String s, int numberOfDots, List<String> result, String temp) {
        if (numberOfDots == 0 && isValid(s)) {
            temp += s;
            result.add(temp);
            return;
        } else if (numberOfDots != 0 && s.isEmpty()) {
            return;
        } else if (numberOfDots == 0 && !isValid(s)) {
            return;
        }
        StringBuilder tempBuilder = new StringBuilder(temp);
        for (int i = 0; i < Math.min(3, s.length()); i++) {
            String before = tempBuilder.toString();
            if (!isValid(s.substring(0, i + 1))) {
                return;
            }
            if (numberOfDots > 0) {
                tempBuilder.append(s, 0, i + 1).append(".");
            } else {
                tempBuilder.append(s, 0, i + 1);
            }
            backtracking(s.substring(i + 1), numberOfDots - 1, result, tempBuilder.toString());
            tempBuilder = new StringBuilder(before);
        }
    }


    /// valid if no leading zeros and value from 0 to 255
    private boolean isValid(String s) {
        if (s.isEmpty()) {
            return false;
        }
        if (s.length() > 3) {
            return false;
        }
        if (s.charAt(0) == '0' && s.length() >= 2) {
            return false;
        }
        return Integer.parseInt(s) <= 255;
    }
}

