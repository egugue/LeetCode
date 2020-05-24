package com.htoyama.leetcode._098;

import com.htoyama.leetcode.utils.data.TreeNode;

import static org.assertj.core.api.Assertions.assertThat;

class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    assertThat(s.isValidBST(TreeNode.of(2, 1, 3))).isTrue();
    assertThat(s.isValidBST(TreeNode.of(5, 1, 4, null, null, 3, 6))).isFalse();
    assertThat(s.isValidBST(TreeNode.of(10, 5, 15, null, null, 6, 20))).isFalse();
    assertThat(s.isValidBST(TreeNode.of(1, 1))).isFalse();
    assertThat(s.isValidBST(TreeNode.of(2147483647))).isTrue();
  }

  /**
   * 0 ms	39.1 MB
   */
  public boolean isValidBST(TreeNode root) {
    return isValidBST(root, (long) Integer.MIN_VALUE - 1, (long) Integer.MAX_VALUE + 1);
  }

  public boolean isValidBST(TreeNode root, long minNode, long maxNode) {
    if (root == null) return true;
    if (root.val <= minNode || maxNode <= root.val) return false;

    if (!isValidBST(root.left, minNode, root.val)) return false;
    return isValidBST(root.right, root.val, maxNode);
  }
}