package shared

import (
	"strconv"
	"strings"
)

type ListNode struct {
	Val  int
	Next *ListNode
}

func (root *ListNode) String() string {
	var sb strings.Builder
	cur := root
	for cur != nil {
		sb.WriteString(strconv.Itoa(cur.Val))
		sb.WriteString("->")
		cur = cur.Next
	}
	sb.WriteString("nil")
	return sb.String()
}

func (root *ListNode) ToSlice() []int {
	var res []int
	cur := root
	for cur != nil {
		res = append(res, cur.Val)
		cur = cur.Next
	}
	return res
}

func NewListNodeFromFormat(str string) (root *ListNode) {
	var nums []int
	for _, sp := range strings.Split(str, "->") {
		n, err := strconv.Atoi(sp)
		if err != nil {
			panic("unexpected format")
		}
		nums = append(nums, n)
	}
	if len(nums) == 0 {
		return nil
	}

	root = &ListNode{Val: nums[0]}
	cur := root
	for i := 1; i < len(nums); i++ {
		cur.Next = &ListNode{Val: nums[i]}
		cur = cur.Next
	}
	return root
}

func NewListNodeFromNums(nums []int) *ListNode {
	if len(nums) == 0 {
		return nil
	}

	root := &ListNode{Val: nums[0]}
	cur := root
	for i := 1; i < len(nums); i++ {
		node := ListNode{Val: nums[i]}
		cur.Next = &node
		cur = cur.Next
	}

	return root
}
