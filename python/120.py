from typing import List


class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        # 80 ms	14.6 MB
        if len(triangle) == 0:
            return 0
        dp = [0] * len(triangle)
        dp[0] = triangle[0][0]

        for i in range(1, len(triangle)):
            dp[i] = dp[i - 1] + triangle[i][-1]
            for j in range(i - 1, 0, -1):
                dp[j] = min(dp[j - 1], dp[j]) + triangle[i][j]
            dp[0] += triangle[i][0]

        mini = dp[0]
        for i in range(1, len(dp)):
            mini = min(mini, dp[i])

        return mini


if __name__ == '__main__':
    s = Solution()
    print(s.minimumTotal(
        [
            [2],
            [3, 4],
            [6, 5, 7],
            [4, 1, 8, 3]
        ]
    ))
