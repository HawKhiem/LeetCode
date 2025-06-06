package NOTYETCATEGORIZED.no0125;

public class ValidPalindrome {
    public static void main(String[] args) {
        ValidPalindrome p = new ValidPalindrome();
        System.out.println(p.isPalindrome("A man, a plan, a canal: Panama"));
    }

    public boolean isPalindrome(String s) {
        if (s.isEmpty()) {
            return true;
        }
        int left = 0;
        int right = s.length() - 1;
        s = s.toLowerCase();
        while (left < right) {
            if (!Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            } else if (!Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            } else if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
        }
        return true;
    }
}
