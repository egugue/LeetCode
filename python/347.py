from dataclasses import dataclass, field
from typing import List


class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        # 140 ms	18 MB
        length = len(nums)
        if length == 0:
            return []

        num_count = {}
        for _, num in enumerate(nums):
            if num in num_count:
                num_count[num] += 1
            else:
                num_count[num] = 1

        count_num = {}
        for num, count in num_count.items():
            if count in count_num:
                count_num[count].append(num)
            else:
                count_num[count] = [num]

        result = []
        for count in range(length, 0, -1):
            if count not in count_num:
                continue

            candidates = count_num[count]
            for candidate in candidates:
                result.append(candidate)
                if len(result) == k:
                    return result

        return result

