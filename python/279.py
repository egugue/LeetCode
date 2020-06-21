class Solution:
    def numSquares(self, n: int) -> int:
        return dp(n)

def

def dp(n: int) -> int:
    # Time Limit Exceeded
    if n <= 3:
        return n

    dp = [0] * (n + 1)
    dp[0] = 0
    dp[1] = 1
    dp[2] = 2
    dp[3] = 3
    for i in range(4, n + 1):
        dp[i] = dp[i - 1] + 1
        j = 1
        while j ** 2 <= i:
            dp[i] = min(dp[i], dp[i - j ** 2] + 1)
            j += 1

    return dp[n]


if __name__ == '__main__':
    s = Solution()
    print(s.numSquares(12))
    print(s.numSquares(13))
    print(s.numSquares(14))
    print(s.numSquares(255))
