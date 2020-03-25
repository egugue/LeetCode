package com.htoyama.leetcode._114;

import com.htoyama.leetcode.utils.Level;
import com.htoyama.leetcode.utils.PostOrderTraversal;
import com.htoyama.leetcode.utils.Tree;
import com.htoyama.leetcode.utils.data.TreeNode;

/**
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 */
@Level.Medium
@Tree
class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    TreeNode flatten;

    flatten = TreeNode.of(1, 2, 3, 4, 5);
    s.flatten(flatten);
    flatten = null;
  }

  /**
   * 0 ms	38.2 MB
   */
  @PostOrderTraversal
  public void flatten(TreeNode node) {
    if (node == null) return;

    flatten(node.right);
    flatten(node.left);

    TreeNode right = node.right;
    node.right = node.left;
    node.left = null;

    TreeNode cur = node;
    while (cur.right != null) cur = cur.right;
    cur.right = right;
  }
}