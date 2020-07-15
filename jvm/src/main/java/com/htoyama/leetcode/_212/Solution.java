package com.htoyama.leetcode._212;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    assertThat(s.findWords(
      new char[][]{
        new char[]{'o', 'a', 'a', 'n'},
        new char[]{'e', 't', 'a', 'e'},
        new char[]{'i', 'h', 'k', 'r'},
        new char[]{'i', 'f', 'l', 'v'}
      },
      new String[]{"oath", "oathf", "pea", "eat", "rain"}
    )).containsExactlyInAnyOrder(
      "eat", "oath", "oathf"
    );
  }

  public List<String> findWords(char[][] board, String[] words) {
    TrieNode rootNode = new TrieNode();
    for (String word : words) {
      TrieNode node = rootNode;
      for (int i = 0; i < word.length(); i++) {
        char c = word.charAt(i);
        if (node.get(c) == null) node.put(c);
        node = node.get(c);
      }
      node.word = word;
    }

    // A board could have multiple passes which can find the same word.
    HashSet<String> foundWords = new HashSet<>();
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        dfs(board, i, j, rootNode, foundWords);
      }
    }
    return new ArrayList<>(foundWords);
  }

  private static void dfs(char[][] board, int i, int j, TrieNode trie, HashSet<String> foundWords) {
    if (i < 0 || board.length <= i) return;
    if (j < 0 || board[0].length <= j) return;
    char letter = board[i][j];
    if (letter == '#' || trie.get(letter) == null) return;

    board[i][j] = '#';

    trie = trie.get(letter);
    if (trie.word != null) {
      foundWords.add(trie.word);
    }

    dfs(board, i - 1, j, trie, foundWords);
    dfs(board, i + 1, j, trie, foundWords);
    dfs(board, i, j - 1, trie, foundWords);
    dfs(board, i, j + 1, trie, foundWords);

    board[i][j] = letter;
  }

  private static class TrieNode {
    private final TrieNode[] links = new TrieNode[26];
    String word;

    public TrieNode get(char ch) {
      return links[ch - 'a'];
    }

    public void put(char ch) {
      links[ch - 'a'] = new TrieNode();
    }
  }
}


