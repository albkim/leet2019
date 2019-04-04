/*
Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation
sequence(s) from beginWord to endWord, such that:
1.Only one letter can be changed at a time
2.Each transformed word must exist in the word list. Note that beginWord is not a transformed word.

Note:
•Return an empty list if there is no such transformation sequence.
•All words have the same length.
•All words contain only lowercase alphabetic characters.
•You may assume no duplicates in the word list.
•You may assume beginWord and endWord are non-empty and are not the same.

Example 1:
Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output:
[
  ["hit","hot","dot","dog","cog"],
  ["hit","hot","lot","log","cog"]
]


Example 2:
Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

Output: []

Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.


 */

package leetcode;

class WordLadderII {
    public java.util.List<java.util.List<String>> findLadders(String beginWord, String endWord, java.util.List<String> wordList) {
        java.util.List<java.util.List<String>> result = new java.util.ArrayList<>();

        if (((beginWord == null) && (endWord == null)) || ((beginWord.length() == 0) || (endWord.length() == 0))) {
            return result;
        }

        // construct a graph
        java.util.Map<String, java.util.List<String>> graph = new java.util.HashMap<>();

        // if we track visited node, we can make the minimal graph which reduces the amount of
        // detours. Similar to BFS.
        java.util.Set<String> unvisited = new java.util.HashSet<>();
        for (String word : wordList) {
            unvisited.add(word);
        }

        java.util.Queue<String> queue = new java.util.ArrayDeque<>();
        queue.add(beginWord);
        unvisited.add(beginWord);

        while(!queue.isEmpty()) {
            String current = queue.poll();
            if (!unvisited.contains(current)) {
                continue;
            }
            java.util.List<String> neighbors = new java.util.ArrayList<>();
            for (String relatedWord : unvisited) {
                if (current.equals(relatedWord)) {
                    continue;
                }
                if (isNeighbor(current, relatedWord)) {
                    neighbors.add(relatedWord);
                    queue.add(relatedWord);
                }
            }
            unvisited.remove(current);
            graph.put(current, neighbors);
        }

        java.util.List<String> sequence = new java.util.ArrayList<>();
        sequence.add(beginWord);
        dfs(result, beginWord, endWord, sequence, graph);

        // find min
        int minLength = Integer.MAX_VALUE;
        for (java.util.List<String> list : result) {
            minLength = Math.min(minLength, list.size());
        }

        for (int index = result.size() - 1; index >= 0; index--) {
            if (result.get(index).size() > minLength) {
                result.remove(index);
            }
        }

        return result;
    }

    private void dfs(java.util.List<java.util.List<String>> result, String beginWord, String endWord, java.util.List<String> sequence, java.util.Map<String, java.util.List<String>> graph) {
        if (result.size() > 0) {
            if (sequence.size() > result.get(result.size() - 1).size()) {
                return;
            }
        }

        if (beginWord.equals(endWord)) {
            java.util.List<String> newSequence = new java.util.ArrayList<>();
            for (String word : sequence) {
                newSequence.add(word);
            }
            result.add(newSequence);
            return;
        }

        for (String neighbor : graph.get(beginWord)) {
            if (sequence.contains(neighbor)) {
                continue;
            }

            sequence.add(neighbor);

            dfs(result, neighbor, endWord, sequence, graph);

            sequence.remove(neighbor);
        }
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
