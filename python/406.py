from typing import List


class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        # 168 ms	14.3 MB
        def cmp(p1, p2) -> int:
            h = p2[0] - p1[0]
            return h if h != 0 else p1[1] - p2[1]

        from functools import cmp_to_key
        people.sort(key=cmp_to_key(cmp))

        from collections import deque
        queue = deque()
        for person in people:
            queue.insert(person[1], person)

        return list(queue)


if __name__ == '__main__':
    s = Solution()
    print(s.reconstructQueue([[7, 0], [4, 4], [7, 1], [5, 0], [6, 1], [5, 2]]))
