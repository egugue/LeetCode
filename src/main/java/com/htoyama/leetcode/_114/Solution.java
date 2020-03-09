package com.htoyama.leetcode._114;

import com.htoyama.leetcode.utils.data.TreeNode;

/**
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 *
 * TODO: try to solve it using loop
 */
public class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.maxDepth(TreeNode.of(3)));
    System.out.println(s.maxDepth(TreeNode.of(3, 2)));
    System.out.println(s.maxDepth(TreeNode.of(3, 2, null)));
    System.out.println(s.maxDepth(TreeNode.of(3, 9, 20, null, null, 15, 7)));
  }

  /**
   * 0 ms	39.2 MB
   */
  public int maxDepth(TreeNode root) {
    if (root == null) return 0;
    int leftMaxDepth = maxDepth(root.left);
    int rightMaxDepth = maxDepth(root.right);
    return 1 + Math.max(leftMaxDepth, rightMaxDepth);
  }
}
