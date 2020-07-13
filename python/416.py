from typing import List


class Solution:
    def canPartition(self, nums: List[int]) -> bool:
        # 1972 ms	13.9 MB
        length = len(nums)
        if length == 0:
            return False
        ssum = sum(nums)
        if ssum & 2 == 1:
            return False

        target = ssum // 2
        dp = [False] * (target + 1)
        dp[0] = True

        for num in nums:
            for j in range(target, -1, -1):
                if j - num >= 0:
                    dp[j] = dp[j] or dp[j - num]

        print(dp)
        return dp[target]
