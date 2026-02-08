package src;

import java.util.ArrayList;
import java.util.List;

public class Problem208 {
    static class TrieNode {
        char val;
        TrieNode[] children = new TrieNode[26];
        boolean endOfWord = false;

        TrieNode(char val) {
            this.val = val;
        }
    }
    static class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode(' ');
        }

        public void insert(String word) {
            TrieNode cur = root;
            for (char c:word.toCharArray()) {
                int index = c - 'a';
                if (cur.children[index] == null) {
                    cur.children[index] = new TrieNode(c);
                }
                cur = cur.children[index];
            }
            cur.endOfWord = true;
        }

        public boolean search(String word) {
            return true;
        }

        public boolean startsWith(String prefix) {
            return true;
        }
    }

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

    public static void main(String[] args) {
        Problem208 obj = new Problem208();
        Trie trie = new Trie();
        String word1 = "apple";
        trie.insert(word1);
        String word2 = "april";
        trie.insert(word2);
    }
}
