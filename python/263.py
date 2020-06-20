class Solution:
    def isUgly(self, num: int) -> bool:
        # 28 ms	14.1 MB
        if num <= 0:
            return False

        while num % 5 == 0:
            num //= 5

        while num % 3 == 0:
            num //= 3

        while num % 2 == 0:
            num //= 2

        return num == 1


if __name__ == '__main__':
    s = Solution()
    print(s.isUgly(1))
    print(s.isUgly(6))
    print(s.isUgly(8))
    print(s.isUgly(14))
