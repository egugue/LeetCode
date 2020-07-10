from shared.TreeNode import TreeNode


class Solution:
    def sumOfLeftLeaves(self, root: TreeNode) -> int:
        return iterative(root)
        # return recursive(root)


def is_leaf(node: TreeNode):
    return node and not node.left and not node.right


def iterative(root: TreeNode) -> int:
    # 68 ms	14.2 MB
    if not root:
        return 0

    stack = [root]
    left_sum = 0
    while len(stack) != 0:
        node = stack.pop()

        if node.left:
            if is_leaf(node.left):
                left_sum += node.left.val
            else:
                stack.append(node.left)
        if node.right:
            stack.append(node.right)

    return left_sum


def recursive(root: TreeNode) -> int:
    # 36 ms	14.4 MB
    if not root:
        return 0

    def dfs(node: TreeNode) -> int:
        left_sum = 0
        if node.left:
            if is_leaf(node.left):
                left_sum += node.left.val
            else:
                left_sum += dfs(node.left)
        if node.right:
            left_sum += dfs(node.right)
        return left_sum

    return dfs(root)
