package com.htoyama.leetcode._257

import com.htoyama.leetcode.utils.data.TreeNode
import com.htoyama.leetcode.utils.shouldContainsOnly
import java.lang.StringBuilder

fun main() {
  Solution().apply {
    binaryTreePaths(TreeNode.of(1, 2, 3, null, 5)) shouldContainsOnly arrayOf("1->2->5", "1->3")
    binaryTreePaths(TreeNode.of(1, 2, 3, 4, 5)) shouldContainsOnly arrayOf("1->2->5", "1->2->4", "1->3")
    binaryTreePaths(TreeNode.of(1, 2, 3, null, null, 4)) shouldContainsOnly arrayOf("1->2", "1->3->4")
  }
}

/**
 * https://leetcode.com/problems/binary-tree-paths/
 */
class Solution {

  /**
   * TODO: Must review later to reduce runtime
   */
  fun binaryTreePaths(root: TreeNode?): List<String> {
    val list = filePath(root)
    return list.map { it.toString() }
  }

  private fun filePath(root: TreeNode?): List<StringBuilder> {
    if (root == null) return emptyList()
    if (root.left == null && root.right == null) {
      return listOf(StringBuilder("${root.`val`}"))
    }

    val list = filePath(root.left) + filePath(root.right)
    list.forEach {
      it.insert(0, "${root.`val`}->") }
    return list
  }
}