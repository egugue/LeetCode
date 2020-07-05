package com.htoyama.leetcode._103;

import com.htoyama.leetcode.utils.data.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    assertThat(s.zigzagLevelOrder(TreeNode.of(3, 9, 20, null, null, 15, 7))).containsExactly(
      Arrays.asList(3),
      Arrays.asList(20, 9),
      Arrays.asList(15, 7)
    );
    assertThat(s.zigzagLevelOrder(TreeNode.of(3, 9, 20, 1, 2, 15, 7))).containsExactly(
      Arrays.asList(3),
      Arrays.asList(20, 9),
      Arrays.asList(1, 2, 15, 7)
    );
  }

  /**
   * 1 ms	38.5 MB
   */
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    if (root == null) return new ArrayList<>();

    ArrayDeque<TreeNode> queue = new ArrayDeque<>();
    queue.add(root);
    boolean leftToRight = true;
    ArrayList<List<Integer>> order = new ArrayList<>();

    while (!queue.isEmpty()) {
      int size = queue.size();
      Integer[] nodes = new Integer[size];
      for (int i = 0; i < size; i++) {
        TreeNode node = queue.poll();
        if (leftToRight) {
          nodes[i] = node.val;
        } else {
          nodes[size - i - 1] = node.val;
        }
        if (node.left != null) queue.add(node.left);
        if (node.right != null) queue.add(node.right);
      }

      leftToRight = !leftToRight;
      order.add(Arrays.asList(nodes));
    }

    return order;
  }
}