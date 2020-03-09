package com.htoyama.leetcode._617;

import com.htoyama.leetcode.utils.data.TreeNode;

import java.util.ArrayDeque;

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

  /**
   * 1 ms	42 MB
   *
   * TODO: Must review later
   */
  public TreeNode mergeTrees_loop(TreeNode t1, TreeNode t2) {
    if (t1 == null) return t2;
    if (t2 == null) return t1;

    ArrayDeque<TreeNode[]> queue = new ArrayDeque<>();
    queue.add(new TreeNode[]{t1, t2});

    while(!queue.isEmpty()) {
      TreeNode[] nodes = queue.poll();
      TreeNode c1 = nodes[0];
      TreeNode c2 = nodes[1];
      if (c2 == null) continue;

      c1.val += c2.val;

      if (c1.left == null) {
        c1.left = c2.left;
      } else {
        queue.add(new TreeNode[]{c1.left, c2.left});
      }
      if (c1.right == null) {
        c1.right = c2.right;
      } else {
        queue.add(new TreeNode[]{c1.right, c2.right});
      }
    }

    return t1;
  }
}
