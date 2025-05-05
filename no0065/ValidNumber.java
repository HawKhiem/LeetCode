package no0065;

public class ValidNumber {
    // TODO - Intuition:
    //  https://medium.com/@sheefanaaz6417/65-valid-number-leetcode-hard-ste-by-step-approach-f7d5215c19fb
    public boolean isNumber(String s) {
        boolean digitSeen = false, dotSeen = false, eSeen = false;
        int plusMinusCount = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                digitSeen = true;
            } else if (ch == '+' || ch == '-') {
                if (plusMinusCount == 2) {
                    return false;
                }

                if (i > 0 && (s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E')) {
                    return false;
                }

                if (i == s.length() - 1) {
                    return false;
                }

                plusMinusCount++;
            } else if (ch == '.') {
                if (eSeen || dotSeen) {
                    return false;
                }

                if (i == s.length() - 1 && !digitSeen) {
                    return false;
                }

                dotSeen = true;
            } else if (ch == 'e' || ch == 'E') {
                if (eSeen || !digitSeen || i == s.length() - 1) {
                    return false;
                }

                eSeen = true;
            } else {
                return false;
            }
        }
        return true;
    }


}
