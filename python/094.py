from typing import List

from shared.TreeNode import TreeNode


class Solution:
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        return inorder_iterative(root)
        # return inorder_rec(root)


def inorder_iterative(root: TreeNode) -> List[int]:
    # 32 ms	13.8 MB
    if not root:
        return []

    result = []

    stack = [root]
    is_prev_node_traversed = False
    while len(stack) != 0:
        node = stack[-1]
        if not is_prev_node_traversed:
            while node.left:
                stack.append(node.left)
                node = node.left

        node = stack.pop()
        result.append(node.val)

        if node.right:
            stack.append(node.right)
            is_prev_node_traversed = False
        else:
            is_prev_node_traversed = True

    return result


def inorder_rec(root: TreeNode) -> List[int]:
    # 28 ms	13.9 MB
    result = []

    def i(node: TreeNode):
        if node is None:
            return
        i(node.left)
        result.append(node.val)
        i(node.right)

    i(root)
    return result


if __name__ == '__main__':
    s = Solution()
    node = TreeNode(1, right=TreeNode(2, left=TreeNode(3)))
    print(s.inorderTraversal(node))
