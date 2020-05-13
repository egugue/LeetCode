from typing import List


class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        # 84 ms	15.6 MB
        if len(intervals) == 0:
            return []
        intervals.sort(key=lambda interval: interval[0])
        merged = [intervals[0]]
        for _, interval in enumerate(intervals[1:]):
            last = merged[len(merged) - 1]
            if last[1] < interval[0]:
                # cannot merge because of two intervals are like below
                # ---
                #      ----
                merged.append(interval)
            elif last[1] < interval[1]:
                # can merge
                merged[len(merged) - 1][1] = interval[1]

        return merged


if __name__ == '__main__':
    s = Solution()
    print(s.merge([[1, 3], [2, 6], [8, 10], [15, 18]]))
    print(s.merge([[1, 4], [4, 5]]))
