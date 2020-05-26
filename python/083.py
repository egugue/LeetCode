from shared.ListNode import ListNode


class Solution:
    def deleteDuplicates(self, head: ListNode) -> ListNode:
        # 40 ms	13.8 MB
        cur: ListNode = head
        while cur and cur.next:
            if cur.val == cur.next.val:
                cur.next = cur.next.next
            else:
                cur = cur.next

        return head


if __name__ == '__main__':
    s = Solution()
    print(s.deleteDuplicates(ListNode.of("1->1->2")))
    print(s.deleteDuplicates(ListNode.of("1->1->2->3->3")))
    print(s.deleteDuplicates(ListNode.of("1->1->1->2->3->3")))
