from shared.TreeNode import TreeNode


class Solution:
    def hasPathSum(self, root: TreeNode, sum: int) -> bool:
        return recursive(root, sum)


def recursive(root: TreeNode, sum: int) -> bool:
    # 64 ms	15.4 MB
    if not root:
        return False

    def _rec(node: TreeNode, cur: int) -> bool:
        cur += node.val
        if not node.left and not node.right:
            return cur == sum

        if node.left and _rec(node.left, cur):
            return True
        if node.right and _rec(node.right, cur):
            return True
        return False

    return _rec(root, 0)
