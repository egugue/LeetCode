package _53

import (
	"fmt"
	"github.com/stretchr/testify/assert"
	"testing"
)

func TestMaxSubArray(t *testing.T) {
	cases := []struct {
		in       []int
		expected int
	}{
		{nil, 0},
		{[]int{-2, 1, -3, 4, -1, 2, 1, -5, 4}, 6},
		{[]int{-2, 4, 1, -9, 3, 1}, 5},
		{[]int{-2, -4, -10, -9, -3, -9}, -2},
	}

	for i, c := range cases {
		t.Run(fmt.Sprintf("Test:No.%v", i), func(t *testing.T) {
			assert.Equal(t, c.expected, maxSubArray(c.in))
		})
	}
}
