from typing import List


class Solution:
    def findItinerary(self, tickets: List[List[str]]) -> List[str]:
        # 164 ms	14.3 MB
        import heapq
        table = {}

        for _, ticket in enumerate(tickets):
            src = ticket[0]
            dest = ticket[1]
            if src in table:
                heapq.heappush(table[src], dest)
            else:
                heap = [dest]
                heapq.heapify(heap)
                table[src] = heap

        if "JFK" not in table:
            return []

        result = []

        def bfs(src: str):
            if src in table:
                dests = table[src]
                while len(dests) != 0:
                    bfs(heapq.heappop(dests))
            result.append(src)

        bfs("JFK")

        result.reverse()
        return result


if __name__ == '__main__':
    s = Solution()
    print(s.findItinerary([["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]))
    print(s.findItinerary([["JFK", "SFO"], ["JFK", "ATL"], ["SFO", "ATL"], ["ATL", "JFK"], ["ATL", "SFO"]]))
    print(s.findItinerary([["JFK", "KUL"], ["JFK", "NRT"], ["NRT", "JFK"]]))
