from typing import List


class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        # 24 ms	13.8 MB

        if len(strs) == 0:
            return ""
        if len(strs) == 1:
            return strs[0]

        shortest = min(strs, key=len)

        for i, char in enumerate(shortest):
            for _, string in enumerate(strs):
                if char != string[i]:
                    return shortest[:i]

        return shortest


if __name__ == '__main__':
    s = Solution()
    print(s.longestCommonPrefix([
        "flower", "flow", "flight"
    ]))

    print(s.longestCommonPrefix([
        "dog", "racecar", "car"
    ]))

    print(s.longestCommonPrefix([
        "a"
    ]))
