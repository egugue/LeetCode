from typing import List


class Solution:
    def rob(self, nums: List[int]) -> int:
        # return dp_get(nums)
        return dp_take(nums)


def dp_get(nums: List[int]) -> int:
    # 32 ms	13.8 MB
    length = len(nums)
    if length <= 1:
        return 0 if length == 0 else nums[0]

    dp = [0] * length
    dp[0] = nums[0]
    dp[1] = max(dp[0], nums[1])
    for i in range(2, length):
        dp[i] = max(dp[i - 2] + nums[i], dp[i - 1])

    return dp[length - 1]


def dp_take(nums: List[int]) -> int:
    # 28 ms	13.8 MB
    length = len(nums)
    if length <= 1:
        return 0 if length == 0 else nums[0]

    dp = [0] * length
    dp[0] = nums[0]
    dp[1] = max(dp[0], nums[1])
    for i in range(0, length - 2):
        dp[i + 2] = max(dp[i] + nums[i + 2], dp[i + 1])

    return dp[length - 1]


if __name__ == '__main__':
    s = Solution()
    print(s.rob([1, 2, 3, 1]))
    print(s.rob([2, 7, 9, 3, 1]))
