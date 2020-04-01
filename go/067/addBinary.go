package _67

import (
	"strconv"
	"strings"
)

// 0 ms	2.2 MB
func addBinary(a string, b string) string {
	ai, bi := len(a)-1, len(b)-1
	var carry byte
	var bytes []byte
	for ai >= 0 || bi >= 0 {
		var av, bv byte = '0', '0'
		if ai >= 0 {
			av = a[ai]
		}
		if bi >= 0 {
			bv = b[bi]
		}

		var bit byte
		bit, carry = sum(av, bv, carry)
		bytes = append(bytes, bit)
		ai--
		bi--
	}

	if carry == 1 {
		bytes = append(bytes, 1)
	}

	var sb strings.Builder
	for i := range bytes {
		b := bytes[len(bytes)-i-1]
		sb.WriteString(strconv.Itoa(int(b)))
	}
	return sb.String()
}

func sum(a, b byte, carry byte) (bit byte, newCarry byte) {
	sum := a - '0' + b - '0' + carry
	return sum % 2, sum / 2
}
