from typing import List


class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        # 84 ms	14.5 MB
        length = len(nums)
        if length == 0:
            return -1
        if length == 1:
            return nums[0]

        import heapq
        heap = []
        heapq.heapify(heap)

        for _, num in enumerate(nums):
            heapq.heappush(heap, num)
            if len(heap) > k:
                heapq.heappop(heap)

        return heapq.heappop(heap)


if __name__ == '__main__':
    s = Solution()
    print(s.findKthLargest([3, 2, 1, 5, 6, 4], 2))
    print(s.findKthLargest([3, 2, 3, 1, 2, 4, 5, 5, 6], 4))
    print(s.findKthLargest([2, 1], 2))
