package _17

import (
	"fmt"
	"github.com/stretchr/testify/assert"
	"testing"
)

func TestLetterCombinations(t *testing.T) {
	cases := []struct {
		in       string
		expected []string
	}{
		{"", nil},
		{"2", []string{"a", "b", "c"}},
		{"23", []string{"ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"}},
	}

	for i, c := range cases {
		t.Run(fmt.Sprintf("No.%v", i), func(t *testing.T) {
			actual := letterCombinations(c.in)
			assert.ElementsMatch(t, actual, c.expected)
		})
	}
}
