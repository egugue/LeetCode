package _21

import (
	"LeetCode/shared"
	"fmt"
	"testing"
)

func TestMergeTwoLists(t *testing.T) {
	cases := []struct {
		l1       *ListNode
		l2       *ListNode
		expected *ListNode
	}{
		{
			nil,
			nil,
			nil,
		},
		{
			nil,
			shared.NewListNodeFromFormat("2"),
			shared.NewListNodeFromFormat("2"),
		},
		{
			shared.NewListNodeFromFormat("2"),
			nil,
			shared.NewListNodeFromFormat("2"),
		},
		{
			shared.NewListNodeFromFormat("1"),
			shared.NewListNodeFromFormat("2"),
			shared.NewListNodeFromFormat("1->2"),
		},
		{
			shared.NewListNodeFromFormat("3"),
			shared.NewListNodeFromFormat("1->2->4"),
			shared.NewListNodeFromFormat("1->2->3->4"),
		},
		{
			shared.NewListNodeFromFormat("1->2->4"),
			shared.NewListNodeFromFormat("3"),
			shared.NewListNodeFromFormat("1->2->3->4"),
		},
		{
			shared.NewListNodeFromFormat("1->2->4"),
			shared.NewListNodeFromFormat("1->3->4"),
			shared.NewListNodeFromFormat("1->1->2->3->4->4"),
		},
		{
			shared.NewListNodeFromFormat("-1->-2"),
			shared.NewListNodeFromFormat("1->2"),
			shared.NewListNodeFromFormat("-1->-2->1->2"),
		},
	}

	for i, c := range cases {
		t.Run(fmt.Sprintf("No.%v", i), func(t *testing.T) {
			if actual := mergeTwoLists(c.l1, c.l2); c.expected.String() != actual.String() {
				t.Errorf("failed \nexpected = %v\nactual = %v", c.expected, actual)
			}
		})
	}
}
