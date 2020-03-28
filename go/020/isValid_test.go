package _20

import (
	"fmt"
	"github.com/stretchr/testify/assert"
	"testing"
)

func TestIsValid(t *testing.T) {
	cases := []struct {
		in       string
		expected bool
	}{
		{"(", false},
		{"()", true},
		{"(){}[]", true},
		{"(]", false},
		{"([)]", false},
		{"{[]}", true},
	}

	for _, c := range cases {
		t.Run(fmt.Sprintf("Test:\"%v\"", c.in), func(t *testing.T) {
			assert.Equal(t, c.expected, isValid(c.in))
		})
	}
}
