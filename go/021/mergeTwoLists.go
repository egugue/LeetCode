package _21

import (
	"LeetCode/shared"
)

type ListNode = shared.ListNode

// 0 ms	2.5 MB
func mergeTwoLists(l1 *ListNode, l2 *ListNode) *ListNode {
	if l1 == nil && l2 == nil {
		return nil
	}

	dummy := &ListNode{Val: 0}

	var tail = dummy
	for l1 != nil && l2 != nil {
		if l1.Val <= l2.Val {
			tail.Next = l1
			tail = l1
			l1 = l1.Next
		} else {
			tail.Next = l2
			tail = l2
			l2 = l2.Next
		}
	}

	for l1 != nil {
		tail.Next = l1
		tail = tail.Next
		l1 = l1.Next
	}
	for l2 != nil {
		tail.Next = l2
		tail = tail.Next
		l2 = l2.Next
	}

	return dummy.Next
}
