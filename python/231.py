class Solution:
    def isPowerOfTwo(self, n: int) -> bool:
        # 32 ms	13.8 MB
        if n == 0:
            return False

        return (n & (n - 1)) == 0


if __name__ == '__main__':
    s = Solution()
    print(s.isPowerOfTwo(15))
    print(s.isPowerOfTwo(16))
    print(s.isPowerOfTwo(218))
