package com.htoyama.leetcode._094;

import com.htoyama.leetcode.utils.Graph;
import com.htoyama.leetcode.utils.InOrderTraversal;
import com.htoyama.leetcode.utils.Level;
import com.htoyama.leetcode.utils.data.TreeNode;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 */
@Level.Medium
@Graph
@InOrderTraversal
class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    assertThat(s.inorderTraversal(TreeNode.of(1, null, 2, null, null, 3))).containsExactly(
      1, 3, 2
    );
  }

  /**
   * 0 ms	38.1 MB
   */
  public List<Integer> inorderTraversal(TreeNode root) {
    ArrayList<Integer> nodes = new ArrayList<>();
    helper(root, nodes);
    return nodes;
  }

  private void helper(TreeNode root, List<Integer> nodes) {
    if (root == null) {
      return;
    }

    helper(root.left, nodes);
    nodes.add(root.val);
    helper(root.right, nodes);
  }
}