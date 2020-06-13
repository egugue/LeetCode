from typing import List


class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        # return hash_map(nums)
        return approach_aonecode(nums)

# 312 ms	15.3 MB
def hash_map(nums: List[int]) -> int:
    if len(nums) == 0:
        return -1

    mid = len(nums) / 2
    table = {}
    for _, num in enumerate(nums):
        table[num] = table[num] + 1 if num in table else 1
        if table[num] >= mid:
            return num

    return -1


def approach_aonecode(nums: List[int]) -> int:
    # 172 ms	15.3 MB
    # https://leetcode.com/problems/majority-element/discuss/51613/O(n)-time-O(1)-space-fastest-solution
    if len(nums) == 0:
        return -1

    major = nums[0]
    length = len(nums)
    count = 1
    for i in range(1, length):
        if count == 0:
            count = 1
            major = nums[i]
            continue
        if major == nums[i]:
            count += 1
        else:
            count -= 1

    return major


if __name__ == '__main__':
    s = Solution()
    print(s.majorityElement([3]))
    print(s.majorityElement([3, 2, 3]))
    print(s.majorityElement([2, 2, 1, 1, 1, 2, 2]))
    print(s.majorityElement([10, 9, 9, 9, 10]))
