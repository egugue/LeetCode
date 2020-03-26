package _02

import (
	"LeetCode/shared"
)

type ListNode = shared.ListNode

// 8 ms	5 MB
func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
	carry := 0
	var curNode *ListNode
	var root *ListNode
	for l1 != nil || l2 != nil {
		var v1 int
		if l1 != nil {
			v1 = l1.Val
			l1 = l1.Next
		}
		var v2 int
		if l2 != nil {
			v2 = l2.Val
			l2 = l2.Next
		}

		sum := v1 + v2 + carry
		carry = sum / 10
		node := &ListNode{Val: sum % 10}

		if curNode == nil {
			root = node
		} else {
			curNode.Next = node
		}
		curNode = node
	}

	if carry != 0 && curNode != nil {
		curNode.Next = &ListNode{Val: carry}
	}

	return root
}
