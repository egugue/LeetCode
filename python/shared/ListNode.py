class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

    def tail(self):
        node = self
        while node.next:
            node = node.next
        return node

    @staticmethod
    def of(s: str):
        split = s.split("->")
        head = ListNode(int(split[0]))

        cur = head
        for _, val in enumerate(split[1:]):
            cur.next = ListNode(int(val))
            cur = cur.next

        return head

    def __str__(self):
        s = str(self.val)
        cur = self.next
        while cur is not None:
            s += "->" + str(cur.val)
            cur = cur.next
        return s
