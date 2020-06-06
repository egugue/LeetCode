from shared.TreeNode import TreeNode


class Solution:
    def flatten(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        recursive(root)


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
