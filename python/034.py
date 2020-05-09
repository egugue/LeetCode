from typing import List


class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        # 84 ms	15.1 MB
        if len(nums) == 0:
            return [-1, -1]

        def binary_search(lowest: bool) -> int:
            left = -1
            right = len(nums)
            while right - left > 1:
                mid = (right + left) // 2
                if target < nums[mid]:
                    right = mid
                elif nums[mid] < target:
                    left = mid
                else:
                    if lowest:
                        right = mid
                    else:
                        left = mid

            index = right if lowest else left
            if 0 <= index < len(nums) and nums[index] == target:
                return index
            else:
                return -1

        lowest_index = binary_search(True)
        if lowest_index == -1:
            return [-1, -1]

        highest_index = binary_search(False)
        return [lowest_index, highest_index]


if __name__ == '__main__':
    s = Solution()
    assert s.searchRange([5, 7, 7, 8, 8, 10], 8) == [3, 4]
    assert s.searchRange([5, 7, 7, 8, 8, 10], 6) == [-1, -1]
    assert s.searchRange([2, 2], 3) == [-1, -1]
