class Solution:
    def isSubsequence(self, s: str, t: str) -> bool:
        # 40 ms	13.8 MB
        s_length = len(s)
        t_length = len(t)
        if s_length > t_length:
            return False

        ti = 0
        for si in range(s_length):
            s_char = s[si]
            while ti < t_length and s_char != t[ti]:
                ti += 1
            if ti == t_length:
                return False
            ti += 1

        return True


if __name__ == '__main__':
    s = Solution()
    print(s.isSubsequence("ace", "abcde"))
    print(s.isSubsequence("ace", "aec"))
    print(s.isSubsequence("ace", "ace"))
    print(s.isSubsequence("abc", "ahbgdc"))
    print(s.isSubsequence("axc", "ahbgdc"))
