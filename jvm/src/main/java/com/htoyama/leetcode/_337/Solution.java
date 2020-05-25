package com.htoyama.leetcode._337;

import com.htoyama.leetcode.utils.data.TreeNode;

import static org.assertj.core.api.Assertions.assertThat;

class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    assertThat(s.rob(TreeNode.of(3, 2, 3, null, 3, null, 1))).isEqualTo(7);
    assertThat(s.rob(TreeNode.of(3, 4, 5, 1, 3, null, 1))).isEqualTo(9);
  }

  private static final int ROBBED = 0;
  private static final int SKIPPED = 1;

  /**
   * 0 ms	39.3 MB
   */
  public int rob(TreeNode root) {
    if (root == null) return 0;
    int[] result = helper(root);
    return Math.max(result[ROBBED], result[SKIPPED]);
  }

  private int[] helper(TreeNode root) {
    if (root == null) return new int[2];

    int[] left = helper(root.left);
    int[] right = helper(root.right);

    int[] r = new int[2];
    r[ROBBED] = root.val + left[SKIPPED] + right[SKIPPED];
    r[SKIPPED] = Math.max(left[ROBBED], left[SKIPPED]) + Math.max(right[ROBBED], right[SKIPPED]);
    return r;
  }
}