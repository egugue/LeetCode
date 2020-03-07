package com.htoyama.leetcode._404;

import com.htoyama.leetcode.utils.data.TreeNode;

import java.util.ArrayDeque;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

  public static void main(String[] args) {
    Solution s = new Solution();
    assertThat(s.sumOfLeftLeaves(TreeNode.of(3, 9, 20, null, null, 15, 7))).isEqualTo(24);
    assertThat(s.sumOfLeftLeaves(TreeNode.of(1, 2, 3, 4, 5))).isEqualTo(4);
  }

  /**
   * Case of using loop and queue
   *
   * TODO: need to read the description carefully.
   * the sum of all left "leaves" is mentioned here.
   */
  public int sumOfLeftLeaves(TreeNode root) {
    if (root == null) return 0;

    ArrayDeque<TreeNode> queue = new ArrayDeque<>();
    queue.add(root);

    int sum = 0;
    while(!queue.isEmpty()) {

      TreeNode curr = queue.poll();
      if (curr.left != null) {
        if (curr.left.left == null && curr.left.right == null) { // is leaf node
          sum += curr.left.val;
        } else {
          queue.add(curr.left);
        }
      }
      if(curr.right != null) {
        queue.add(curr.right);
      }
    }

    return sum;
  }
}
