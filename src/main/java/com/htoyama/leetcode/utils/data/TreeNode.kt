package com.htoyama.leetcode.utils.data

import java.lang.IllegalArgumentException
import java.util.ArrayDeque

fun main() {
  val node = TreeNode.of(1, 2, 3, 4, 5, null, 7, 8)
  println(node.maxDepth())
  println(TreeNode.of(1).maxDepth())
  println(TreeNode.of(3,9,20,null,null,15,7).maxDepth())
}

class TreeNode(var `val`: Int) {
  var left: TreeNode? = null
  var right: TreeNode? = null

  fun maxDepth(): Int {
    if (left == null && right == null) return 1

    val leftDepth = left?.maxDepth() ?: 0
    val rightDepth = right?.maxDepth() ?: 0

    return 1 + Math.max(leftDepth, rightDepth)
  }

  companion object {

    /*
      [1,2,2,3,4,4,3]

            1
           / \
          2   3
         / \ / \
        4  5 6  7
     */
    fun of(vararg nums: Int?): TreeNode {
      if (nums.isEmpty()) throw IllegalArgumentException()

      val root = TreeNode(nums.first()!!)
      if (nums.size == 1) return root

      val queue = ArrayDeque<TreeNode>().apply { add(root) }
      var depth = 1.0
      while (true) {
        val power = Math.pow(2.0, depth).toInt()
        val firstIndex = power - 1
        if (firstIndex >= nums.size) {
          break
        }

        val lasIndex = firstIndex + power - 1
        for (i in firstIndex..lasIndex step 2) {
          val parent = queue.poll()
          val left = nums.getOrNull(i)?.let { TreeNode(it) }
          val right = nums.getOrNull(i + 1)?.let { TreeNode(it) }
          parent.left = left
          parent.right = right

          left?.let { queue.add(it) }
          right?.let { queue.add(it) }
        }

        depth++
      }

      return root
    }
  }
}
