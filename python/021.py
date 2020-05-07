from shared.ListNode import ListNode


class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        # 36 ms	13.9 MB
        if not l1 or not l2:
            return l1 or l2

        dummy = ListNode(0)
        cur = dummy
        while l1 and l2:
            if l1.val < l2.val:
                cur.next = l1
                l1 = l1.next
            else:
                cur.next = l2
                l2 = l2.next
            cur = cur.next

        cur.next = l1 or l2
        return dummy.next


if __name__ == '__main__':
    l1 = ListNode.of("1->2->4")
    l2 = ListNode.of("1->3->4->5")
    # print(Solution().mergeTwoLists(l1, l2))
    assert Solution().mergeTwoLists(l1, l2).__str__() == "1->1->2->3->4->4->5"
