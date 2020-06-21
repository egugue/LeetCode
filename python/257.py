from typing import List

from shared.TreeNode import TreeNode


class Solution:
    def binaryTreePaths(self, root: TreeNode) -> List[str]:
        if not root:
            return []
        return iterative(root)
        # return recursive(root)


def iterative(root: TreeNode) -> List[str]:
    # 32 ms	13.8 MB
    result = []
    stack = [(root, str(root.val))]
    while len(stack) != 0:
        node, path = stack.pop()
        if not node.left and not node.right:
            result.append(path)

        path += "->"
        if node.left:
            stack.append(
                (node.left, path + str(node.left.val))
            )
        if node.right:
            stack.append(
                (node.right, path + str(node.right.val))
            )

    return result


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
