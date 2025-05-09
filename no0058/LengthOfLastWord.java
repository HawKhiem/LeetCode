package no0058;

import java.util.List;

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        List<String> words = List.of(s.split(" "));
        return words.get(words.size() - 1).length();
    }
}
