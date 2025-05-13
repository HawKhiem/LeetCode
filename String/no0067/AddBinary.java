package String.no0067;

public class AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int carry = 0;
        for (int i = 0; i < a.length() || i < b.length(); i++) {
            int temp = 0;
            if (i < a.length()) {
                temp += a.charAt(a.length() - 1 - i) - '0';
            }
            if (i < b.length()) {
                temp += b.charAt(b.length() - 1 - i) - '0';
            }
            temp += carry;
            carry = temp / 2;
            result.insert(0, (temp % 2));
        }
        return carry == 0 ? result.toString() : carry + result.toString();
    }

    // TODO - a beautiful solution
    //     public String addBinary(String a, String b) {
    //        StringBuilder res = new StringBuilder();
    //        int i = a.length() - 1;
    //        int j = b.length() - 1;
    //        int carry = 0;
    //        while (i >= 0 || j >= 0 || carry > 0) {
    //            int digitA = i >= 0 ? a.charAt(i) - '0': 0;
    //            int digitB = j >= 0 ? b.charAt(j) - '0': 0;
    //            i--;
    //            j--;
    //            int total = digitA + digitB + carry;
    //            res.append(total % 2);
    //            carry = total / 2;
    //        }
    //        return res.reverse().toString();
    //    }
}
