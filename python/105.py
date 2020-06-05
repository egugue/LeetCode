from typing import List

from shared.TreeNode import TreeNode


class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        return recursive(preorder, inorder)


def recursive(preorder: List[int], inorder: List[int]):
    # 384 ms	87.6 MB
    if len(preorder) == 0 or len(inorder) == 0:
        return None
    root = TreeNode(preorder[0])
    left_size = find_index(inorder, root.val)
    root.left = recursive(preorder[1: 1 + left_size], inorder[:left_size])
    root.right = recursive(preorder[left_size + 1:], inorder[left_size + 1:])
    return root


def find_index(nums: List[int], target: int) -> int:
    for i, num in enumerate(nums):
        if num == target:
            return i
    return -1


if __name__ == '__main__':
    s = Solution()
    t = s.buildTree([3, 9, 20, 15, 7], [9, 3, 15, 20, 7])
    t
