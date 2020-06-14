from typing import List


class Solution:
    def minSubArrayLen(self, s: int, nums: List[int]) -> int:
        # 120 ms	16.4 MB
        if len(nums) == 0:
            return 0

        left = 0
        right = 0
        length = len(nums)
        cur = 0
        min_length = len(nums) + 1
        while right < length:
            cur += nums[right]
            while cur >= s:
                min_length = min(min_length, right - left + 1)
                cur -= nums[left]
                left += 1
            right += 1

        return 0 if min_length == len(nums) + 1 else min_length


if __name__ == '__main__':
    s = Solution()
    print(s.minSubArrayLen(15, [2, 3, 1, 2, 4, 3]))
