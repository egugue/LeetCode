class Solution:
    def findTheDifference(self, s: str, t: str) -> str:
        # 56 ms	13.9 MB
        length = len(s)
        if length == 0:
            return t
        table = {}
        for i in range(length):
            ch = s[i]
            if ch in table:
                table[ch] += 1
            else:
                table[ch] = 1

        t_length = len(t)
        for i in range(t_length):
            ch = t[i]
            if ch in table:
                if table[ch] == 0:
                    return ch
                table[ch] -= 1
            else:
                return ch

        return ""


if __name__ == '__main__':
    s = Solution()
    print(s.findTheDifference("abcd", "abcde"))
    print(s.findTheDifference("abca", "abcaa"))
    print(s.findTheDifference("abcd", "abcde"))
    print(s.findTheDifference("abcd", "abcdd"))

