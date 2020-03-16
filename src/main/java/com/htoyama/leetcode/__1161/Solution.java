package com.htoyama.leetcode.__1161;

import com.htoyama.leetcode.utils.BFS;
import com.htoyama.leetcode.utils.Level;
import com.htoyama.leetcode.utils.Tree;
import com.htoyama.leetcode.utils.data.TreeNode;

import java.util.ArrayDeque;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/
 */
@Level.Medium
@Tree
class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    assertThat(s.maxLevelSum(TreeNode.of(1, 7, 0, 7, -8, null, null))).isEqualTo(2);
  }

  /**
   * 7 ms	44.2 MB
   */
  @BFS
  public int maxLevelSum(TreeNode root) {
    if (root == null) return 0;

    ArrayDeque<TreeNode> queue = new ArrayDeque<>();
    queue.add(root);

    int curLevel = 1;
    int maxLevel = 1;
    int maxSum = Integer.MIN_VALUE;
    while (!queue.isEmpty()) {

      int levelSize = queue.size();
      int sum = 0;
      for (int i = 0; i < levelSize; i++) {
        TreeNode node = queue.poll();
        sum += node.val;
        if (node.left != null) queue.add(node.left);
        if (node.right != null) queue.add(node.right);
      }

      if (maxSum < sum) {
        maxSum = sum;
        maxLevel = curLevel;
      }

      curLevel++;
    }

    return maxLevel;
  }
}
