from shared.ListNode import ListNode


class Solution:
    def deleteDuplicates(self, head: ListNode) -> ListNode:
        # 40 ms	13.8 MB
        dummy = ListNode(0)
        dummy.next = head
        head = dummy
        prev: ListNode = dummy
        cur: ListNode = prev.next

        while cur and cur.next:
            if cur.val != cur.next.val:
                prev = cur
                cur = cur.next
                continue

            last_same: ListNode = cur.next
            while last_same.next and last_same.val == last_same.next.val:
                last_same = last_same.next

            prev.next = last_same.next
            cur = prev.next

        return head.next


if __name__ == '__main__':
    s = Solution()
    print(s.deleteDuplicates(ListNode.of("1->2->3->3->4->4->5")))
    print(s.deleteDuplicates(ListNode.of("1->1->1->2->3")))
