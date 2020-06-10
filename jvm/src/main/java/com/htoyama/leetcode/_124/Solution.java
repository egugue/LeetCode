package com.htoyama.leetcode._124;

import com.htoyama.leetcode.utils.data.TreeNode;

import static org.assertj.core.api.Assertions.assertThat;

class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    assertThat(s.maxPathSum(TreeNode.of(1, 2, 3))).isEqualTo(6);
    assertThat(s.maxPathSum(TreeNode.of(-10, 9, 20, null, null, 15, 7))).isEqualTo(42);
    assertThat(s.maxPathSum(TreeNode.of(2, -1))).isEqualTo(2);
//    assertThat(s.maxPathSum(TreeNode.of(
//      5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1
//    ))).isEqualTo(48);

    assertThat(s.maxPathSum(TreeNode.of(
      8, 9, -6, null, null, 5, 9
    ))).isEqualTo(20);
  }

  public int maxPathSum(TreeNode root) {
    maxSum = Integer.MIN_VALUE;
    recursive(root);
    return maxSum;
  }

  private int maxSum = Integer.MIN_VALUE;

  /**
   * 1 ms	41.8 MB
   */
  private int recursive(TreeNode root) {
    if (root == null) return 0;

    int left = Math.max(0, recursive(root.left));
    int right = Math.max(0, recursive(root.right));

    maxSum = Math.max(maxSum, root.val + left + right);
    return root.val + Math.max(left, right);
  }
}