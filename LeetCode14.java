public class LeetCode14 {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder result = new StringBuilder();
        int index = 0;
        char expected;
        while (index < strs[0].length()) {
            for (int i = 0; i < strs.length; i++) {
                if (index >= strs[i].length()) {
                    return result.toString();
                } else if (index < strs[0].length()) {
                    expected = strs[0].charAt(index);
                } else {
                    return result.toString();
                }
                if (strs[i].charAt(index) != expected) {
                    return result.toString();
                } else if (i == strs.length - 1) {
                    result.append(expected);
                    index++;
                }
            }
        }
        return result.toString();
    }
}


// Stolen solution
//public String longestCommonPrefix(String[] strs) {
//    String prefix = strs[0];
//    for(int index=1;index<strs.length;index++){
//        while(strs[index].indexOf(prefix) != 0){
//            prefix=prefix.substring(0,prefix.length()-1);
//        }
//    }
//    return prefix;
//}
