from shared.TreeNode import TreeNode


class Solution:
    def sumOfLeftLeaves(self, root: TreeNode) -> int:
        # 36 ms	14.4 MB
        if not root:
            return 0

        def dfs(node: TreeNode) -> int:
            left_sum = 0
            if node.left:
                if is_leaf(node.left):
                    left_sum += node.left.val
                else:
                    left_sum += dfs(node.left)
            if node.right:
                left_sum += dfs(node.right)
            return left_sum

        return dfs(root)


def is_leaf(node: TreeNode):
    return node and not node.left and not node.right
