from shared.TreeNode import TreeNode


class Solution:
    def hasPathSum(self, root: TreeNode, sum: int) -> bool:
        return iterative(root, sum)
        # return recursive(root, sum)


def iterative(root: TreeNode, sum: int) -> bool:
    # 40 ms	15.9 MB
    if not root:
        return False

    stack = [(root, 0)]
    while len(stack) != 0:
        node, cur = stack.pop()
        cur += node.val

        if not node.left and not node.right:
            if cur == sum:
                return True
            continue

        if node.left:
            stack.append((node.left, cur))
        if node.right:
            stack.append((node.right, cur))

    return False


def recursive(root: TreeNode, sum: int) -> bool:
    # 64 ms	15.4 MB
    if not root:
        return False

    def _rec(node: TreeNode, cur: int) -> bool:
        cur += node.val
        if not node.left and not node.right:
            return cur == sum

        if node.left and _rec(node.left, cur):
            return True
        if node.right and _rec(node.right, cur):
            return True
        return False

    return _rec(root, 0)
