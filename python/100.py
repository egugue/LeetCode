from shared.TreeNode import TreeNode
from shared.ListNode import ListNode


class Solution:
    def isSameTree(self, p: TreeNode, q: TreeNode) -> bool:
        return iterative(p, q)
        # return recursive(p, q)


def iterative(p: TreeNode, q: TreeNode) -> bool:
    if p is None and q is None:
        return True
    if p is None or q is None:
        return False

    pqueue = [p]
    qqueue = [q]
    while len(pqueue) != 0 and len(qqueue) != 0:
        pnode = pqueue.pop()
        qnode = qqueue.pop()
        if pnode.val != qnode.val:
            return False

        if pnode.left and qnode.left:
            pqueue.append(pnode.left)
            qqueue.append(qnode.left)
        elif pnode.left or qnode.left:
            return False

        if pnode.right and qnode.right:
            pqueue.append(pnode.right)
            qqueue.append(qnode.right)
        elif pnode.right or qnode.right:
            return False

    return len(pqueue) == len(qqueue)


def recursive(p: TreeNode, q: TreeNode) -> bool:
    if p is None and q is None:
        return True
    if p is None or q is None:
        return False
    if p.val != q.val:
        return False

    return recursive(p.left, q.left) and recursive(p.right, q.right)

if __name__ == '__main__':
    s = Solution()
    p = TreeNode(1)
    p.left = TreeNode(2)

    q = TreeNode(1)
    q.right = TreeNode(2)
    print(s.isSameTree(p, q))