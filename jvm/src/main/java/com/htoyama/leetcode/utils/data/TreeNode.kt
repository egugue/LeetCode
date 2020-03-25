package com.htoyama.leetcode.utils.data

import java.util.ArrayDeque

fun main() {
  val node = TreeNode.of(1, 2, 3, 4, 5, null, 7, 8)
  println(node.maxDepth())
  println(TreeNode.of(1).maxDepth())
  println(TreeNode.of(3, 9, 20, null, null, 15, 7).maxDepth())
  val node2 = TreeNode.of(3, null, 3, null, null, 3)
}

class TreeNode(@JvmField var `val`: Int) {

  @JvmField
  var left: TreeNode? = null

  @JvmField
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
    /**
     * TODO: the result from [1,2,null,3,null,4,null,5] was different from the official output which is shown on 102.
     *
     * https://leetcode.com/problems/binary-tree-level-order-traversal/
     */
    @JvmStatic
    fun of(vararg nums: Int?): TreeNode {
      if (nums.isEmpty()) throw IllegalArgumentException()

      val root = TreeNode(nums.first()!!)
      if (nums.size == 1) return root

      val queue = ArrayDeque<Element>().apply { add(Element.from(root)) }
      var depth = 1.0
      while (true) {
        val power = Math.pow(2.0, depth).toInt()
        val firstIndex = power - 1
        if (firstIndex >= nums.size) {
          break
        }

        val lasIndex = firstIndex + power - 1
        for (i in firstIndex..lasIndex step 2) {
          val e = queue.poll()
          if (e is Element.None) continue
          val parent = (e as Element.Value).treeNode

          val left = nums.getOrNull(i)?.let { TreeNode(it) }
          val right = nums.getOrNull(i + 1)?.let { TreeNode(it) }
          parent.left = left
          parent.right = right

          queue.add(Element.from(left))
          queue.add(Element.from(right))
        }

        depth++
      }

      return root
    }
  }
}

private sealed class Element {
  data class Value(val treeNode: TreeNode) : Element()
  object None : Element()

  companion object {
    fun from(node: TreeNode?) = if (node == null) None else Value(node)
  }
}
