package com.htoyama.leetcode.`107`

import com.htoyama.leetcode.utils.data.TreeNode

fun main() {
  Solution().apply {
    println(levelOrderBottom(TreeNode.of(3, 9, 20, null, null, 15, 7)))
  }
}

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
 *
 * TODO: Must review (2020/3/3)
 */
class Solution {

  fun levelOrderBottom(root: TreeNode?): List<List<Int>> {
    val result = ArrayList<ArrayList<Int>>()
    levelOrderBottom(root, result, 0)

    return result.map { it.toList() }
  }

  private fun levelOrderBottom(root: TreeNode?, result: ArrayList<ArrayList<Int>>, depth: Int) {
    if (root == null) return

    if (depth >= result.size) {
      result.add(0, ArrayList())
    }

    levelOrderBottom(root.left, result, depth + 1)
    levelOrderBottom(root.right, result, depth + 1)

    result[result.size - depth - 1].add(root.`val`)
  }
}