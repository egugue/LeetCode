class Solution:
    def isPowerOfFour(self, num: int) -> bool:
        return loop(num)


# 28 ms	13.8 MB
def loop(num: int) -> bool:
    if num <= 0:
        return False
    if num == 1:
        return True

    while num != 0:
        if num == 1:
            return True
        if num & 3 == 0:
            num >>= 2
        else:
            return False

    return False


if __name__ == '__main__':
    s = Solution()
    print(s.isPowerOfFour(6))
    print(s.isPowerOfFour(16))
    print(s.isPowerOfFour(32))
    print(s.isPowerOfFour(64))
