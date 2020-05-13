from typing import List


class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        #  64 ms	14.5 MBdd
        if len(nums) == 0:
            return 0

        max_v = nums[0]
        sum_v = 0
        for _, num in enumerate(nums):
            sum_v += num
            max_v = max(max_v, sum_v)
            if sum_v <= 0:
                sum_v = 0

        return max_v


if __name__ == '__main__':
    s = Solution()
    print(s.maxSubArray([-2, 1, -3, 4, -1, 2, 1, -5, 4]))
    print(s.maxSubArray([-2, -3, -1, -5]))
