package com.htoyama.leetcode._105;

import com.htoyama.leetcode.utils.InOrderTraversal;
import com.htoyama.leetcode.utils.Level;
import com.htoyama.leetcode.utils.PreOrderTraversal;
import com.htoyama.leetcode.utils.Tree;
import com.htoyama.leetcode.utils.data.TreeNode;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
@Level.Medium
@Tree
@PreOrderTraversal
@InOrderTraversal
class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    TreeNode n;
    n = s.buildTree(new int[]{1, 2, 4, 5, 3, 6, 7, 8}, new int[]{4, 2, 5, 1, 3, 7, 6, 8});
    assertThat(n.toString()).isEqualTo("1->2->3->4->5->null->6->null->null->null->null->7->8");

    n = s.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
    assertThat(n.toString()).isEqualTo("3->9->20->null->null->15->7");
  }

  /**
   * 3 ms	39.3 MB
   */
  public TreeNode buildTree(int[] preorder, int[] inorder) {
    assert preorder.length == inorder.length;
    if (preorder.length == 0) return null;
    return helper(preorder, 0, inorder, 0, inorder.length - 1);
  }

  private TreeNode helper(int[] preorder, int preorderStart, int[] inorder, int inorderStart, int inorderEnd) {
    if (preorderStart >= preorder.length) return null;
    if (inorderStart >= inorder.length) return null;
    if (inorderStart > inorderEnd) return null;

    TreeNode root = new TreeNode(preorder[preorderStart]);
    int inorderRootIndex = findIndex(inorder, root.val);

    root.left = helper(
      preorder, preorderStart + 1,
      inorder, inorderStart, inorderRootIndex - 1
    );

    int leftRange = inorderRootIndex - inorderStart + 1;
    root.right = helper(
      preorder, preorderStart + leftRange,
      inorder, inorderRootIndex + 1, inorderEnd
    );

    return root;
  }

  private int findIndex(int[] array, int target) {
    for (int i = 0; i < array.length; i++) {
      if (array[i] == target) return i;
    }
    return -1;
  }
}