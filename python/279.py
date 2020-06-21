class Solution:
    def numSquares(self, n: int) -> int:
        return bfs(n)
        # return dp(n)


def bfs(n: int) -> int:
    # 204 ms	14.6 MB
    if n < 2:
        return n

    squares = []
    i = 1
    while i ** 2 <= n:
        squares.append(i ** 2)
        i += 1

    count = 0
    rest_nums = {n}
    while len(rest_nums) != 0:
        count += 1
        next = set()
        for rest_num in rest_nums:
            for square in squares:
                if rest_num == square:
                    return count
                if rest_num < square:
                    break
                next.add(rest_num - square)
        rest_nums = next

    return count


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
    # print(s.numSquares(12))
    # print(s.numSquares(13))
    # print(s.numSquares(14))
    print(s.numSquares(255))
