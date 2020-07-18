from shared.TreeNode import TreeNode


class Solution:
    max_path = 0

    def diameterOfBinaryTree(self, root: TreeNode) -> int:
        # 80 ms	15.4 MB
        if not root:
            return 0
        self.max_path = 0
        self.bfs(root)
        return self.max_path - 1

    def bfs(self, node: TreeNode) -> int:
        if not node:
            return 0

        left = self.bfs(node.left)
        right = self.bfs(node.right)
        self.max_path = max(self.max_path, left + right + 1)

        return max(left, right) + 1
