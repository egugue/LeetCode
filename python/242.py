class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        return using_map(s, t)


def using_map(s: str, t: str) -> bool:
    # 52 ms	14.1 MB
    s_length = len(s)
    t_length = len(t)
    if s_length != t_length:
        return False

    dic = {}
    for i in range(s_length):
        char = s[i]
        if char in dic:
            dic[char] += 1
        else:
            dic[char] = 1

    for i in range(t_length):
        char = t[i]
        if char not in dic or dic[char] == 0:
            return False
        dic[char] -= 1

    return True


if __name__ == '__main__':
    s = Solution()
    print(s.isAnagram("anagram", "nagaram"))
