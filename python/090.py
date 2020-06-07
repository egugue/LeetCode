from typing import List


class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        # 36 ms	14 MB
        if len(nums) == 0:
            return []
        result = [[]]
        builder = []
        nums.sort()

        def backtrack(cur: int):
            unique = set()
            for i in range(cur, len(nums)):
                num = nums[i]
                if num in unique:
                    continue
                unique.add(num)
                builder.append(num)
                result.append(builder[:])
                backtrack(i + 1)
                del builder[-1]

        backtrack(0)
        return result


if __name__ == '__main__':
    s = Solution()
    se = set()
    se.add(4)
    print(4 in se)
    print(1 in se)
    print(s.subsetsWithDup([1, 2, 2]))
    print(s.subsetsWithDup([1, 2, 2, 2]))
    print(s.subsetsWithDup([4, 4, 4, 1, 4]))
