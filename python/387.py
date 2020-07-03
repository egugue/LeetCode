class Solution:
    def firstUniqChar(self, s: str) -> int:
        return count_table(s)


def count_table(s: str) -> int:
    # 244 ms	14.1 MB
    length = len(s)
    if length == 0:
        return -1

    char_count = {}
    for i in range(0, length):
        char = s[i]
        if char in char_count:
            char_count[char] += 1
        else:
            char_count[char] = 1

    for i in range(0, length):
        char = s[i]
        if char_count[char] == 1:
            return i

    return -1


if __name__ == '__main__':
    s = Solution()
    print(s.firstUniqChar("leetcode"))
    print(s.firstUniqChar("loveleetcode"))
