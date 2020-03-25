package _01

import (
	"fmt"
	"reflect"
	"testing"
)

func TestTwoSum(t *testing.T) {
	cases := []struct {
		nums     []int
		target   int
		expected []int
	}{
		{
			[]int{2, 7, 11, 15},
			9,
			[]int{0, 1},
		},
	}

	for i, c := range cases {
		t.Run(fmt.Sprintf("No.%v", i), func(t *testing.T) {
			if actual := twoSum(c.nums, c.target); !reflect.DeepEqual(c.expected, actual) {
				t.Errorf("twoSum: \n expected = %v, \n actual = %v", c.expected, actual)
			}
		})
	}
}
