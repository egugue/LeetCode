from shared.ListNode import ListNode


class Solution:
    def detectCycle(self, head: ListNode) -> ListNode:
        # 44 ms	16.7 MB
        if not head or not head.next:
            return None

        slow = head.next
        fast = head.next.next
        while slow != fast and fast and fast.next:
            slow = slow.next
            fast = fast.next.next

        if not fast or not fast.next:
            return None

        cur = head
        while cur != fast:
            cur = cur.next
            fast = fast.next

        return fast


if __name__ == '__main__':
    s = Solution()
    head = ListNode.of("3->2->0->-4")
    head.tail().next = head.next
    cycle = s.detectCycle(head)
    print(cycle.val)

    head = ListNode.of("1->2")
    head.tail().next = head.next
    cycle = s.detectCycle(head)
    print(cycle.val)

    head = ListNode.of("1")
    cycle = s.detectCycle(head)
    print(cycle)
