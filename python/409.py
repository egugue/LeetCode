class Solution:
    def longestPalindrome(self, s: str) -> int:
        # 48 ms	13.8 MB
        if len(s) <= 1:
            return len(s)

        table = dict()
        for i in s:
            table[i] = table.get(i, 0) + 1

        if len(table) == 1:
            return table[s[0]]

        length = 0
        for count in table.values():
            if count % 2 == 0:
                length += count
            elif count > 2:
                length += count - 1
        if len(s) > length:
            length += 1
        return length


if __name__ == '__main__':
    s = Solution()
    print(s.longestPalindrome("abccccdd"))
    print(s.longestPalindrome("ccc"))
    print(s.longestPalindrome("cc"))
