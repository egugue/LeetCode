from typing import List

from shared.TreeNode import TreeNode


class Solution:
    def sortedArrayToBST(self, nums: List[int]) -> TreeNode:
        return recursive(nums)


def recursive(nums: List[int]) -> TreeNode:
    # 76 ms	16.1 MB
    if len(nums) == 0:
        return None

    mid = len(nums) // 2
    root = TreeNode(nums[mid])
    root.left = recursive(nums[:mid])
    root.right = recursive(nums[mid + 1:])
    return root
