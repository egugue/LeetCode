package com.htoyama.leetcode._617;

import com.htoyama.leetcode.utils.data.TreeNode;

/**
 * https://leetcode.com/problems/merge-two-binary-trees/
 */
public class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    TreeNode a = s.mergeTrees(TreeNode.of(1, 3, 2, 5), TreeNode.of(2, 1, 3, null, 4, 7));
  }

  /**
   * 0 ms	41.6 MB
   */
  public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
    if (t1 == null) return t2;
    if (t2 == null) return t1;

    t1.val += t2.val;
    t1.left = mergeTrees(t1.left, t2.left);
    t1.right = mergeTrees(t1.right, t2.right);

    return t1;
  }
}
