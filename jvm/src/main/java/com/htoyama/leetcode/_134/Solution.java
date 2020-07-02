package com.htoyama.leetcode._134;

import static org.assertj.core.api.Assertions.assertThat;

class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    assertThat(s.canCompleteCircuit(
      new int[]{1, 2, 3, 4, 5},
      new int[]{3, 4, 5, 1, 2})
    ).isEqualTo(3);
  }

  /**
   * 0 ms	40.9 MB
   */
  public int canCompleteCircuit(int[] gas, int[] cost) {
    if (gas.length != cost.length || gas.length == 0) return -1;

    int availableGas = 0;
    int debt = 0;
    int start = 0;
    for (int i = 0; i < gas.length; i++) {
      availableGas += gas[i] - cost[i];
      if (availableGas < 0) {
        debt += availableGas;
        availableGas = 0;
        start = i + 1;
      }
    }

    return debt + availableGas >= 0 ? start : -1;
  }
}