from shared.ListNode import ListNode


class Solution:
    def isPalindrome(self, head: ListNode) -> bool:
        return using_array(head)


def using_array(head: ListNode) -> bool:
    # 76 ms	23.9 MB
    if not head or not head.next:
        return True

    # calc length
    length = 0
    cur = head
    while cur:
        cur = cur.next
        length += 1

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


if __name__ == '__main__':
    s = Solution()
    print(s.isPalindrome(ListNode.of("1->2")))
    print(s.isPalindrome(ListNode.of("1->2->2->1")))
    print(s.isPalindrome(ListNode.of("1->2->3->2->1")))
