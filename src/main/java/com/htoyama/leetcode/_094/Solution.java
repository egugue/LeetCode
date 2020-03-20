package com.htoyama.leetcode._094;

import com.htoyama.leetcode.utils.Graph;
import com.htoyama.leetcode.utils.InOrderTraversal;
import com.htoyama.leetcode.utils.Level;
import com.htoyama.leetcode.utils.Tree;
import com.htoyama.leetcode.utils.data.TreeNode;

import java.util.*;

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
   * The key to this solution is `curr = node.right`.
   * If curr is null, then it can be said that a previous node was traversed
   */
  public List<Integer> inorderTraversal(TreeNode root) {
    if (root == null) return Collections.emptyList();
    ArrayList<Integer> nodes = new ArrayList<>();

    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);
    TreeNode curr = root;
    while(!stack.isEmpty()) {
      while(curr != null && curr.left != null) {
        stack.push(curr.left);
        curr = curr.left;
      }
      TreeNode node = stack.pop();
      nodes.add(node.val);
      if (node.right != null) stack.push(node.right);
      curr = node.right;
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