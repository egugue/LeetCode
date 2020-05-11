from typing import List


class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        # 96 ms	16.8 MB
        if len(strs) == 0:
            return []

        map = {}
        for i, s in enumerate(strs):
            sort = ''.join(sorted(s))
            if sort not in map:
                map[sort] = []
            map[sort].append(s)

        res = []
        for v in map.values():
            res.append(v)
        return res


if __name__ == '__main__':
    s = Solution()
    print(s.groupAnagrams(["eat", "tea", "tan", "ate", "nat", "bat"]))
