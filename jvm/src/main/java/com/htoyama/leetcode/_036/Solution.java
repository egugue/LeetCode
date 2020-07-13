package com.htoyama.leetcode._036;

import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;

class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    assertThat(s.isValidSudoku(new char[][]{
      new char[]{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
      new char[]{'6', '.', '.', '1', '9', '5', '.', '.', '.'},
      new char[]{'.', '9', '8', '.', '.', '.', '.', '6', '.'},
      new char[]{'8', '.', '.', '.', '6', '.', '.', '.', '3'},
      new char[]{'4', '.', '.', '8', '.', '3', '.', '.', '1'},
      new char[]{'7', '.', '.', '.', '2', '.', '.', '.', '6'},
      new char[]{'.', '6', '.', '.', '.', '.', '2', '8', '.'},
      new char[]{'.', '.', '.', '4', '1', '9', '.', '.', '5'},
      new char[]{'.', '.', '.', '.', '8', '.', '.', '7', '9'}
    })).isTrue();

    assertThat(s.isValidSudoku(new char[][]{
      new char[]{'8', '3', '.', '.', '7', '.', '.', '.', '.'},
      new char[]{'6', '.', '.', '1', '9', '5', '.', '.', '.'},
      new char[]{'.', '9', '8', '.', '.', '.', '.', '6', '.'},
      new char[]{'8', '.', '.', '.', '6', '.', '.', '.', '3'},
      new char[]{'4', '.', '.', '8', '.', '3', '.', '.', '1'},
      new char[]{'7', '.', '.', '.', '2', '.', '.', '.', '6'},
      new char[]{'.', '6', '.', '.', '.', '.', '2', '8', '.'},
      new char[]{'.', '.', '.', '4', '1', '9', '.', '.', '5'},
      new char[]{'.', '.', '.', '.', '8', '.', '.', '7', '9'}
    })).isFalse();
  }

  /**
   * 5 ms	43.7 MB
   */
  public boolean isValidSudoku(char[][] board) {
    HashSet<Character> rows = new HashSet<>(9);
    HashSet<Character> columns = new HashSet<>(9);
    HashSet<Character> boxes = new HashSet<>(9);

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        char ch = board[i][j];
        if (ch != '.' && !rows.add(ch)) return false;

        ch = board[j][i];
        if (ch != '.' && !columns.add(ch)) return false;

        int boxI = (i / 3 * 3) + j / 3;
        int boxJ = j % 3 + (i % 3 * 3);
        ch = board[boxI][boxJ];
        if (ch != '.' && !boxes.add(ch)) return false;
      }

      rows.clear();
      columns.clear();
      boxes.clear();
    }

    return true;
  }
}