from shared.ListNode import ListNode


class Solution:
    def hasCycle(self, head: ListNode) -> bool:
        # 52 ms	17.1 MB
        if not head:
            return False

        slow = head
        fast = head.next
        while slow and fast and fast.next:
            if slow == fast:
                return True
            slow = slow.next
            fast = fast.next.next

        return False


if __name__ == '__main__':
    s = Solution()
    head = ListNode.of("3->2->0->-4")
    head.tail().next = head
    print(s.hasCycle(head))
