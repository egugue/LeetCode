package _09

import (
	"fmt"
	"math"
	"testing"
)

func TestIsPalindrome(t *testing.T) {
	cases := []struct {
		in       int
		expected bool
	}{
		{math.MinInt32, false},
		{-121, false},
		{-1, false},
		{0, true},
		{1, true},
		{9, true},
		{10, false},
		{11, true},
		{121, true},
		{1221, true},
		{11211, true},
		{math.MaxInt32, false},
	}

	for i, c := range cases {
		t.Run(fmt.Sprintf("No.%v", i), func(t *testing.T) {
			if actual := isPalindrome(c.in); c.expected != actual {
				t.Errorf("failed \nexpected = %v\nactual = %v", c.expected, actual)
			}
		})
	}
}
