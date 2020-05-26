from typing import List


class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        # 32 ms	14 MB
        if len(nums) == 0:
            return []
        result = [[]]
        builder = []

        def backtrack(cur: int):
            for i in range(cur, len(nums)):
                builder.append(nums[i])
                result.append(builder[:])
                backtrack(i + 1)
                del builder[-1]

        backtrack(0)
        return result


if __name__ == '__main__':
    s = Solution()
    print(s.subsets([1, 2, 3]))
