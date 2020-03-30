package _53

import (
	"math"
)

// 4 ms	3.3 MB
func maxSubArray(nums []int) int {
	if len(nums) == 0 {
		return 0
	}

	i := 0
	cur := 0
	max := math.MinInt32
	for i < len(nums) {
		cur += nums[i]
		if max < cur {
			max = cur
		}
		i++
		if cur < 0 {
			cur = 0
		}
	}

	return max
}
