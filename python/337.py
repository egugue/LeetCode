from shared.TreeNode import TreeNode


class Solution:
    def rob(self, root: TreeNode) -> int:
        return recursive(root)


def recursive(root: TreeNode) -> int:
    # 52 ms	15.8 MB
    if not root:
        return 0

    from typing import Tuple
    def _rec(node: TreeNode) -> Tuple[int, int]:
        if not node.left and not node.right:
            return node.val, 0

        left_robbed, left_skipped = (0, 0) if not node.left else _rec(node.left)
        right_robbed, right_skipped = (0, 0) if not node.right else _rec(node.right)

        skipped = max(left_robbed, left_skipped) + max(right_robbed, right_skipped)
        return node.val + left_skipped + right_skipped, skipped

    robbed, skipped = _rec(root)
    return max(robbed, skipped)
