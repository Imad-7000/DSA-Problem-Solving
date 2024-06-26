package Trie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AutoComplete {

class TrieNode {
    public char data;
    public TrieNode[] children;
    public boolean isEnd;

    TrieNode(char data) {
        this.data = data;
        children = new TrieNode[26];
        isEnd = false;
        for (int i = 0; i < 26; i++) {
            children[i] = null;
        }
    }
}

class Trie {
    private TrieNode root;

    Trie() {
        root = new TrieNode('\0');
    }

    public void insert(String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (current.children[index] == null) {
                current.children[index] = new TrieNode(ch);
            }
            current = current.children[index];
        }
        current.isEnd = true;
    }

    public TrieNode search(String prefix) {
        TrieNode current = root;
        for (char ch : prefix.toCharArray()) {
            int index = ch - 'a';
            if (current.children[index] == null) {
                return null;
            }
            current = current.children[index];
        }
        return current;
    }

    public void collectWords(TrieNode node, String prefix, List<String> words) {
        if (node.isEnd) {
            words.add(prefix);
        }
        for (int i = 0; i < 26; i++) {
            if (node.children[i] != null) {
                collectWords(node.children[i], prefix + node.children[i].data, words);
            }
        }
    }
}

class Solution {
  public List<String> autoComplete(String w, List<String> words) {
     Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        TrieNode prefixNode = trie.search(w);
        if (prefixNode == null) {
            return Collections.singletonList("-1");
        }

        List<String> possibleWords = new ArrayList<>();
        trie.collectWords(prefixNode, w, possibleWords);

        if (possibleWords.isEmpty()) {
            return Collections.singletonList("-1");
        }

        Collections.sort(possibleWords);
        return possibleWords;
}
}
}
