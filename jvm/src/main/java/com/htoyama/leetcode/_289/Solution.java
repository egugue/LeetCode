package com.htoyama.leetcode._289;

import static org.assertj.core.api.Assertions.assertThat;

class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    int[][] board = {
      new int[]{0, 1, 0},
      new int[]{0, 0, 1},
      new int[]{1, 1, 1},
      new int[]{0, 0, 0}
    };
    s.gameOfLife(board);
    assertThat(board).containsExactly(
      new int[]{0, 0, 0},
      new int[]{1, 0, 1},
      new int[]{0, 1, 1},
      new int[]{0, 1, 0}
    );
  }

  private static final int DEATH_TO_SURVIVOR = 2;
  private static final int SURVIVOR_TO_DEATH = -1;

  /**
   * 0 ms	37.5 MB
   */
  public void gameOfLife(int[][] board) {
    if (board.length == 0 || board[0].length == 0) return;

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        int survivors = countSurvivors(board, i, j);
        if (board[i][j] == 0) {
          if (survivors == 3) board[i][j] = DEATH_TO_SURVIVOR;
          continue;
        }

        if (survivors < 2) board[i][j] = SURVIVOR_TO_DEATH;
        else if (survivors == 2 || survivors == 3) board[i][j] = 1;
        else board[i][j] = SURVIVOR_TO_DEATH;
      }
    }

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (board[i][j] == SURVIVOR_TO_DEATH) board[i][j] = 0;
        else if (board[i][j] == DEATH_TO_SURVIVOR) board[i][j] = 1;
      }
    }
  }

  private static int countSurvivors(int[][] board, int i, int j) {
    int survivors = 0;
    for (int y = i - 1; y <= i + 1; y++) {
      if (y < 0 || board.length <= y) continue;

      for (int x = j - 1; x <= j + 1; x++) {
        if (x < 0 || board[0].length <= x) continue;
        if (y == i && x == j) continue;

        int value = board[y][x];
        if (value == 1 || value == SURVIVOR_TO_DEATH) survivors++;
      }
    }
    return survivors;
  }

}