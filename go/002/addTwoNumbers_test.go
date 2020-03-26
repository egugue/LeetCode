package _02

import (
	"LeetCode/shared"
	"fmt"
	"testing"
)

func TestAddTwoNumbers(t *testing.T) {
	cases := []struct {
		l1       *ListNode
		l2       *ListNode
		expected *ListNode
	}{
		{
			listNode([]int{2, 4, 3}),
			listNode([]int{5, 6, 4}),
			listNode([]int{7, 0, 8}),
		},
		{
			listNode([]int{3, 1, 2}),
			listNode([]int{9}),
			listNode([]int{2, 2, 2}),
		},
		{
			listNode([]int{5}),
			listNode([]int{5}),
			listNode([]int{0, 1}),
		},
	}

	for i, c := range cases {
		t.Run(fmt.Sprintf("No.%v", i), func(t *testing.T) {
			if actual := addTwoNumbers(c.l1, c.l2); c.expected.String() != actual.String() {
				t.Errorf("failed \nexpected = %v\nactual = %v", c.expected, actual)
			}
		})
	}
}

func listNode(nums []int) *ListNode {
	return shared.NewListNodeFromNums(nums)
}
