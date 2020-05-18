import collections
from typing import List


class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        # 88 ms	16.8 MB
        if len(strs) == 0:
            return []

        table = collections.defaultdict(list)
        for s in strs:
            key = ''.join(sorted(s))
            table[key].append(s)

        res = []
        for v in table.values():
            res.append(v)
        return res


if __name__ == '__main__':
    s = Solution()
    print(s.groupAnagrams(["eat", "tea", "tan", "ate", "nat", "bat"]))
