from typing import List


class Solution:
    def uniquePathsWithObstacles(self, grid: List[List[int]]) -> int:
        if len(grid) == 0 or len(grid[0]) == 0 or grid[0][0] == 1:
            return 0

        width, height = len(grid[0]), len(grid)
        dp = [[0 for _ in range(width)] for _ in range(height)]
        dp[0][0] = 1

        for i in range(1, width):
            dp[0][i] = 0 if dp[0][i - 1] == 0 or grid[0][i] == 1 else 1
        for i in range(1, height):
            dp[i][0] = 0 if dp[i - 1][0] == 0 or grid[i][0] == 1 else 1

        for i in range(1, height):
            for j in range(1, width):
                dp[i][j] = 0 if grid[i][j] == 1 else dp[i][j - 1] + dp[i - 1][j]

        return dp[height - 1][width - 1]


if __name__ == '__main__':
    s = Solution()
    print(s.uniquePathsWithObstacles([
        [0, 0, 0, 1],
        [0, 1, 0, 1],
        [0, 0, 0, 0]
    ]))
    print(s.uniquePathsWithObstacles([
        [0],
    ]))
    print(s.uniquePathsWithObstacles([
        [0, 0],
        [1, 1],
        [0, 0]
    ]))
