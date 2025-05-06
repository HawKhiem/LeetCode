package no0068;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int i = 0;
        int start = 0;
        int wordsLength = 0;
        int spaces = 0;
        List<String> result = new ArrayList<>();
        while (i < words.length) {
            /// last word should be left justified
            if (i == words.length - 1) {
                String last = buildString(words, i, i, 0, 1, 0, maxWidth - wordsLength);
                result.add(last);
                break;
            } else {
                wordsLength += words[i].length();
                if (wordsLength + words[i + 1].length() >= maxWidth) {
                    spaces = maxWidth - wordsLength;
                    int numberOfWords = i + 1;
                    int numberOfSpaces = numberOfWords - 1;
                    /// spaces can not be evenly distributed
                    if (spaces % numberOfSpaces != 0) {
                        /// n_l.l + n_r.r = spaces
                        /// n_l + n_r = numberOfSpaces
                    }
                    /// spaces can be evenly distributed
                    else {
                        int spaceLength = spaces / numberOfSpaces;
                        String temp = "";
                        if (numberOfSpaces == 1) {
                            temp = buildString(words, start, i, 1, 0, spaceLength, spaceLength);
                        } else {
                            temp = buildString(words, start, i, numberOfWords / 2, numberOfWords / 2, spaceLength, spaceLength);
                        }
                        result.add(temp);
                        start = i + 1;
                    }
                }
            }
            i++;

        }
        return result;
    }

    /// both inclusive
    private String buildString(String[] words, int start, int end, int numberOfLeftSlot, int numberOfRightSlots, int leftSpace, int rightSpace) {
        String result = "";
        String leftSpaceString = "";
        String rightSpaceString = "";
        for (int i = 0; i < leftSpace; i++) {
            leftSpaceString += " ";
        }

        for (int i = 0; i < rightSpace; i++) {
            rightSpaceString += " ";
        }
        for (int i = start; i <= end; i++) {
            result += words[i];
            if (numberOfLeftSlot > 0) {
                result += leftSpaceString;
                numberOfLeftSlot--;
            } else if (numberOfRightSlots > 0) {
                result += rightSpaceString;
                numberOfRightSlots--;
            }
        }
        return result;
    }
}
