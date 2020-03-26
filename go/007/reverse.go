package _07

import "math"

// 4 ms	2.2 MB
func reverse(x int) int {
	var cur int64

	for x != 0 {
		cur *= 10
		cur += int64(x % 10)
		if cur < math.MinInt32 || cur > math.MaxInt32 {
			return 0
		}
		x /= 10
	}

	return int(cur)
}
