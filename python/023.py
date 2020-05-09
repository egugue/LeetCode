from shared.ListNode import ListNode
from queue import PriorityQueue
from typing import List
from dataclasses import dataclass, field


@dataclass(order=True)
class Item:
    priority: int
    node: ListNode = field(compare=False)


class Solution:
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:
        # 216 ms	18.8 MB
        if len(lists) == 0:
            return None

        queue = PriorityQueue()
        for node in lists:
            if node:
                queue.put(Item(node.val, node))

        dummy = ListNode(0)
        cur = dummy
        while not queue.empty():
            min_node = queue.get().node
            cur.next = min_node
            cur = cur.next
            if min_node.next:
                queue.put(Item(min_node.next.val, min_node.next))

        return dummy.next


if __name__ == '__main__':
    s = Solution()
    n = s.mergeKLists([
        ListNode.of("1->4->5"),
        ListNode.of("1->3->4"),
        ListNode.of("2->6")
    ])
    print(n)
