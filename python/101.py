from shared.TreeNode import TreeNode


class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        def isSame(left: TreeNode, right: TreeNode) -> bool:
            if not left or not right:
                return not left and not right
            if left.val != right.val:
                return False
            return isSame(left.left, right.right) and isSame(left.right, right.left)

        return isSame(root, root)
