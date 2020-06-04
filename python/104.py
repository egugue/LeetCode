from shared.TreeNode import TreeNode


class Solution:
    def maxDepth(self, root: TreeNode) -> int:
        # 44 ms	15.3 MB
        if not root:
            return 0
        left = self.maxDepth(root.left)
        right = self.maxDepth(root.right)
        return max(left, right) + 1
