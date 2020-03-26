package _03

// 8 ms	3.1 MB
func lengthOfLongestSubstring(s string) int {
	if len(s) == 0 {
		return 0
	}

	set := make(map[rune]bool)
	runes := []rune(s)
	i, j, max := 0, 0, 0

	for j < len(runes) {
		r := runes[j]
		if _, ok := set[r]; ok {
			delete(set, runes[i])
			i++
			continue
		}

		set[r] = true
		j++
		if max < len(set) {
			max = len(set)
		}
	}

	return max
}
