package com.htoyama.leetcode._111;

import com.htoyama.leetcode.utils.data.TreeNode;

/**
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/
 *
 * TODO: try to solve using loop
 */
class Solution {

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.minDepth(TreeNode.of(3)));
    System.out.println(s.minDepth(TreeNode.of(3, 2)));
    System.out.println(s.minDepth(TreeNode.of(3, null, 3, null, null, 3)));
    System.out.println(s.minDepth(TreeNode.of(3, 2, 3, null, null, 3)));
    System.out.println(s.minDepth(TreeNode.of(3, 9, 20, null, null, 15, 7)));
  }

  /**
   * 0 ms	40 MB
   */
  public int minDepth(TreeNode root) {
    if (root == null) return 0;

    int leftMinDepth = minDepth(root.left);
    int rightMinDepth = minDepth(root.right);

    if (leftMinDepth == 0 || rightMinDepth == 0) {
      return 1 + Math.max(leftMinDepth, rightMinDepth);
    }

    return 1 + Math.min(leftMinDepth, rightMinDepth);
  }
}
