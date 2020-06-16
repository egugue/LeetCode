from shared.ListNode import ListNode


class Solution:
    def reverseList(self, head: ListNode) -> ListNode:
        # 36 ms	15.3 MB
        if not head or not head.next:
            return head

        root = head
        prev = head
        cur = head.next
        while cur:
            cur_next = cur.next
            cur.next = root
            prev.next = cur_next

            root = cur
            cur = cur_next

        return root


if __name__ == '__main__':
    s = Solution()
    print(s.reverseList(ListNode.of("1")))
    print(s.reverseList(ListNode.of("1->2")))
    print(s.reverseList(ListNode.of("1->2->3->4->5")))
