package com.htoyama.leetcode._112;

import com.htoyama.leetcode.utils.data.TreeNode;

class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(
      s.hasPathSum(TreeNode.of(5, 4, 8, 11, 13, 4, 7, 2, null, 1), 22));
  }

  /**
   * 0 ms	39.3 MB
   */
  public boolean hasPathSum(TreeNode root, int sum) {
    if (root == null) {
      return false;
    }

    int rest = sum - root.val;
    if (root.left == null && root.right == null) {
      return rest == 0;
    }

    if (root.left != null && hasPathSum(root.left, rest)) {
      return true;
    }
    if (root.right != null && hasPathSum(root.right, rest)) {
      return true;
    }

    return false;
  }
}
