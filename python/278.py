class Solution:
    def firstBadVersion(self, n):
        # 32 ms	14 MB
        """
        :type n: int
        :rtype: int
        """
        left = 0
        right = n + 1
        while right - left > 1:
            mid = (left + right) // 2
            if isBadVersion(mid):
                right = mid
            else:
                left = mid
        return right


def isBadVersion(version: int) -> int:
    return version >= 7


if __name__ == '__main__':
    s = Solution()
    print(s.firstBadVersion(20))
