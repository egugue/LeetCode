from shared.ListNode import ListNode


class Solution:
    def isPalindrome(self, head: ListNode) -> bool:
        if not head or not head.next:
            return True
        return using_reverse(head)
        # return using_array(head)


def using_reverse(head: ListNode) -> bool:
    # 72 ms	24 MB
    # calc length
    length = calc_length(head)

    # reverse first half values
    mid = length // 2
    head = reverse(head, mid)

    # Move a pointer to the head of second half nodes
    second_half = head
    while mid > 0:
        second_half = second_half.next
        mid -= 1
    if length % 2 == 1:
        second_half = second_half.next

    first_half = head
    while second_half:
        if first_half.val != second_half.val:
            return False
        first_half = first_half.next
        second_half = second_half.next

    return True


def reverse(root: ListNode, size: int) -> ListNode:
    if not root or not root.next:
        return root

    prev = root
    cur = root.next
    size -= 1
    while cur and size > 0:
        cur_next = cur.next
        cur.next = root
        prev.next = cur_next
        root = cur
        cur = cur_next
        size -= 1

    # if cur:
    #     cur.next = None
    return root


def using_array(head: ListNode) -> bool:
    # 76 ms	23.9 MB
    # calc length
    length = calc_length(head)

    # collect first half values
    first_values = []
    mid = length // 2
    cur = head
    while mid > 0:
        first_values.append(cur.val)
        cur = cur.next
        mid -= 1

    second_half = cur
    if length % 2 == 1:
        second_half = second_half.next

    # check if second half values equal reversed first half values
    while second_half:
        if len(first_values) == 0 or second_half.val != first_values.pop():
            return False
        second_half = second_half.next

    return True


def calc_length(head: ListNode) -> int:
    # calc length
    length = 0
    cur = head
    while cur:
        cur = cur.next
        length += 1
    return length


if __name__ == '__main__':
    s = Solution()
    print(s.isPalindrome(ListNode.of("1->2")))
    print(s.isPalindrome(ListNode.of("1->2->2->1")))
    print(s.isPalindrome(ListNode.of("1->2->3->2->1")))
    print(s.isPalindrome(ListNode.of("1->2->3->1->1")))
