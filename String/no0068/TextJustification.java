package String.no0068;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    // TODO: The idea is to first select the words that can be inserted in each line including a single space between every pair of words.
    //  After selecting the words for each line, we need to justify the line.
    //  To justify a line, the sum of length of included words with one space between them should be less than or equal to W.
    //  Also, if the current line is the last line of the text, then we need to append spaces to make the width of line equal to W.
    //  Otherwise, if the current line is not the last line then count the number of spaces needed to make the length of each line W and distribute the spaces evenly.

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < words.length) {
            List<String> currentLine = getWordsForLine(words, i, maxWidth);
            i += currentLine.size();

            if (i < words.length) {
                result.add(createJustifiedLine(currentLine, maxWidth));
            } else {
                result.add(createLastLine(currentLine, maxWidth));
            }
        }

        return result;
    }

    private List<String> getWordsForLine(String[] words, int start, int maxWidth) {
        List<String> line = new ArrayList<>();
        int currentWidth = 0;

        for (int i = start; i < words.length; i++) {
            if (currentWidth + words[i].length() + line.size() <= maxWidth) {
                line.add(words[i]);
                currentWidth += words[i].length();
            } else {
                break;
            }
        }

        return line;
    }

    private String createJustifiedLine(List<String> words, int maxWidth) {
        if (words.size() == 1) {
            return words.get(0) + " ".repeat(maxWidth - words.get(0).length());
        }

        int totalWordsLength = words.stream().mapToInt(String::length).sum();
        int spacesNeeded = maxWidth - totalWordsLength;
        int gaps = words.size() - 1;
        int spacesPerGap = spacesNeeded / gaps;
        int extraSpaces = spacesNeeded % gaps;

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < words.size() - 1; i++) {
            result.append(words.get(i));
            result.append(" ".repeat(spacesPerGap + (i < extraSpaces ? 1 : 0)));
        }
        result.append(words.get(words.size() - 1));

        return result.toString();
    }

    private String createLastLine(List<String> words, int maxWidth) {
        StringBuilder result = new StringBuilder(String.join(" ", words));
        result.append(" ".repeat(maxWidth - result.length()));
        return result.toString();
    }

    // TODO: a beautiful solution
    //     public List<String> fullJustify(String[] words, int maxWidth) {
    //        List<String> res = new ArrayList<>();
    //        int i = 0;
    //        while (i < words.length) {
    //            int lineLen = 0, j = i;
    //            while (j < words.length && lineLen + words[j].length() + (j - i) <= maxWidth) {
    //                lineLen += words[j].length();
    //                j++;
    //            }
    //            int numWords = j - i;
    //            StringBuilder line = new StringBuilder();
    //            if (j == words.length || numWords == 1) {
    //                for (int k = i; k < j; k++) {
    //                    line.append(words[k]);
    //                    if (k < j - 1) line.append(" ");
    //                }
    //                int remaining = maxWidth - line.length();
    //                while (remaining-- > 0) line.append(" ");
    //            } else {
    //                int totalSpaces = maxWidth - lineLen;
    //                int spaceBetween = totalSpaces / (numWords - 1);
    //                int extra = totalSpaces % (numWords - 1);
    //                for (int k = i; k < j - 1; k++) {
    //                    line.append(words[k]);
    //                    int spaces = spaceBetween + (k - i < extra ? 1 : 0);
    //                    for (int s = 0; s < spaces; s++) line.append(" ");
    //                }
    //                line.append(words[j - 1]);
    //            }
    //            res.add(line.toString());
    //            i = j;
    //        }
    //        return res;
    //    }

}
