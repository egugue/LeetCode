class Solution:
    def addStrings(self, num1: str, num2: str) -> str:
        # 100 ms	13.8 MB
        i1 = len(num1)
        i2 = len(num2)
        if i1 == 0 or i2 == 0:
            return num1 if i2 == 0 else num2

        i1 -= 1
        i2 -= 1
        carry = 0
        zero_code = ord('0')
        result = ""
        while i1 >= 0 or i2 >= 0:
            v1 = ord(num1[i1]) - zero_code if i1 >= 0 else 0
            v2 = ord(num2[i2]) - zero_code if i2 >= 0 else 0
            s = v1 + v2 + carry
            result = str(s % 10) + result
            carry = s // 10
            i1 -= 1
            i2 -= 1

        if carry != 0:
            result = str(carry) + result

        return result


if __name__ == '__main__':
    s = Solution()
    print(s.addStrings("123", "911"))
    print(s.addStrings("9999", "123"))
    print(s.addStrings("0", "123"))
    print(s.addStrings("0", "0"))
