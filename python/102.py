from typing import List

from shared.TreeNode import TreeNode


class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        return recursive(root)
        # return iterative(root)


def recursive(root: TreeNode) -> List[List[int]]:
    # 32 ms	14.8 MB
    result = []

    def _rec(node: TreeNode, level: int):
        if not node:
            return
        if level <= len(result) - 1:
            result[level].append(node.val)
        else:
            result.append([node.val])

        _rec(node.left, level + 1)
        _rec(node.right, level + 1)

    _rec(root, 0)
    return result


def iterative(root: TreeNode) -> List[List[int]]:
    # 36 ms	14.1 MB
    if not root:
        return []

    from collections import deque
    nodes = deque([root])
    result = []
    while len(nodes) != 0:
        length = len(nodes)
        siblings = []
        for i in range(length):
            node = nodes.popleft()
            siblings.append(node.val)
            if node.left:
                nodes.append(node.left)
            if node.right:
                nodes.append(node.right)

        result.append(siblings)

    return result
