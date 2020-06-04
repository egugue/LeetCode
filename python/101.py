from shared.TreeNode import TreeNode


class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        return iterative2(root)
        # return iterative(root)
        # return recursive(root, root)


def iterative2(root: TreeNode) -> bool:
    # 36 ms	13.9 MB
    if root is None:
        return True
    nodes = [root]

    while len(nodes) != 0:
        length = len(nodes)
        for i in range(length // 2):
            node1 = nodes[i]
            node2 = nodes[-i - 1]
            if not node1 and not node2:
                continue
            if not node1 or not node2:
                return False
            if node1.val != node2.val:
                return False

        for i in range(length):
            node = nodes[0]
            del nodes[0]
            if node:
                nodes.append(node.left)
                nodes.append(node.right)

    return True


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


if __name__ == '__main__':
    a = [1, 2, 3]
    print(a[0])
    print(a[-0])
