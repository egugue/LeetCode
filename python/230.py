from collections import deque

from shared.TreeNode import TreeNode


class Solution:
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        # res, _ = recursive(root, k)
        # return res
        return iterative(root, k)


def iterative(root: TreeNode, k: int) -> int:
    # 52 ms	17.7 MB
    if not root:
        return -1

    stack = [root]
    is_traversed = False
    while len(stack) != 0:
        node = stack[-1]
        while node.left and not is_traversed:
            stack.append(node.left)
            node = node.left

        node = stack.pop()
        k -= 1
        if k == 0:
            return node.val

        if node.right:
            stack.append(node.right)
            is_traversed = False
        else:
            is_traversed = True

    return -1


def recursive(root: TreeNode, k: int) -> tuple:
    # 56 ms	17.7 MB
    if not root:
        return None, k

    left_result, k = recursive(root.left, k)
    if left_result is not None:
        return left_result, 0

    k -= 1
    if k == 0:
        return root.val, 0

    return recursive(root.right, k)
