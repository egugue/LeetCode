package com.htoyama.leetcode._102;

import com.htoyama.leetcode.utils.data.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 */
class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.levelOrder(TreeNode.of(3, 9, 20, null, null, 15, 7)));
  }

  /**
   * 1 ms	39.3 MB
   */
  public List<List<Integer>> levelOrder(TreeNode root) {
    if (root == null) return Collections.emptyList();

    List<List<Integer>> result = new ArrayList<>();
    ArrayDeque<TreeNode> queue = new ArrayDeque<>();
    queue.add(root);

    while (!queue.isEmpty()) {
      int size = queue.size();
      List<Integer> currContainer = new ArrayList<>(size);
      result.add(currContainer);

      for (int i = 0; i < size; i++) {
        TreeNode node = queue.poll();
        if (node.left != null) queue.add(node.left);
        if (node.right != null) queue.add(node.right);
        currContainer.add(node.val);
      }
    }

    return result;
  }
}
