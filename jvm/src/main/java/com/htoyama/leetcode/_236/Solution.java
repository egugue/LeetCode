package com.htoyama.leetcode._236;

import com.htoyama.leetcode.utils.data.TreeNode;

import static org.assertj.core.api.Assertions.assertThat;

class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    TreeNode root = TreeNode.of(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4);
    assertThat(s.lowestCommonAncestor(root, root.left, root.right)).isEqualTo(root);
    assertThat(s.lowestCommonAncestor(
      root,
      root.left,
      root.left.right.right
    )).isEqualTo(root.left);
  }

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (p == q) return p;
    return helper(root, p, q);
  }

  /**
   * 5 ms	41.7 MB
   */
  private TreeNode helper(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null || root == p || root == q) return root;
    TreeNode left = helper(root.left, p, q);
    TreeNode right = helper(root.right, p, q);
    if (left != null && right != null) return root;
    return left == null ? right : left;
  }

}