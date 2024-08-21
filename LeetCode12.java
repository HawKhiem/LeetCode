public class LeetCode12 {
    public int[] cons = {1, 5, 10, 50, 100, 500, 1000};
    public int[] subCons = {4, 9, 40, 90, 400, 900};
    public String[] roman = {"I", "V", "X", "L", "C", "D", "M"};
    public String[] subtract = {"IV", "IX", "XL", "XC", "CD", "CM"};

    public String intToRoman(int num) {
        StringBuilder result = new StringBuilder();
        while (num > 0) {
            int index = getIndex(num, cons);
            int totalDigits = (int) Math.log10(num);
            int firstDigit = (int) (num / (int) Math.pow(10, totalDigits));
            // subtract form - value start with 4 or 9
            if (firstDigit == 4 || firstDigit == 9) {
                index = getIndex(num, subCons);
                result.append(subtract[index]);
                num -= subCons[index];
            } else {
                while (num >= cons[index]) {
                    num -= cons[index];
                    result.append(roman[index]);
                }
            }
        }
        return result.toString();
    }

    public int getIndex(int num, int[] cons) {
        for (int i = cons.length - 1; i >= 0; i--) {
            if (num >= cons[i]) {
                return i;
            }
        }
        return -1;
    }
}

//Stolen solution:7
//public String intToRoman(int num) {
//    StringBuilder str = new StringBuilder();
//    str.append(thousands[(int) num / 1000]);
//    str.append(hundreds[(num % 1000) / 100]);
//    str.append(tens[(num % 100) / 10]);
//    str.append(ones[num % 10]);
//    return str.toString();
//}
//private static final String ones[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
//private static final String tens[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
//private static final String hundreds[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
//private static final String thousands[] = {"", "M", "MM", "MMM"};