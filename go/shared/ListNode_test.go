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

func TestNewListNodeFromFormat(t *testing.T) {
	cases := []struct {
		str      string
		expected *ListNode
	}{
		{"1", NewListNodeFromNums([]int{1})},
		{"1->2", NewListNodeFromNums([]int{1, 2})},
		{"1->2->3->4->5", NewListNodeFromNums([]int{1, 2, 3, 4, 5})},
		{"-1", NewListNodeFromNums([]int{-1})},
		{"-1->-2->-3->-4->-5", NewListNodeFromNums([]int{-1, -2, -3, -4, -5})},
	}

	for i, c := range cases {
		t.Run(fmt.Sprintf("No.%v", i), func(t *testing.T) {
			if actual := NewListNodeFromFormat(c.str); c.expected.String() != actual.String() {
				t.Errorf("failed \nexpected = %v\nactual = %v", c.expected.String(), actual.String())
			}
		})
	}
}

func TestNewListNodeFromFormat_Failure(t *testing.T) {
	cases := []string{
		"",
		"1->",
		"->1",
		"--1",
		"1-1",
	}

	for i, in := range cases {
		t.Run(fmt.Sprintf("No.%v", i), func(t *testing.T) {
			assertPanic(t, func() *ListNode { return NewListNodeFromFormat(in) })
		})
	}
}

func assertPanic(t *testing.T, f func() *ListNode) {
	var res *ListNode
	defer func() {
		r := recover()
		if r == nil {
			t.Errorf("panic did not call. res = %v", res)
		}
	}()
	res = f()
}
