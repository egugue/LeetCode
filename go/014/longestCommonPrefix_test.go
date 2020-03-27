package _14

import (
	"fmt"
	"testing"
)

func TestLongestCommonPrefix(t *testing.T) {
	cases := []struct {
		in       []string
		expected string
	}{
		{[]string{"flower", "flow", "flight"}, "fl"},
		{[]string{"dog", "racecar", "car"}, ""},
		{[]string{"babb", "caa"}, ""},
		{[]string{"abca", "abc"}, "abc"},
	}

	for i, c := range cases {
		t.Run(fmt.Sprintf("No.%v", i), func(t *testing.T) {
			if actual := longestCommonPrefix(c.in); c.expected != actual {
				t.Errorf("failed \nexpected = %v\nactual = %v", c.expected, actual)
			}
		})
	}
}
