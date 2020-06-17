from shared.TreeNode import TreeNode


class Solution:
    def invertTree(self, root: TreeNode) -> TreeNode:
        return iterative(root)
        # return recursive(root)


def iterative(root: TreeNode) -> TreeNode:
    # 32 ms	13.7 MB
    if not root:
        return root

    from collections import deque
    queue = deque()
    queue.append(root)
    while len(queue) != 0:
        node = queue.pop()
        tmp = node.left
        node.left = node.right
        node.right = tmp

        if node.left:
            queue.append(node.left)
        if node.right:
            queue.append(node.right)

    return root


def recursive(root: TreeNode) -> TreeNode:
    # 24 ms	13.8 MB
    if not root:
        return root

    left = recursive(root.left)
    right = recursive(root.right)
    root.left = right
    root.right = left
    return root
