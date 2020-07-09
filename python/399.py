from typing import List


class Solution:
    def calcEquation(self, equations: List[List[str]], values: List[float], queries: List[List[str]]) -> List[float]:
        # 56 ms	13.8 MB

        from collections import defaultdict
        graph = defaultdict(lambda: [])
        length = len(equations)
        for i in range(length):
            equation = equations[i]
            graph[equation[0]].append((equation[1], values[i]))
            graph[equation[1]].append((equation[0], 1 / values[i]))

        visited = set()

        def dig(src: str, dest: str) -> float:
            for interchange, value in graph[src]:
                if interchange in visited:
                    continue
                visited.add(interchange)

                if interchange == dest:
                    return value
                result = dig(interchange, dest)
                if result != -1:
                    return result * value

            return -1.0

        length = len(queries)
        results = []
        for i in range(length):
            query = queries[i]
            results.append(dig(query[0], query[1]))
            visited.clear()
        return results


if __name__ == '__main__':
    s = Solution()
    print(s.calcEquation(
        [["a", "b"], ["b", "c"]],
        [2.0, 3.0],
        [["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"]]
    ))
