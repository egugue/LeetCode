package com.htoyama.leetcode._130;

import static org.assertj.core.api.Assertions.assertThat;

class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    char[][] board = {
      new char[]{'X', 'X', 'X', 'X'},
      new char[]{'X', 'O', 'O', 'X'},
      new char[]{'X', 'X', 'O', 'X'},
      new char[]{'X', 'O', 'X', 'X'}
    };
    s.solve(board);
    assertThat(board).containsExactly(
      new char[]{'X', 'X', 'X', 'X'},
      new char[]{'X', 'X', 'X', 'X'},
      new char[]{'X', 'X', 'X', 'X'},
      new char[]{'X', 'O', 'X', 'X'}
    );

    board = new char[][]{
      new char[]{'O', 'O', 'O', 'O', 'X', 'X'},
      new char[]{'O', 'O', 'O', 'O', 'O', 'O'},
      new char[]{'O', 'X', 'O', 'X', 'O', 'O'},
      new char[]{'O', 'X', 'O', 'O', 'X', 'O'},
      new char[]{'O', 'X', 'O', 'X', 'O', 'O'},
      new char[]{'O', 'X', 'O', 'O', 'O', 'O'}
    };
    s.solve(board);
    assertThat(board).containsExactly(
      new char[]{'O', 'O', 'O', 'O', 'X', 'X'},
      new char[]{'O', 'O', 'O', 'O', 'O', 'O'},
      new char[]{'O', 'X', 'O', 'X', 'O', 'O'},
      new char[]{'O', 'X', 'O', 'O', 'X', 'O'},
      new char[]{'O', 'X', 'O', 'X', 'O', 'O'},
      new char[]{'O', 'X', 'O', 'O', 'O', 'O'}
    );
  }

  /**
   * 2 ms	48.9 MB
   */
  public void solve(char[][] board) {
    if (board.length == 0 || board[0].length == 0) return;

    for (int i = 0; i < board.length; i++) {
      if (board[i][0] == 'O' ) markNotCapture(board, i, 0);
      if (board[i][board[0].length - 1] == 'O' ) markNotCapture(board, i, board[0].length - 1);
    }
    for (int j = 0; j < board[0].length; j++) {
      if (board[0][j] == 'O' ) markNotCapture(board, 0, j);
      if (board[board.length - 1][j] == 'O' ) markNotCapture(board, board.length - 1, j);
    }

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (board[i][j] == '*' ) board[i][j] = 'O';
        else if (board[i][j] == 'O' ) board[i][j] = 'X';
      }
    }
  }

  private static void markNotCapture(char[][] board, int i, int j) {
    if (i < 0 || board.length <= i) return;
    if (j < 0 || board[0].length  <= j) return;

    if (board[i][j] == 'O' ) board[i][j] = '*';

    if (i > 1 && board[i - 1][j] == 'O' ) {
      markNotCapture(board, i - 1, j);
    }
    if (i < board.length - 2 && board[i + 1][j] == 'O' ) {
      markNotCapture(board, i + 1, j);
    }

    if (j > 1 && board[i][j - 1] == 'O' ) {
      markNotCapture(board, i, j - 1);
    }
    if (j < board[0].length - 2 && board[i][j + 1] == 'O' ) {
      markNotCapture(board, i, j + 1);
    }
  }
}