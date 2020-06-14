class Solution:
    def isIsomorphic(self, s: str, t: str) -> bool:
        # 60 ms	14 MB
        length = len(s)
        if length != len(t):
            return False

        s_table = {}
        t_table = {}
        for i in range(0, length):
            schar = s[i]
            tchar = t[i]
            if schar not in s_table:
                s_table[schar] = i
            if tchar not in t_table:
                t_table[tchar] = i
            if s_table[schar] != t_table[tchar]:
                return False

        return True


if __name__ == '__main__':
    s = Solution()
    print(s.isIsomorphic("egg", "add"))
    print(s.isIsomorphic("foo", "bar"))
    print(s.isIsomorphic("paper", "title"))
    print(s.isIsomorphic("ab", "aa"))
