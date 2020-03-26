package _03

import (
	"fmt"
	"testing"
)

func TestLengthOfLongestSubstring(t *testing.T) {
	cases := []struct {
		in       string
		expected int
	}{
		{"abcabcbb", 3},
		{"bbbbb", 1},
		{"pwwkew", 3},
	}

	for i, c := range cases {
		t.Run(fmt.Sprintf("No.%v", i), func(t *testing.T) {
			if actual := lengthOfLongestSubstring(c.in); c.expected != actual {
				t.Errorf("failed \nexpected = %v\nactual = %v", c.expected, actual)
			}
		})
	}
}
