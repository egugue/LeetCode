from typing import List


class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:
        return sets(nums)


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
