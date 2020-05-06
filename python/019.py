from shared.ListNode import ListNode


class Solution:
    def removeNthFromEnd(self, head: ListNode, n: int) -> ListNode:
        # 32 ms	13.9 MB
        assert n >= 1

        nth_forward = head
        while n > 0 and nth_forward is not None:
            n -= 1
            nth_forward = nth_forward.next
        if nth_forward is None:
            assert n == 0
            return head.next

        cur = head
        while nth_forward.next is not None:
            nth_forward = nth_forward.next
            cur = cur.next

        cur.next = cur.next.next
        return head


if __name__ == '__main__':
    head = ListNode.of("1->2->3->4->5")
    print(Solution().removeNthFromEnd(head, 2))

    head = ListNode.of("1->2->3->4->5")
    print(Solution().removeNthFromEnd(head, 1))

    head = ListNode.of("1->2->3->4->5")
    print(Solution().removeNthFromEnd(head, 5))

    head = ListNode.of("1")
    print(Solution().removeNthFromEnd(head, 1))
