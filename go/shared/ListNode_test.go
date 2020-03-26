package shared

import (
	"fmt"
	"testing"
)

func TestListNode_String(t *testing.T) {
	cases := []struct {
		r        *ListNode
		expected string
	}{
		{NewListNodeFromNums([]int{}), "nil"},
		{NewListNodeFromNums([]int{10}), "10->nil"},
		{NewListNodeFromNums([]int{10, 20, 30}), "10->20->30->nil"},
	}

	for i, c := range cases {
		t.Run(fmt.Sprintf("No.%v", i), func(t *testing.T) {
			if actual := c.r.String(); c.expected != actual {
				t.Errorf("failed \nexpected = %v\nactual = %v", c.expected, actual)
			}
		})
	}
}
