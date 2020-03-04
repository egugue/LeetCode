package com.htoyama.leetcode.`226`

import com.htoyama.leetcode.utils.data.TreeNode

fun main() {
  Solution().apply {
    invertTree(TreeNode.of(4, 2, 7, 1, 3, 6, 9))
    invertTree(TreeNode.of(4, 2, 7, null, 3, 6, null))
  }
}

/**
 * https://leetcode.com/problems/invert-binary-tree/
 */
class Solution {

  fun invertTree(root: TreeNode?): TreeNode? {
    if (root == null) return null

    root.left = invertTree(root.left)
    root.right = invertTree(root.right)

    val tmp = root.left
    root.left = root.right
    root.right = tmp

    return root
  }
}