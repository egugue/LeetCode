from typing import List

from shared.TreeNode import TreeNode


class Solution:
    def binaryTreePaths(self, root: TreeNode) -> List[str]:
        if not root:
            return []
        return recursive(root)


def recursive(root: TreeNode) -> List[str]:
    # 60 ms	14 MB
    result = []

    def _rec(node: TreeNode, cur: List[str]):
        cur.append(str(node.val))

        if not node.left and not node.right:
            result.append("->".join(cur))
            cur.pop()
            return

        if node.left:
            _rec(node.left, cur)
        if node.right:
            _rec(node.right, cur)
        cur.pop()

    _rec(root, [])
    return result


if __name__ == '__main__':
    s = Solution()
    root = TreeNode(1)
    root.left = TreeNode(2)
    print(s.binaryTreePaths(root))
