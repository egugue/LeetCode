package com.htoyama.leetcode._108;

import com.htoyama.leetcode.utils.data.TreeNode;

/**
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 */
class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    TreeNode treeNode = s.sortedArrayToBST(new int[]{-30, -20, -10, -3, 0, 5, 9, 20, 30});
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
}
