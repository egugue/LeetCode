from shared.TreeNode import TreeNode


class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        return iterative(root)
        # return recursive(root, root)


def iterative(root: TreeNode) -> bool:
    # 40 ms	14 MB
    if root is None:
        return True

    from collections import deque
    queue = deque([root, root])
    while len(queue) != 0:
        node1 = queue.pop()
        node2 = queue.pop()
        if not node1 and not node2:
            continue
        if not node1 or not node2:
            return False
        if node1.val != node2.val:
            return False
        queue.append(node1.left)
        queue.append(node2.right)
        queue.append(node1.right)
        queue.append(node2.left)

    return True


def recursive(left: TreeNode, right: TreeNode) -> bool:
    # 32 ms	13.7 MB
    if not left or not right:
        return not left and not right
    if left.val != right.val:
        return False
    return recursive(left.left, right.right) and recursive(left.right, right.left)
