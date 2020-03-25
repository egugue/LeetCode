package com.htoyama.leetcode._094;

import com.htoyama.leetcode.utils.Graph;
import com.htoyama.leetcode.utils.InOrderTraversal;
import com.htoyama.leetcode.utils.Level;
import com.htoyama.leetcode.utils.data.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

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

    assertThat(s.inorderTraversal(TreeNode.of(1, 2, 3, null, 5))).containsExactly(
      2, 5, 1, 3
    );

    assertThat(s.inorderTraversal(TreeNode.of(1, 2, 3, 4, 5, 6, 7, null, 9))).containsExactly(
      4, 9, 2, 5, 1, 6, 3, 7
    );
  }

  /**
   * 0 ms	37.7 MB
   *
   * TODO: Must try to solve later
   * The below approach is a little bit modified the official approach
   */
  public List<Integer> inorderTraversal(TreeNode root) {
    if (root == null) return Collections.emptyList();
    ArrayList<Integer> nodes = new ArrayList<>();

    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);

    boolean wasPrevNodeTraversed = false;
    while (!stack.isEmpty()) {
      TreeNode node = stack.peek();
      while (!wasPrevNodeTraversed && node.left != null) {
        stack.push(node.left);
        node = node.left;
      }
      stack.pop();
      nodes.add(node.val);

      if (node.right != null) {
        stack.push(node.right);
        wasPrevNodeTraversed = false;
      } else {
        wasPrevNodeTraversed = true;
      }
    }

    return nodes;
  }

  /**
   * 0 ms	38.1 MB
   */
  public List<Integer> inorderTraversal_(TreeNode root) {
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