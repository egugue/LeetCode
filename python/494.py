from typing import List


class Solution:
    def findTargetSumWays(self, nums: List[int], S: int) -> int:
        return using_dp(nums, S)
        # return using_dfs(nums, S)


def using_dp(nums: List[int], S: int) -> int:
    # 376 ms	14 MB
    from collections import defaultdict
    dp = {0: 1}
    for x in nums:
        m = defaultdict(int)
        for s, n in dp.items():
            m[s + x] += n
            m[s - x] += n
        dp = m
    return dp[S]


def using_dfs(nums: List[int], S: int) -> int:
    # Time Limit Exceeded
    # O(2^n)
    if len(nums) == 0:
        return 0

    def dfs(nums: List[int], cur: int, plus: bool) -> int:
        value = nums[0] if plus else -nums[0]
        cur += value

        next = nums[1:]
        if len(next) == 0:
            return 1 if cur == S else 0

        return dfs(next, cur, True) + dfs(next, cur, False)

    return dfs(nums, 0, True) + dfs(nums, 0, False)


if __name__ == '__main__':
    s = Solution()
    print(s.findTargetSumWays([1, 1, 1, 1, 1], 3))
