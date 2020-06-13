from shared.ListNode import ListNode


class Solution:
    def sortList(self, head: ListNode) -> ListNode:
        return merge_sort(head)


# 212 ms	23.1 MB
def merge_sort(head: ListNode) -> ListNode:
    def sort(node: ListNode, size: int) -> ListNode:
        if size <= 1:
            return node

        mid = size // 2
        node1 = node
        node2 = node
        while mid != 1:
            node2 = node2.next
            mid -= 1
        tmp = node2
        node2 = node2.next
        tmp.next = None

        mid = size // 2
        node1 = sort(node1, mid)
        node2 = sort(node2, size - mid)

        return merge(node1, node2)

    def merge(node1: ListNode, node2: ListNode) -> ListNode:
        if not node1 or not node2:
            return node1 if node1 else node2

        if node1.val <= node2.val:
            new_head = node1
            node1 = node1.next
        else:
            new_head = node2
            node2 = node2.next

        cur = new_head
        while node1 or node2:
            if not node1 or not node2:
                cur.next = node1 if node1 else node2
                break

            if node1.val < node2.val:
                cur.next = node1
                cur = cur.next
                node1 = node1.next
            else:
                cur.next = node2
                cur = cur.next
                node2 = node2.next

        return new_head

    return sort(head, length(head))


def length(head: ListNode) -> int:
    if not head:
        return 0

    len = 1
    cur = head
    while cur.next:
        cur = cur.next
        len += 1

    return len


if __name__ == '__main__':
    s = Solution()
    n = ListNode.of("4->2->1->3->1")
    n = s.sortList(n)
    print(str(n))
