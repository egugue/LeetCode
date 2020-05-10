import copy
from typing import List


class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        # 32 ms	13.9 MB
        permutations = []
        self.__backtrack([], set(), permutations, nums)
        return permutations

    def __backtrack(self, builder: List[int], set: set, permutations: List[List[int]], nums: List[int]):
        if len(builder) == len(nums):
            permutations.append(copy.copy(builder))
            return

        for _, num in enumerate(nums):
            if num in set:
                continue
            builder.append(num)
            set.add(num)
            self.__backtrack(builder, set, permutations, nums)
            builder.pop()
            set.remove(num)


if __name__ == '__main__':
    s = Solution()
    print(s.permute([1, 2, 3]))
