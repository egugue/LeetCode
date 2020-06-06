from typing import List

from shared.TreeNode import TreeNode


class Solution:
    def sortedArrayToBST(self, nums: List[int]) -> TreeNode:
        # return iterative(nums)
        return iterative2(nums)
        # return recursive(nums)


def iterative(nums: List[int]) -> TreeNode:
    # case of pushing a slice into the stack
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


def iterative2(nums: List[int]) -> TreeNode:
    # case of pushing start and end indices into the stack
    # 68 ms	16 MB
    if len(nums) == 0:
        return None

    root = TreeNode(nums[(len(nums) - 1) // 2])
    stack = [(root, 0, len(nums) - 1)]
    while len(stack) != 0:
        node, start, end = stack.pop()
        mid = (start + end) // 2
        leftStart = start
        leftEnd = mid - 1
        rightStart = mid + 1
        rightEnd = end
        if leftStart <= leftEnd:
            node.left = TreeNode(nums[(leftStart + leftEnd) // 2])
            stack.append((node.left, leftStart, leftEnd))
        if rightStart <= rightEnd:
            node.right = TreeNode(nums[(rightStart + rightEnd) // 2])
            stack.append((node.right, rightStart, rightEnd))

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


if __name__ == '__main__':
    s = Solution()
    bst = s.sortedArrayToBST([1, 3])
    print(bst)
