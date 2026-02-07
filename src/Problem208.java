package src;

public class Problem208 {
    static class Trie {

        public Trie() {

        }

        public void insert(String word) {

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
        String word = "apple";
        System.out.println(trie.search(word));
    }
}
