from typing import List


class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        # 44 ms	14 MB
        length = len(prices)
        if length == 0:
            return 0

        # noop: 0, buy or hold: 1, sell: 2
        dp = [[0] * 3 for _ in range(length)]
        dp[0][1] = -prices[0]

        for i in range(1, length):
            prev = dp[i - 1]
            # noop = from noop or from sell
            dp[i][0] = max(
                prev[0],
                prev[2]
            )

            # buy or hold = buy a stock from noop or hold a stock
            dp[i][1] = max(
                prev[0] - prices[i],
                prev[1]
            )

            # sell = sell a stock
            dp[i][2] = prev[1] + prices[i]

        return max(dp[-1][0], dp[-1][2])


if __name__ == '__main__':
    s = Solution()
    print(s.maxProfit([1, 2, 3, 0, 2]))
