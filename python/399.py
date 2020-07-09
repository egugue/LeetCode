from typing import List, Dict, Tuple


class Solution:
    def calcEquation(self, equations: List[List[str]], values: List[float], queries: List[List[str]]) -> List[float]:
        return iterative(equations, values, queries)
        # return recursive(equations, values, queries)


def iterative(equations: List[List[str]], values: List[float], queries: List[List[str]]) -> List[float]:
    # 20 ms	14 MB
    graph = build_graph(equations, values)

    def dig(src: str, dest: str) -> float:
        stack = []
        visited = set()

        for interchange, value in graph[src]:
            stack.append((interchange, value))

        while len(stack) != 0:
            interchange, cur = stack.pop()
            visited.add(interchange)
            if interchange == dest:
                return cur
            routes = graph[interchange]
            for interchange, value in routes:
                if interchange not in visited:
                    stack.append((interchange, cur * value))

        return -1.0

    length = len(queries)
    results = []
    for i in range(length):
        query = queries[i]
        results.append(dig(query[0], query[1]))
    return results


def recursive(equations: List[List[str]], values: List[float], queries: List[List[str]]) -> List[float]:
    # 56 ms	13.8 MB
    graph = build_graph(equations, values)
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


def build_graph(equations: List[List[str]], values: List[float]) -> Dict[str, Tuple[str, float]]:
    from collections import defaultdict
    graph = defaultdict(lambda: [])
    length = len(equations)
    for i in range(length):
        equation = equations[i]
        graph[equation[0]].append((equation[1], values[i]))
        graph[equation[1]].append((equation[0], 1 / values[i]))

    return graph


if __name__ == '__main__':
    s = Solution()
    print(s.calcEquation(
        [["a", "b"], ["b", "c"]],
        [2.0, 3.0],
        [["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"]]
    ))
