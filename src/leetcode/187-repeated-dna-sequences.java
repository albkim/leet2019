/*
All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG".
When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

Example:
Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"

Output: ["AAAAACCCCC", "CCCCCAAAAA"]


 */

package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> repeatCheck = new HashSet<>();

        // remember to use a set so we only have one instance of the repeated pattern
        Set<String> uniqueResult = new HashSet<>();

        for (int index = 0; index <= s.length() - 10; index++) {
            String pattern = s.substring(index, index + 10);

            if (repeatCheck.contains(pattern)) {
                uniqueResult.add(pattern);
            }

            repeatCheck.add(pattern);
        }

        List<String> result = new ArrayList<>();
        for (String pattern : uniqueResult) {
            result.add(pattern);
        }
        return result;
    }
}
