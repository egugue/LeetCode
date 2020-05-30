package com.htoyama.leetcode._230;

import com.htoyama.leetcode.utils.data.TreeNode;

import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    assertThat(s.kthSmallest(TreeNode.of(3, 1, 4, null, 2), 1)).isEqualTo(1);
    assertThat(s.kthSmallest(TreeNode.of(5, 3, 7, 2, 4, 6, null, 1), 3)).isEqualTo(3);
    assertThat(s.kthSmallest(TreeNode.of(
      31, 30, 48, 3, null, 38, 49, 0, 16, 35, 47, null, null, null, 2, 15, 27, 33, 37, 39, null, 1, null, 5, null, 22, 28, 32, 34, 36, null, null, 43, null, null, 4, 11, 19, 23, null, 29, null, null, null, null, null, null, 40, 46, null, null, 7, 14, 17, 21, null, 26, null, null, null, 41, 44, null, 6, 10, 13, null, null, 18, 20, null, 25, null, null, 42, null, 45, null, null, 8, null, 12, null, null, null, null, null, 24, null, null, null, null, null, null, 9
    ), 1)).isEqualTo(0);
  }

  public int kthSmallest_loop(TreeNode root, int k) {
    if (root == null) return -1;
    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);

    while(!stack.isEmpty() && k > 0) {
      while(stack.peek().left != null) stack.push(stack.peek().left);
    }
    return 1;
  }

  /**
   * 0 ms	39.1 MB
   */
  public int kthSmallest(TreeNode root, int k) {
    Result result = inOrder(root, k, new Result());
    return result.kthSmallest;
  }

  private Result inOrder(TreeNode root, int k, Result result) {
    if (root == null) return result;

    result = inOrder(root.left, k, result);
    if (result.found) return result;

    if (++result.visitedCount == k) {
      result.found = true;
      result.kthSmallest = root.val;
      return result;
    }

    result = inOrder(root.right, k, result);
    return result;
  }

  static class Result{
    boolean found = false;
    int kthSmallest;
    int visitedCount;
  }
}