from shared.TreeNode import TreeNode


class Solution:
    def flatten(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        iterative(root)
        # recursive(root)


def iterative(root: TreeNode) -> None:
    # 48 ms	14.7 MB
    if not root:
        return

    stack = [root]
    while len(stack) != 0:
        node = stack.pop()
        if node.right:
            stack.append(node.right)
        if node.left:
            stack.append(node.left)
        if len(stack) != 0:
            node.right = stack[-1]
        node.left = None


def recursive(root: TreeNode) -> None:
    # 40 ms	14.5 MB
    if not root:
        return

    recursive(root.left)
    recursive(root.right)

    if not root.left:
        return

    right = root.right
    root.right = root.left
    root.left = None

    end = root.right
    while end.right:
        end = end.right
    end.right = right
