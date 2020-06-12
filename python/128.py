from typing import List


class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        # 56 ms	15 MB
        if len(nums) <= 1:
            return len(nums)

        table = {}
        for _, num in enumerate(nums):
            table[num] = False

        maximum = 0
        for num in table:
            if table[num]:
                continue

            table[num] = True
            count = 1

            cur = num - 1
            while cur in table and not table[cur]:
                table[cur] = True
                count += 1
                cur -= 1

            cur = num + 1
            while cur in table and not table[cur]:
                table[cur] = True
                count += 1
                cur += 1

            maximum = max(maximum, count)

        return maximum


if __name__ == '__main__':
    s = Solution()
    print(s.longestConsecutive([100, 4, 200, 1, 3, 2]))
