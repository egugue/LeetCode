from collections import deque


class Solution:
    def addBinary(self, a: str, b: str) -> str:
        # 24 ms	13.9 MB
        ai, bi = len(a) - 1, len(b) - 1
        binaries, carry = deque(), 0
        while ai >= 0 and bi >= 0:
            inter = int(a[ai]) + int(b[bi]) + carry
            carry = inter // 2
            binaries.appendleft(str(inter % 2))
            ai -= 1
            bi -= 1

        while ai >= 0:
            inter = int(a[ai]) + carry
            carry = inter // 2
            binaries.appendleft(str(inter % 2))
            ai -= 1

        while bi >= 0:
            inter = int(b[bi]) + carry
            carry = inter // 2
            binaries.appendleft(str(inter % 2))
            bi -= 1

        if carry:
            binaries.appendleft(str(carry))

        return "".join(binaries)


if __name__ == '__main__':
    s = Solution()
    assert s.addBinary("11", "1") == "100"
    assert s.addBinary("1010", "1011") == "10101"
