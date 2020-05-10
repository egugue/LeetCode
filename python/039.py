from copy import copy
from typing import List


class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        # 84 ms	13.9 MB
        if len(candidates) == 0:
            return []
        combinations = []
        self.__backtrack([], target, 0, combinations,  candidates)
        return combinations

    def __backtrack(self, builder: List[int], rest: int, index: int, combinations: List[List[int]],
                    candidates: List[int]):
        if rest == 0:
            combinations.append(copy(builder))
            return
        if rest < 0:
            return

        for i in range(index, len(candidates)):
            candidate = candidates[i]
            builder.append(candidate)
            self.__backtrack(builder, rest - candidate, i, combinations, candidates)
            builder.pop()


if __name__ == '__main__':
    s = Solution()
    print(s.combinationSum([2, 3], 5))
    print(s.combinationSum([2, 3, 6, 7], 7))
    print(s.combinationSum([2, 3, 5], 8))
