package com.htoyama.leetcode._208;

import static org.assertj.core.api.Assertions.assertThat;

class Main {
  public static void main(String[] args) {
    Trie trie = new Trie();

    trie.insert("apple");
    assertThat(trie.search("apple")).isTrue();   // returns true
    assertThat(trie.search("app")).isFalse();     // returns false
    assertThat(trie.startsWith("app")).isTrue(); // returns true
    trie.insert("app");
    assertThat(trie.search("app")).isTrue();     // returns true
  }
}

/**
 * 31 ms	48.5 MB
 */
class Trie {

  private static class Node {
    private final Node[] links = new Node[26];
    boolean isEnd;

    public boolean containsKey(char ch) {
      return links[ch - 'a'] != null;
    }

    public Node get(char ch) {
      return links[ch - 'a'];
    }

    public void put(char ch) {
      links[ch - 'a'] = new Node();
    }
  }

  private final Node root = new Node();

  /**
   * Initialize your data structure here.
   */
  public Trie() {
  }

  /**
   * Inserts a word into the trie.
   */
  public void insert(String word) {
    Node node = root;
    for (int i = 0; i < word.length(); i++) {
      char ch = word.charAt(i);
      if (!node.containsKey(ch)) {
        node.put(ch);
      }
      node = node.get(ch);
    }
    node.isEnd = true;
  }

  /**
   * Returns if the word is in the trie.
   */
  public boolean search(String word) {
    Node node = find(word);
    return node != null && node.isEnd;
  }

  /**
   * Returns if there is any word in the trie that starts with the given prefix.
   */
  public boolean startsWith(String prefix) {
    return find(prefix) != null;
  }

  private Node find(String word) {
    Node node = root;
    for (int i = 0; i < word.length(); i++) {
      char ch = word.charAt(i);
      if (!node.containsKey(ch)) return null;
      node = node.get(ch);
    }
    return node;
  }
}
