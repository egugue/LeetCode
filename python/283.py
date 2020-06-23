from typing import List


class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        return solution2(nums)
        # return solution1(nums)


def solution2(nums: List[int]):
    # 48 ms	15.1 MB
    length = len(nums)
    if length <= 1:
        return

    insert_position = 0
    for _, num in enumerate(nums):
        if num != 0:
            nums[insert_position] = num
            insert_position += 1

    for i in range(insert_position, length):
        nums[i] = 0


def solution1(nums: List[int]):
    # 40 ms	15 MB
    length = len(nums)
    if length <= 1:
        return

    first_zero = 0
    while first_zero < length and nums[first_zero] != 0:
        first_zero += 1

    zero_index = first_zero
    for i in range(first_zero + 1, length):
        if nums[i] != 0:
            nums[zero_index] = nums[i]
            zero_index += 1

    for i in range(zero_index, length):
        nums[i] = 0

    # print(nums)


if __name__ == '__main__':
    s = Solution()
    s.moveZeroes([0, 1, 0, 3, 12])
    s.moveZeroes([0, 0, 0, 3, 12])
    s.moveZeroes([9, 0, 0, 3, 12])
