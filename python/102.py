from typing import List

from shared.TreeNode import TreeNode


class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
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
