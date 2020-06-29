from typing import List


class Solution:
    def reverseString(self, s: List[str]) -> None:
        # 204 ms	18.2 MB
        length = len(s)
        if length <= 1:
            return

        left = 0
        right = length - 1
        while left < right:
            tmp = s[left]
            s[left] = s[right]
            s[right] = tmp
            left += 1
            right -= 1


if __name__ == '__main__':
    s = Solution()
    s.reverseString(["h", "e", "l", "l", "o"])
    s.reverseString(["H", "a", "n", "n", "a", "h"])
