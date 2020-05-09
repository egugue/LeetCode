from shared.ListNode import ListNode


class Solution:
    def swapPairs(self, head: ListNode) -> ListNode:
        # 28 ms	13.9 MB
        if not head or not head.next:
            return head

        dummy = ListNode(0)
        prev = dummy
        cur = head
        while cur and cur.next:
            prev.next = cur.next
            cur.next = cur.next.next
            prev.next.next = cur

            prev = cur
            cur = cur.next

        if cur:
            prev.next = cur

        return dummy.next


if __name__ == '__main__':
    s = Solution()
    print(s.swapPairs(ListNode.of("2->1->4->3")))
