from typing import List


class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        # 604 ms	21.5 MB
        length = len(nums)
        for i in range(length):
            index = abs(nums[i]) - 1
            if nums[index] > 0:
                nums[index] = -nums[index]

        disappeared = []
        for i in range(length):
            not_shown = nums[i] > 0
            if not_shown:
                disappeared.append(i + 1)

        return disappeared


if __name__ == '__main__':
    s = Solution()
    print(s.findDisappearedNumbers([4, 3, 2, 7, 8, 2, 3, 1]))
