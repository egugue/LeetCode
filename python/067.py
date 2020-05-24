class Solution:
    def addBinary(self, a: str, b: str) -> str:
        # 32 ms	13.9 MB
        ai, bi = len(a) - 1, len(b) - 1
        binaries, carry = "", 0
        while ai >= 0 or bi >= 0 or carry:
            inter = (int(a[ai]) if ai >= 0 else 0) \
                    + (int(b[bi]) if bi >= 0 else 0) \
                    + carry
            carry = inter // 2
            binaries = str(inter % 2) + binaries
            ai -= 1
            bi -= 1

        return binaries


if __name__ == '__main__':
    s = Solution()
    assert s.addBinary("11", "1") == "100"
    assert s.addBinary("1010", "1011") == "10101"
