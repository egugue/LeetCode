package com.htoyama.leetcode._100

import com.htoyama.leetcode.utils.data.TreeNode

fun main() {
  Solution().apply {
    println(isSameTree(TreeNode.of(1, 2, 3), TreeNode.of(1, 2, 3)))
    println(isSameTree(TreeNode.of(1, null, 3), TreeNode.of(1, null, 3)))
    println(isSameTree(TreeNode.of(1, 2), TreeNode.of(1, null)))
    println(isSameTree(TreeNode.of(1, 2), TreeNode.of(1, null, 2)))
    println(isSameTree(TreeNode.of(1, 2, 1), TreeNode.of(1, 1, 2)))
  }
}

class Solution {
  fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
    if (p == null && q == null) return true

    val isSameValue = p != null && q != null && p.`val` == q.`val`
    val isLeftSame = isSameTree(p?.left, q?.left)
    val isRightSame = isSameTree(p?.right, q?.right)
    return isSameValue && isLeftSame && isRightSame
  }
}