from copy import copy
from typing import List


class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:
        # 516 ms	15.3 MB
        result = []
        builder = []

        def backtrack(cur: int):
            if len(builder) == k:
                result.append(builder[:])
                return

            for i in range(cur, n + 1):
                builder.append(i)
                backtrack(i + 1)
                del builder[-1]

        backtrack(1)
        return result


if __name__ == '__main__':
    # a = []
    # a.append(1)
    # a = a[:len(a) - 1]
    # print(a)
    s = Solution()
    print(s.combine(4, 2))
