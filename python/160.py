from shared.ListNode import ListNode


class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        # 188 ms	29.1 MB
        if not headA or not headB:
            return None

        node1 = headA
        node2 = headB
        while node1 != node2:
            if not node1 and not node2:
                return None
            node1 = node1.next if node1 else headB
            node2 = node2.next if node2 else headA

        return node1


if __name__ == '__main__':
    s = Solution()
    head_a = ListNode.of("2->6->4")
    head_b = ListNode.of("1->5")
    i = s.getIntersectionNode(head_a, head_b)
    print(i)
