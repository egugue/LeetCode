class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        # 32 ms	13.8 MB
        dp = [[0 for _ in range(m)] for _ in range(n)]

        for i, _ in enumerate(dp):
            dp[i][0] = 1
        for j, _ in enumerate(dp[0]):
            dp[0][j] = 1

        for i in range(1, n):
            for j in range(1, m):
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j]

        return dp[n - 1][m - 1]


if __name__ == '__main__':
    s = Solution()
    print(s.uniquePaths(3, 2))
    print(s.uniquePaths(7, 3))
