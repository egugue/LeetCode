package _01

// 4 ms	3.8 MB
func twoSum(nums []int, target int) []int {
	table := make(map[int]int)
	for i, num := range nums {
		if otherI, ok := table[target-num]; ok {
			return []int{otherI, i}
		}
		table[num] = i
	}
	return []int{}
}
