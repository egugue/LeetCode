from typing import List


class Solution:
    def generate(self, numRows: int) -> List[List[int]]:
        # 48 ms	13.9 MB
        if numRows == 0:
            return []

        triangle = [[1]]
        for i in range(1, numRows):
            row = [1]
            prev = triangle[i - 1]
            for j in range(1, i):
                row.append(prev[j - 1] + prev[j])
            row.append(1)
            triangle.append(row)

        return triangle


if __name__ == '__main__':
    s = Solution()
    print(s.generate(5))
