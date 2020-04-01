package _67

import (
	"fmt"
	"github.com/stretchr/testify/assert"
	"testing"
)

func TestAddBinary(t *testing.T) {
	cases := []struct {
		a        string
		b        string
		expected string
	}{
		{"11", "1", "100"},
		{"1010", "1011", "10101"},
	}

	for i, c := range cases {
		t.Run(fmt.Sprintf("Test:No.%v", i), func(t *testing.T) {
			assert.Equal(t, c.expected, addBinary(c.a, c.b))
		})
	}
}
