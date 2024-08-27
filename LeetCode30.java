import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LeetCode30 {
    public static void main(String[] args) {
        String s = "pjzkrkevzztxductzzxmxsvwjkxpvukmfjywwetvfnujhweiybwvvsrfequzkhossmootkmyxgjgfordrpapjuunmqnxxdrqrfgkrsjqbszgiqlcfnrpjlcwdrvbumtotzylshdvccdmsqoadfrpsvnwpizlwszrtyclhgilklydbmfhuywotjmktnwrfvizvnmfvvqfiokkdprznnnjycttprkxpuykhmpchiksyucbmtabiqkisgbhxngmhezrrqvayfsxauampdpxtafniiwfvdufhtwajrbkxtjzqjnfocdhekumttuqwovfjrgulhekcpjszyynadxhnttgmnxkduqmmyhzfnjhducesctufqbumxbamalqudeibljgbspeotkgvddcwgxidaiqcvgwykhbysjzlzfbupkqunuqtraxrlptivshhbihtsigtpipguhbhctcvubnhqipncyxfjebdnjyetnlnvmuxhzsdahkrscewabejifmxombiamxvauuitoltyymsarqcuuoezcbqpdaprxmsrickwpgwpsoplhugbikbkotzrtqkscekkgwjycfnvwfgdzogjzjvpcvixnsqsxacfwndzvrwrycwxrcismdhqapoojegggkocyrdtkzmiekhxoppctytvphjynrhtcvxcobxbcjjivtfjiwmduhzjokkbctweqtigwfhzorjlkpuuliaipbtfldinyetoybvugevwvhhhweejogrghllsouipabfafcxnhukcbtmxzshoyyufjhzadhrelweszbfgwpkzlwxkogyogutscvuhcllphshivnoteztpxsaoaacgxyaztuixhunrowzljqfqrahosheukhahhbiaxqzfmmwcjxountkevsvpbzjnilwpoermxrtlfroqoclexxisrdhvfsindffslyekrzwzqkpeocilatftymodgztjgybtyheqgcpwogdcjlnlesefgvimwbxcbzvaibspdjnrpqtyeilkcspknyylbwndvkffmzuriilxagyerjptbgeqgebiaqnvdubrtxibhvakcyotkfonmseszhczapxdlauexehhaireihxsplgdgmxfvaevrbadbwjbdrkfbbjjkgcztkcbwagtcnrtqryuqixtzhaakjlurnumzyovawrcjiwabuwretmdamfkxrgqgcdgbrdbnugzecbgyxxdqmisaqcyjkqrntxqmdrczxbebemcblftxplafnyoxqimkhcykwamvdsxjezkpgdpvopddptdfbprjustquhlazkjfluxrzopqdstulybnqvyknrchbphcarknnhhovweaqawdyxsqsqahkepluypwrzjegqtdoxfgzdkydeoxvrfhxusrujnmjzqrrlxglcmkiykldbiasnhrjbjekystzilrwkzhontwmehrfsrzfaqrbbxncphbzuuxeteshyrveamjsfiaharkcqxefghgceeixkdgkuboupxnwhnfigpkwnqdvzlydpidcljmflbccarbiegsmweklwngvygbqpescpeichmfidgsjmkvkofvkuehsmkkbocgejoiqcnafvuokelwuqsgkyoekaroptuvekfvmtxtqshcwsztkrzwrpabqrrhnlerxjojemcxel";
        String[] words = new String[]{"dhvf", "sind", "ffsl", "yekr", "zwzq", "kpeo", "cila", "tfty", "modg", "ztjg", "ybty", "heqg", "cpwo", "gdcj", "lnle", "sefg", "vimw", "bxcb"};
        LeetCode30 leetCode30 = new LeetCode30();
        System.out.println(leetCode30.findSubstring(s, words).toString());
    }


    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        int n = s.length();
        int m = words.length;
        int w = words[0].length();

        HashMap<String, Integer> map = new HashMap<>();
        for (String x : words)
            map.put(x, map.getOrDefault(x, 0) + 1);

        for (int i = 0; i < w; i++) {
            HashMap<String, Integer> temp = new HashMap<>();
            int count = 0;
            for (int j = i, k = i; j + w <= n; j = j + w) {
                String word = s.substring(j, j + w);
                temp.put(word, temp.getOrDefault(word, 0) + 1);
                count++;

                if (count == m) {
                    if (map.equals(temp)) {
                        ans.add(k);
                    }
                    String remove = s.substring(k, k + w);
                    temp.computeIfPresent(remove, (a, b) -> (b > 1) ? b - 1 : null);
                    count--;
                    k = k + w;
                }
            }//inner for loop
        }//outer for loop
        return ans;
    }//method
}

//Approach
//HashMap Usage:
//
//We need to find all starting indices of substrings in s that are a concatenation of each word in words exactly once and without any intervening characters.
//We use a HashMap (map) to store the frequency of each word in words.
//We use another HashMap (temp) to dynamically store the frequency of words in the current sliding window of s.
//Sliding Window Technique:
//
//We iterate through s using a sliding window approach, where the window size is equal to the total length of concatenated words (i.e., m * w where m is the number of words and w is the length of each word).
//For each position i from 0 to w - 1, we slide the window across s with a step size of w (length of each word).
//Within the sliding window, we extract words from s and update temp with their frequencies.
//If the number of words in the window equals m, we check if temp matches map.
//Comparison and Result:
//
//If temp matches map, it means the current window is a valid concatenation of all words in words.
//We then record the starting index k of this window.
//After recording the index, we slide the window to the right by removing the leftmost word from temp and updating the start position k.
//Time complexity: O(n⋅w).    n size of string and w size of one word
//Space complexity: O(m).   Here m is number of words