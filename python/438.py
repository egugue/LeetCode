from typing import List


class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        return original(s, p)
        # return template(s, p)


def template(s: str, p: str) -> List[int]:
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
        end += 1

        while counter == 0:
            f_char = s[first]
            if f_char in char_count:
                char_count[f_char] += 1
                if char_count[f_char] > 0:
                    counter += 1
            if end - first == p_length:
                result.append(first)
            first += 1

    return result


def original(s: str, p: str) -> List[int]:
    # 120 ms	14.6 MB
    s_length, p_length = len(s), len(p)
    if s_length == 0 or p_length == 0:
        return []

    import collections
    char_count = collections.defaultdict(int)
    for c in p:
        char_count[c] += 1

    anagrams = []
    rest = char_count.copy()
    count = len(char_count)
    first, end = 0, 0
    for end in range(s_length):
        char = s[end]
        if char not in char_count:
            first = end + 1
            rest = char_count.copy()
            count = len(char_count)
            continue

        rest[char] -= 1
        if rest[char] == 0:
            count -= 1
            if count == 0:
                anagrams.append(first)

        if end - first + 1 == p_length:
            rest[s[first]] += 1
            if rest[s[first]] > 0:
                count += 1
            first += 1

    return anagrams


if __name__ == '__main__':
    s = Solution()
    print(s.findAnagrams("cbaebabacd", "abc"))
    print(s.findAnagrams("cbaebabacd", "a"))
    print(s.findAnagrams("abab", "ab"))
    print(s.findAnagrams("abacbabc", "abc"))
    print(s.findAnagrams("abaacbabc", "abc"))
