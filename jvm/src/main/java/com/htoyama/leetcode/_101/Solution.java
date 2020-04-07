package com.htoyama.leetcode._101;

import com.htoyama.leetcode.utils.Level;
import com.htoyama.leetcode.utils.Tree;
import com.htoyama.leetcode.utils.data.TreeNode;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * https://leetcode.com/problems/symmetric-tree/
 */
@Level.Medium
@Tree
class Solution {

  public static void main(String[] args) {
    Solution s = new Solution();
    assertThat(s.isSymmetric(TreeNode.of(1, 2, 2, 3, 4, 4, 3))).isTrue();
    assertThat(s.isSymmetric(TreeNode.of(1, 2, 2, null, 3, null, 3))).isFalse();
  }

  /**
   * 0 ms	37.9 MB
   */
  public boolean isSymmetric(TreeNode root) {
    return isSymmetric(root, root);
  }

  private boolean isSymmetric(TreeNode n1, TreeNode n2) {
    if (n1 == null && n2 == null) return true;
    if (n1 == null || n2 == null) return false;
    if (n1.val != n2.val) return false;

    if (!isSymmetric(n1.left, n2.right)) return false;
    if (!isSymmetric(n1.right, n2.left)) return false;
    return true;
  }
}