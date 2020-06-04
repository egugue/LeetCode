package com.htoyama.leetcode._543;

import com.htoyama.leetcode.utils.data.TreeNode;

import static org.assertj.core.api.Assertions.assertThat;

class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    assertThat(s.diameterOfBinaryTree(TreeNode.of(1, 2, 3, 4, 5))).isEqualTo(3);
  }

  /**
   * 0 ms	39.7 MB
   */
  public int diameterOfBinaryTree(TreeNode root) {
    if (root ==null) return 0;
    maxLength = 0;
    length(root);
    return maxLength - 1;
  }

  private int maxLength = 0;

  private int length(TreeNode root) {
    if (root == null) return 0;
    int left = length(root.left);
    int right = length(root.right);
    // Memo: store a value to the field instead of returning a tuple
    maxLength = Math.max(maxLength, left + right + 1);
    return Math.max(left, right) + 1;
  }
}