package com.htoyama.leetcode._226

import com.htoyama.leetcode.utils.data.TreeNode
import java.util.LinkedList
import java.util.Queue

fun main() {
  Solution().apply {
    invertTree2(TreeNode.of(4, 2, 7, 1, 3, 6, 9))
    invertTree2(TreeNode.of(4, 2, 7, null, 3, 6, null))
  }
}

/**
 * https://leetcode.com/problems/invert-binary-tree/
 */
class Solution {

  /**
   * Case of using recursive call
   *
   * 148 ms	32.3 MB
   */
  fun invertTree(root: TreeNode?): TreeNode? {
    if (root == null) return null

    root.left = invertTree(root.left)
    root.right = invertTree(root.right)

    val tmp = root.left
    root.left = root.right
    root.right = tmp

    return root
  }

  /*
           4
         /   \
        2     7
       / \   / \
      1   3 6   9
   */
  /**
   * Case of using queue
   *
   * 144 ms	32.1 MB
   */
  fun invertTree2(root: TreeNode?): TreeNode? {
    if (root == null) return null
    val queue: Queue<TreeNode> = LinkedList()
    queue.add(root)

    while (!queue.isEmpty()) {
      val current = queue.poll()!!

      val temp = current.left
      current.left = current.right
      current.right = temp

      current.left?.let { queue.add(it) }
      current.right?.let { queue.add(it) }
    }
    return root
  }
}