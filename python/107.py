from typing import List

from shared.TreeNode import TreeNode


class Solution:
    def levelOrderBottom(self, root: TreeNode) -> List[List[int]]:
        return recursive(root)
        # return iterative(root)


def recursive(root: TreeNode) -> List[List[int]]:
    # 32 ms	14.7 MB
    if not root:
        return []
    result = []

    def _rec(node: TreeNode, level: int):
        if not node:
            return
        if len(result) < level + 1:
            result.insert(0, [node.val])
        else:
            result[-level - 1].append(node.val)

        _rec(node.left, level + 1)
        _rec(node.right, level + 1)

    _rec(root, 0)
    return result


def iterative(root: TreeNode) -> List[List[int]]:
    # 32 ms	14 MB
    if not root:
        return []
    result = []
    from collections import deque
    queue = deque([root])

    while len(queue) != 0:
        size = len(queue)
        siblings = []
        for _ in range(size):
            node = queue.popleft()
            siblings.append(node.val)
            if node.left:
                queue.append(node.left)
            if node.right:
                queue.append(node.right)
        result.insert(0, siblings)

    return result
