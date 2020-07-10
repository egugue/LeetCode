class Solution:
    table = ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f']

    def toHex(self, num: int) -> str:
        # 28 ms	13.8 MB
        if num == 0:
            return '0'

        if num < 0:
            num += 0x1_0000_0000

        hex_str = ""
        while num != 0:
            hex_str = str(self.table[num & 15]) + hex_str
            num >>= 4
        return hex_str


if __name__ == '__main__':
    s = Solution()
    print(s.toHex(26))
    print(s.toHex(-1))
