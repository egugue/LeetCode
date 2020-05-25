from typing import List


class Solution:
    def sortColors(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        16 ms	13.9 M
        """
        if len(nums) <= 1:
            return

        last_non_zero = 0
        for i in range(len(nums)):
            if nums[i] == 0:
                swap(nums, last_non_zero, i)
                last_non_zero += 1

        last_non_one = last_non_zero
        for i in range(last_non_zero, len(nums)):
            if nums[i] == 1:
                swap(nums, last_non_one, i)
                last_non_one += 1


def swap(nums: List[int], i: int, j: int):
    tmp = nums[i]
    nums[i] = nums[j]
    nums[j] = tmp


if __name__ == '__main__':
    s = Solution()
    l = [2, 0, 2, 1, 1, 0]
    l = [1, 1, 1, 1, 1]
    l = [0, 0, 0, 0]
    l = [2, 2, 2, 2, 2]
    s.sortColors(l)
    print(l)
