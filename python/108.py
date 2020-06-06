from typing import List

from shared.TreeNode import TreeNode


class Solution:
    def sortedArrayToBST(self, nums: List[int]) -> TreeNode:
        return iterative(nums)
        # return recursive(nums)


def iterative(nums: List[int]) -> TreeNode:
    # 68 ms	15.8 MB
    if len(nums) == 0:
        return None

    root = TreeNode(nums[len(nums) // 2])
    stack = [(root, nums)]
    while len(stack) != 0:
        node, children = stack.pop()
        mid = len(children) // 2
        left = children[:mid]
        right = children[mid + 1:]
        if len(left) != 0:
            node.left = TreeNode(left[len(left) // 2])
            stack.append((node.left, left))
        if len(right) != 0:
            node.right = TreeNode(right[len(right) // 2])
            stack.append((node.right, right))

    return root


def recursive(nums: List[int]) -> TreeNode:
    # 76 ms	16.1 MB
    if len(nums) == 0:
        return None

    mid = len(nums) // 2
    root = TreeNode(nums[mid])
    root.left = recursive(nums[:mid])
    root.right = recursive(nums[mid + 1:])
    return root
