from shared.TreeNode import TreeNode


class Solution:
    def sumNumbers(self, root: TreeNode) -> int:
        return recursive(root)


def recursive(root: TreeNode) -> int:
    # 44 ms	13.9 MB
    if not root:
        return 0

    def _rec(node: TreeNode, cur: int) -> int:
        cur = cur * 10 + node.val

        if not node.left and not node.right:
            return cur
        if node.left and node.right:
            return _rec(node.left, cur) + _rec(node.right, cur)

        return _rec(node.left, cur) if node.left else _rec(node.right, cur)

    return _rec(root, 0)


if __name__ == '__main__':
    s = Solution()
    node = TreeNode(1)
    node.left = TreeNode(0)
    print(s.sumNumbers(node))
