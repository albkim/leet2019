/*
Given an array of strings, group anagrams together.

Example:
Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]

Note:
•All inputs will be in lowercase.
•The order of your output does not matter.

either sort each word and find the anagrams or use some sort of order independent hash
 */

package leetcode;

class GroupAnagrams {
    public java.util.List<java.util.List<String>> groupAnagrams(String[] strs) {
        java.util.Map<String, java.util.List<String>> lookup = new java.util.HashMap<>();
        if ((strs == null) || (strs.length == 0)) {
            return new java.util.ArrayList<>();
        }

        for (String str : strs) {
            char[] chrs = str.toCharArray();
            java.util.Arrays.sort(chrs);
            String sorted = new String(chrs);

            if (lookup.containsKey(sorted)) {
                lookup.get(sorted).add(str);
            } else {
                java.util.List<String> anagrams = new java.util.ArrayList<>();
                anagrams.add(str);
                lookup.put(sorted, anagrams);
            }
        }

        java.util.List<java.util.List<String>> result = new java.util.ArrayList<>();
        for (String key : lookup.keySet()) {
            result.add(lookup.get(key));
        }
        return result;
    }
}
