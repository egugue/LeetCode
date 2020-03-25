package com.htoyama.leetcode._108;

import com.htoyama.leetcode.utils.data.TreeNode;

import java.util.ArrayDeque;

/**
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 */
class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    TreeNode treeNode = s.sortedArrayToBST_loop(new int[]{-30, -20, -10, -3, 0, 5, 9, 20, 30});
    treeNode = null;
  }

  /**
   * 0 ms	41.5 MB
   */
  public TreeNode sortedArrayToBST(int[] nums) {
    if (nums.length == 0) return null;
    return helper(nums, 0, nums.length - 1);
  }

  private TreeNode helper(int[] nums, int left, int right) {
    if (left > right) return null;
    int mid = (right - left) / 2 + left;

    TreeNode node = new TreeNode(nums[mid]);
    node.left = helper(nums, left, mid - 1);
    node.right = helper(nums, mid + 1, right);
    return node;
  }

  /**
   * 2 ms	41.5 MB
   */
  public TreeNode sortedArrayToBST_loop(int[] nums) {
    if (nums.length == 0) return null;

    ArrayDeque<Element> queue = new ArrayDeque<>();
    Element root = Element.from(nums, 0, nums.length - 1);
    queue.add(root);

    while (!queue.isEmpty()) {
      Element ele = queue.poll();
      TreeNode node = ele.node;
      int left = ele.left;
      int right = ele.right;
      int mid = (right - left) / 2 + left;

      Element leftE = Element.from(nums, left, mid - 1);
      if (leftE != null) {
        node.left = leftE.node;
        queue.add(leftE);
      }

      Element rightE = Element.from(nums, mid + 1, right);
      if (rightE != null) {
        node.right = rightE.node;
        queue.add(rightE);
      }
    }

    return root.node;
  }

  static class Element {
    final TreeNode node;
    final int left;
    final int right;

    private Element(TreeNode node, int left, int right) {
      this.node = node;
      this.left = left;
      this.right = right;
    }

    static Element from(int[] nums, int left, int right) {
      if (left > right) return null;
      int mid = (right - left) / 2 + left;
      return new Element(new TreeNode(nums[mid]), left, right);
    }
  }
}
