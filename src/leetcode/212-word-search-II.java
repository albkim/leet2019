/*
Given a 2D board and a list of words from the dictionary, find all words in the board.

Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are
those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

Example:
Input:
words = ["oath","pea","eat","rain"] and board =
[
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]

Output: ["eat","oath"]


Note:
 You may assume that all inputs are consist of lowercase letters a-z.

 */

package leetcode;

import java.util.*;

class WordSearchII {

    private class TrieNode {
        public char chr;
        public boolean terminal;
        public TrieNode[] nodes;

        public TrieNode() {
            this.nodes = new TrieNode[26];
        }
    }

    private TrieNode[] nodes;

    public List<String> findWords(char[][] board, String[] words) {
        this.nodes = new TrieNode[26];

        for (String word : words) {
            TrieNode[] current = this.nodes;
            for (int index = 0; index < word.length(); index++) {
                int code = Character.codePointAt(word, index) - 97;
                TrieNode node;
                if (current[code] == null) {
                    node = new TrieNode();
                    node.chr = word.charAt(index);
                    current[code] = node;
                } else {
                    node = current[code];
                }
                if (index == (word.length() - 1)) {
                    node.terminal = true;
                }
                current = node.nodes;
            }
        }

        Set<String> result = new HashSet<>();
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[0].length; column++) {
                char chr = board[row][column];
                int code = chr - 97;
                if (this.nodes[code] != null) {
                    boolean[][] visited = new boolean[board.length][board[0].length];
                    StringBuilder str = new StringBuilder();
                    find(result, board, visited, this.nodes, str, row, column);
                }
            }
        }

        List<String> uniqueResult = new ArrayList<>();
        for (String str : result) {
            uniqueResult.add(str);
        }
        return uniqueResult;
    }

    private void find(Set<String> result, char[][] board, boolean[][] visited, TrieNode[] nodes, StringBuilder str, int row, int column) {
        if ((row < 0) || (row == board.length) || (column < 0) || (column == board[0].length)) {
            return;
        }

        if (visited[row][column]) {
            return;
        }

        char chr = board[row][column];
        int code = chr - 97;
        TrieNode node = nodes[code];
        if (node == null) {
            return;
        }

        str.append(chr);
        visited[row][column] = true;

        if (node.terminal) {
            result.add(str.toString());
        }

        find(result, board, visited, node.nodes, str, row - 1, column);
        find(result, board, visited, node.nodes, str, row + 1, column);
        find(result, board, visited, node.nodes, str, row, column - 1);
        find(result, board, visited, node.nodes, str, row, column + 1);

        visited[row][column] = false;
        str.deleteCharAt(str.length() - 1);
    }
}
