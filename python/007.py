
class Solution:
    def reverse(self, x: int) -> int:
        result = 0
        sign = 1 if x >= 0 else -1

        x = abs(x)
        while x != 0:
            result = result * 10 + x % 10
            x //= 10

        if -2 ** 31 <= result <= 2 ** 31 - 1:
            return result * sign
        else:
            return 0


if __name__ == '__main__':
    s = Solution()
    print(s.reverse(123))
    print(s.reverse(120))
    print(s.reverse(-123))
