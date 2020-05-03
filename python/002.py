from shared.ListNode import ListNode


class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        dummy = ListNode(0)
        cur = dummy
        carry = 0
        while l1 is not None or l2 is not None:
            v1 = 0
            if l1 is not None:
                v1 = l1.val
                l1 = l1.next

            v2 = 0
            if l2 is not None:
                v2 = l2.val
                l2 = l2.next

            sum = v1 + v2 + carry
            cur.next = ListNode(sum % 10)
            cur = cur.next
            carry = sum // 10

        if carry != 0:
            cur.next = ListNode(carry)

        return dummy.next
