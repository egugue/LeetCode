package com.htoyama.leetcode._129;

import com.htoyama.leetcode.utils.Level;
import com.htoyama.leetcode.utils.Tree;
import com.htoyama.leetcode.utils.data.TreeNode;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * https://leetcode.com/problems/sum-root-to-leaf-numbers/
 */
@Level.Medium
@Tree
class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    assertThat(s.sumNumbers(TreeNode.of(1, 2, 3))).isEqualTo(25);
    assertThat(s.sumNumbers(TreeNode.of(4, 9, 0, 5, 1))).isEqualTo(1026);
  }

  /**
   * 0 ms	37.1 MB
   */
  public int sumNumbers(TreeNode root) {
    if (root == null) return 0;
    return helper(root, 0);
  }

  private int helper(TreeNode node, int curSum) {
    curSum = curSum * 10 + node.val;

    if (node.left == null && node.right == null) {
      return curSum;
    }

    int sum = 0;
    if (node.left != null) {
      sum += helper(node.left, curSum);
    }
    if (node.right != null) {
      sum += helper(node.right, curSum);
    }
    return sum;
  }
}

