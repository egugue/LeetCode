from typing import List


class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:
        return sets(nums)
        # return sort(nums)


def sets(nums: List[int]) -> bool:
    # 136 ms	19.2 MB
    if len(nums) <= 1:
        return False

    unique = set()
    for _, num in enumerate(nums):
        if num in unique:
            return True
        unique.add(num)
    return False


def sort(nums: List[int]) -> bool:
    # 124 ms	19.1 MB
    length = len(nums)
    if length <= 1:
        return False

    nums = sorted(nums)
    prev = nums[0]
    for i in range(1, length):
        if prev == nums[i]:
            return True
        prev = nums[i]
    return False
