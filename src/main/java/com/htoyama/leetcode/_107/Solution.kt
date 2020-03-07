package com.htoyama.leetcode._107

import com.htoyama.leetcode.utils.data.TreeNode
import java.util.ArrayDeque

fun main() {
  Solution().apply {
    println(levelOrderBottom(TreeNode.of(3, 9, 20, null, null, 15, 7)))

    println(levelOrderBottom_loop(TreeNode.of(3, 9, 20, null, null, 15, 7)))
  }
}

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
 *
 * TODO: Must review (2020/3/3)
 */
class Solution {

  /**
   * 208 ms	36.1 MB
   */
  fun levelOrderBottom_loop(root: TreeNode?): List<List<Int>> {
    root ?: return emptyList()
    val queue = ArrayDeque<TreeNode>()
    queue.add(root)

    val result = ArrayList<List<Int>>()
    while(queue.isNotEmpty()) {

      val list = ArrayList<Int>(queue.size)
      for (i in 0 until queue.size) {
        val curr = queue.poll()
        list.add(curr.`val`)
        curr.left?.let { queue.add(it) }
        curr.right?.let { queue.add(it) }
      }

      result.add(0, list)
    }

    return result
  }

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