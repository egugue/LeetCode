from typing import List

from shared.TreeNode import TreeNode


class Solution:
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        return inorder_rec(root)


def inorder_rec(root: TreeNode) -> List[int]:
    # 28 ms	13.9 MB
    result = []

    def i(node: TreeNode):
        if node is None:
            return
        i(node.left)
        result.append(node.val)
        i(node.right)

    i(root)
    return result
