package _07

import (
	"fmt"
	"math"
	"testing"
)

func TestReverse(t *testing.T) {
	cases := []struct {
		in       int
		expected int
	}{
		{0, 0},
		{1, 1},
		{-1, -1},
		{123, 321},
		{-123, -321},
		{120, 21},
		{1020, 201},
		{math.MaxInt32, 0},
		{math.MinInt32, 0},
	}

	for i, c := range cases {
		t.Run(fmt.Sprintf("No.%v", i), func(t *testing.T) {
			if actual := reverse(c.in); c.expected != actual {
				t.Errorf("failed \nexpected = %v\nactual = %v", c.expected, actual)
			}
		})
	}
}
