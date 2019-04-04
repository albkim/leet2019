/*
Given an array of words and a width maxWidth, format the text such that each line has exactly maxWidth
characters and is fully (left and right) justified.

You should pack your words in a greedy approach; that is, pack as many words as you can in each line.
Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.

Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line
do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

For the last line of text, it should be left justified and no extra space is inserted between words.

Note:
•A word is defined as a character sequence consisting of non-space characters only.
•Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
•The input array words contains at least one word.

Example 1:
Input:
words = ["This", "is", "an", "example", "of", "text", "justification."]
maxWidth = 16
Output:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]


Example 2:
Input:
words = ["What","must","be","acknowledgment","shall","be"]
maxWidth = 16
Output:
[
  "What   must   be",
  "acknowledgment  ",
  "shall be        "
]
Explanation: Note that the last line is "shall be    " instead of "shall     be",
             because the last line must be left-justified instead of fully-justified.
             Note that the second line is also left-justified becase it contains only one word.


Example 3:
Input:
words = ["Science","is","what","we","understand","well","enough","to","explain",
         "to","a","computer.","Art","is","everything","else","we","do"]
maxWidth = 20
Output:
[
  "Science  is  what we",
  "understand      well",
  "enough to explain to",
  "a  computer.  Art is",
  "everything  else  we",
  "do                  "
]


 */

package leetcode;

class TextJustification {
    public java.util.List<String> fullJustify(String[] words, int maxWidth) {
        java.util.List<String> result = new java.util.ArrayList<>();
        if ((words == null) || (words.length == 0)) {
            return result;
        }

        int length = 0;
        java.util.List<Integer> lineLengths = new java.util.ArrayList<>();
        java.util.List<Integer> breaks = new java.util.ArrayList<>();
        for (int index = 0; index < words.length; index++) {
            int lastIndex = (breaks.size() == 0) ? 0 : breaks.get(breaks.size() - 1);
            int wordLength = words[index].length();
            int spaceLength = index - lastIndex;
            int currentLength = length + spaceLength + wordLength;
            if (currentLength > maxWidth) {
                lineLengths.add(length);
                breaks.add(index);
                length = wordLength;
            } else {
                length += wordLength;
            }
        }

        // we are missing the last line...but since we need special handling, we will do it differently

        int lastIndex = 0;
        for (int lineIndex = 0; lineIndex < breaks.size(); lineIndex++) {
            int breakIndex = breaks.get(lineIndex);
            int lineLength = lineLengths.get(lineIndex);
            int wordCount = breakIndex - lastIndex;
            int spaceSize = (wordCount == 1) ? 0 : (maxWidth - lineLength) / (wordCount - 1);
            // we need to distribute left over spaces evenly...
            int spaceLeftCount = maxWidth - lineLength - (spaceSize * (wordCount - 1));
            StringBuilder line = new StringBuilder();
            for (int index = lastIndex; index < breakIndex; index++) {
                line.append(words[index]);
                int spaceCount = spaceSize;
                // there will be a case when there is just 1 word per line.
                if (wordCount == 1) {
                    spaceCount = spaceLeftCount;
                } else if ((index - lastIndex) < spaceLeftCount) {
                    spaceCount += 1;
                } else if ((index - lastIndex) == (wordCount - 1)) {
                    spaceCount = 0;
                }
                for (int spaces = 0; spaces < spaceCount; spaces++) {
                    line.append(' ');
                }
            }
            result.add(line.toString());
            lastIndex = breakIndex;
        }

        // handle the last line.
        int lineLength = 0;
        StringBuilder line = new StringBuilder();
        for (int index = lastIndex; index < words.length; index++) {
            if (index > lastIndex) {
                line.append(' ');
                lineLength++;
            }
            line.append(words[index]);
            lineLength += words[index].length();
        }
        for (int spaces = lineLength; spaces < maxWidth; spaces++) {
            line.append(' ');
        }
        result.add(line.toString());

        return result;
    }
}
