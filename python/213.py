from typing import List


class Solution:
    def rob(self, nums: List[int]) -> int:
        # 28 ms	13.8 MB
        length = len(nums)
        if length == 0:
            return 0
        if length == 1:
            return nums[0]
        if length == 2:
            return max(nums[0], nums[1])

        dp = [0] * (len(nums) - 1)
        dp[0] = nums[0]
        dp[1] = max(nums[0], nums[1])
        for i in range(2, length - 1):
            dp[i] = max(dp[i - 2] + nums[i], dp[i - 1])

        maximum = dp[-1]
        dp[0] = nums[-1]
        dp[1] = max(nums[-1], nums[-2])
        for r in range(3, length):
            i = r - 1
            dp[i] = max(dp[i - 2] + nums[-r], dp[i - 1])

        return max(maximum, dp[-1])


if __name__ == '__main__':
    s = Solution()
    print(s.rob([2]))
    print(s.rob([2, 3]))
    print(s.rob([2, 3, 2]))
    print(s.rob([1, 2, 3, 1]))
    print(s.rob([1, 2, 3, 1, 4]))
