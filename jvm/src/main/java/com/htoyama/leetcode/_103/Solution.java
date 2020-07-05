package com.htoyama.leetcode._103;

import com.htoyama.leetcode.utils.data.TreeNode;

import java.util.*;

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

  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    if (root == null) return new ArrayList<>();
    ArrayList<List<Integer>> order = new ArrayList<>();
//    iterative(root, order);
    recursive(root, order, 0);
    return order;
  }

  /**
   * 1 ms	38.5 MB
   */
  private static void iterative(TreeNode root, List<List<Integer>> order) {
    ArrayDeque<TreeNode> queue = new ArrayDeque<>();
    queue.add(root);
    boolean leftToRight = true;

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
  }

  /**
   * 1 ms	39.9 MB
   */
  private static void recursive(TreeNode root, List<List<Integer>> order, int level) {
    if (root == null) return;
    if (order.size() <= level) {
      order.add(new LinkedList<>());
    }

    List<Integer> nodes = order.get(level);
    if (level % 2 == 0) {
      nodes.add(root.val);
    } else {
      nodes.add(0, root.val);
    }

    recursive(root.left, order, level + 1);
    recursive(root.right, order, level + 1);
  }
}
