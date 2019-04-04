package leetcode.data_structures;

public class Trie {

    private class TrieNode {
        public char chr;
        public boolean terminal;
        public TrieNode[] nodes;

        public TrieNode() {
            this.nodes = new TrieNode[26];
        }
    }

    private TrieNode[] nodes;

    public Trie() {
        this.nodes = new TrieNode[26];
    }

    public void insert(String word) {
        insert(new StringBuilder(word));
    }

    public void insert(StringBuilder word) {
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

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        return contains(word);
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode[] current = this.nodes;
        for (int index = 0; index < prefix.length(); index++) {
            int code = Character.codePointAt(prefix, index) - 97;
            if (current[code] == null) {
                return false;
            }

            TrieNode node = current[code];
            if (index == (prefix.length() - 1)) {
                return true;
            }
            current = node.nodes;
        }
        return false;
    }

    public boolean contains(String word) {
        return contains(new StringBuilder(word));
    }

    public boolean contains(StringBuilder word) {
        TrieNode[] current = this.nodes;
        for (int index = 0; index < word.length(); index++) {
            int code = Character.codePointAt(word, index) - 97;
            if (current[code] == null) {
                return false;
            }

            TrieNode node = current[code];
            if (index == (word.length() - 1)) {
                return node.terminal;
            }
            current = node.nodes;
        }
        return false;
    }

}
