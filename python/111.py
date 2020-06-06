from shared.TreeNode import TreeNode


class Solution:
    def minDepth(self, root: TreeNode) -> int:
        return recursive(root)


def recursive(root: TreeNode) -> int:
    # 48 ms	15.7 MB
    if not root:
        return 0

    left = recursive(root.left)
    right = recursive(root.right)

    if left and right:
        return min(left, right) + 1

    # Description says
    #   "... the shortest path from the root node down to the nearest leaf node."
    #   "Note: A leaf is a node with no children."
    # Thus if left or right is 0, then the other node must be picked.
    return (left if left else right) + 1
