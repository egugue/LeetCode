from typing import List


class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        # 312 ms	15.3 MB
        if len(nums) == 0:
            return -1

        mid = len(nums) / 2
        table = {}
        for _, num in enumerate(nums):
            table[num] = table[num] + 1 if num in table else 1
            if table[num] >= mid:
                return num

        return -1


if __name__ == '__main__':
    s = Solution()
    print(s.majorityElement([3]))
    print(s.majorityElement([3, 2, 3]))
    print(s.majorityElement([2, 2, 1, 1, 1, 2, 2]))
