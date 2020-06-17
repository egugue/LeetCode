from shared.TreeNode import TreeNode


class Solution:
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        res, _ = recursive(root, k)
        return res


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
