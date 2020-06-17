from shared.TreeNode import TreeNode


class Solution:
    def invertTree(self, root: TreeNode) -> TreeNode:
        return recursive(root)


def recursive(root: TreeNode) -> TreeNode:
    # 24 ms	13.8 MB
    if not root:
        return root

    left = recursive(root.left)
    right = recursive(root.right)
    root.left = right
    root.right = left
    return root
