from typing import List


class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        # 1756 ms	14.3 MB
        length = len(coins)
        if length == 0:
            return -1

        length = amount + 1
        dp = [length] * length
        dp[0] = 0

        for _, coin in enumerate(coins):
            for i in range(coin, length):
                dp[i] = min(dp[i], dp[i - coin] + 1)

        return -1 if dp[amount] > amount else dp[amount]


if __name__ == '__main__':
    s = Solution()
    print(s.coinChange([1, 2, 5], 11))
    print(s.coinChange([1, 2, 5], 7))
    print(s.coinChange([1, 3, 6], 22))
    print(s.coinChange([2, 5, 10, 1], 27))
    print(s.coinChange([2], 3))
