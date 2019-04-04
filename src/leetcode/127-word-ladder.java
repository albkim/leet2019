/*
Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation
sequence from beginWord to endWord, such that:
1.Only one letter can be changed at a time.
2.Each transformed word must exist in the word list. Note that beginWord is not a transformed word.

Note:
•Return 0 if there is no such transformation sequence.
•All words have the same length.
•All words contain only lowercase alphabetic characters.
•You may assume no duplicates in the word list.
•You may assume beginWord and endWord are non-empty and are not the same.

Example 1:
Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output: 5

Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.


Example 2:
Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

Output: 0

Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.

 */

package leetcode;

class WordLadder {
    public int ladderLength(String beginWord, String endWord, java.util.List<String> wordList) {
        if (((beginWord == null) && (endWord == null)) || ((beginWord.length() == 0) || (endWord.length() == 0))) {
            return 0;
        }

        // if we track visited node, we can make the minimal graph which reduces the amount of
        // detours. Similar to BFS.
        java.util.Set<String> unvisited = new java.util.HashSet<>();
        for (String word : wordList) {
            unvisited.add(word);
        }

        String sentinel = "";
        java.util.Queue<String> queue = new java.util.ArrayDeque<>();
        queue.add(beginWord);
        queue.add(sentinel);
        unvisited.add(beginWord);

        int level = 1;
        while(!queue.isEmpty()) {
            String current = queue.poll();
            if (current.equals(sentinel)) {
                if (queue.size() > 0) {
                    queue.add(sentinel);
                }
                level++;
                continue;
            }
            if (!unvisited.contains(current)) {
                continue;
            }
            java.util.List<String> neighbors = new java.util.ArrayList<>();
            for (String relatedWord : unvisited) {
                if (current.equals(relatedWord)) {
                    continue;
                }
                if (isNeighbor(current, relatedWord)) {
                    if (relatedWord.equals(endWord)) {
                        return level + 1;
                    }
                    neighbors.add(relatedWord);
                    queue.add(relatedWord);
                }
            }
            unvisited.remove(current);
        }
        return 0;
    }

    private boolean isNeighbor(String word, String relatedWord) {
        int difference = 0;

        for (int index = 0; index < word.length(); index++) {
            if (word.charAt(index) != relatedWord.charAt(index)) {
                difference++;
            }
        }

        return difference <= 1;
    }
}
