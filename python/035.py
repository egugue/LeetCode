from typing import List


class Solution:
    def searchInsert(self, nums: List[int], target: int) -> int:
        # 44 ms	14.6 MB
        left = -1
        right = len(nums)
        while right - left > 1:
            mid = (left + right) // 2
            mid_val = nums[mid]
            if target == mid_val:
                return mid
            elif target < mid_val:
                right = mid
            else:
                left = mid

        return right


if __name__ == '__main__':
    s = Solution()
    print(s.searchInsert([1, 3, 5, 6], 5))
    print(s.searchInsert([1, 3, 5, 6], 2))
    print(s.searchInsert([1, 3, 5, 6], 7))
    print(s.searchInsert([1, 3, 5, 6], 0))
