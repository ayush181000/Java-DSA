package Trie;

public class ImplementTrie {

}

class TrieNode {
    boolean isWord;
    TrieNode children[];

    TrieNode() {
        isWord = false;
        children = new TrieNode[26];
    }
}

class Trie {

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {

        TrieNode curr = root;
        char[] chArr = word.toCharArray();

        for (char c : chArr) {
            TrieNode next;
            if (curr.children[c - 'a'] == null) {
                next = new TrieNode();
                curr.children[c - 'a'] = next;
            } else {
                next = curr.children[c - 'a'];
            }
            curr = next;
        }

        curr.isWord = true;
    }

    public boolean search(String word) {

        TrieNode curr = root;
        char[] chArr = word.toCharArray();

        for (char c : chArr) {
            TrieNode next;
            if (curr.children[c - 'a'] == null)
                return false;

            next = curr.children[c - 'a'];
            curr = next;
        }

        if (curr.isWord)
            return true;

        return false;
    }

    public boolean startsWith(String prefix) {

        TrieNode curr = root;
        char[] chArr = prefix.toCharArray();

        for (char c : chArr) {
            TrieNode next;
            if (curr.children[c - 'a'] == null)
                return false;

            next = curr.children[c - 'a'];
            curr = next;
        }

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