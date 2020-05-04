class Solution:
    def isPalindrome(self, x: int) -> bool:
        if x < 0:
            return False

        return x == Solution.reverse(x)

    @staticmethod
    def reverse(x: int) -> int:
        result = 0
        sign = 1 if x >= 0 else -1

        x = abs(x)
        while x != 0:
            result = result * 10 + x % 10
            x //= 10

        return result * sign


if __name__ == '__main__':
    s = Solution()
    print(s.isPalindrome(123))
    print(s.isPalindrome(121))
    print(s.isPalindrome(-121))
