from typing import List


class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        # 100 ms	14.8 MB
        result = []
        s_length, p_length = len(s), len(p)
        if s_length < p_length or s_length == 0:
            return result

        import collections
        char_count = collections.defaultdict(int)
        for c in p:
            char_count[c] += 1

        counter = len(char_count)
        first, end = 0, 0
        while end < s_length:
            char = s[end]
            if char in char_count:
                char_count[char] -= 1
                if char_count[char] == 0:
                    counter -= 1

            while counter == 0:
                f_char = s[first]
                if f_char in char_count:
                    char_count[f_char] += 1
                    if char_count[f_char] > 0:
                        counter += 1
                if end - first + 1 == p_length:
                    result.append(first)
                first += 1

            end += 1

        return result


if __name__ == '__main__':
    s = Solution()
    # print(s.findAnagrams("cbaebabacd", "abc"))
    # print(s.findAnagrams("cbaebabacd", "a"))
    # print(s.findAnagrams("abab", "ab"))
    # print(s.findAnagrams("abacbabc", "abc"))
    print(s.findAnagrams("abaacbabc", "abc"))
