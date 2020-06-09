from typing import List


class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        # 48 ms	15.3 MB
        if len(prices) == 0:
            return 0

        min_price = prices[0]
        max_profit = 0
        length = len(prices)
        for i in range(1, length):
            if min_price > prices[i]:
                min_price = prices[i]
            else:
                max_profit = max(max_profit, prices[i] - min_price)

        return max_profit


if __name__ == '__main__':
    s = Solution()
    print(s.maxProfit([7, 1, 5, 3, 6, 4]))
