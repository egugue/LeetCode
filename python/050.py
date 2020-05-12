class Solution:
    def myPow(self, x: float, n: int) -> float:
        # 28 ms	13.7 MB
        if n == 0:
            return 1
        if n == 1:
            return x

        if n < 0:
            return 1 / self.myPow(x, -n)
        if n % 2 == 1:
            return x * self.myPow(x, n - 1)
        else:
            return self.myPow(x * x, n // 2)


if __name__ == '__main__':
    s = Solution()
    print(s.myPow(2.00000, 10))
    print(s.myPow(2.10000, 3))
    print(s.myPow(2.00002, -2))
    print(s.myPow(1.1, -3))
    # print(s.myPow(34.00515, -3))
    # print(s.myPow(2.00000, -2147483648))
