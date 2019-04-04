/*
Design a data structure that supports the following two operations:
void addWord(word)
bool search(word)


search(word) can search a literal word or a regular expression string containing only letters a-z or .. A .
means it can represent any one letter.

Example:
addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true


Note:
 You may assume that all words are consist of lowercase letters a-z.

 */

package leetcode;

import leetcode.data_structures.Trie;

class AddAndSearchWordDataStructureDesign {

    private class TrieNode {
        public char chr;
        public boolean terminal;
        public TrieNode[] nodes;

        public TrieNode() {
            this.nodes = new TrieNode[27];
        }
    }

    private TrieNode[] nodes;

    /** Initialize your data structure here. */
    public AddAndSearchWordDataStructureDesign() {
        this.nodes = new TrieNode[26];
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
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

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return search(word, this.nodes, 0);
    }

    private boolean search(String word, TrieNode[] current, int index) {
        char chr = word.charAt(index);
        if (chr == '.') {
            for (TrieNode node : current) {
                if (node != null) {
                    if (index == (word.length() - 1)) {
                        if (node.terminal) {
                            return true;
                        }
                    } else if (search(word, node.nodes, index + 1)) {
                        return true;
                    }
                }
            }
            return false;
        } else {
            int code = Character.codePointAt(word, index) - 97;
            if (current[code] == null) {
                return false;
            }

            TrieNode node = current[code];
            if (index == (word.length() - 1)) {
                return node.terminal;
            }
            return search(word, node.nodes, index + 1);
        }
    }

}
