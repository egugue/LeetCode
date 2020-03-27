package _14

import "strings"

// 0 ms	2.4 MB
func longestCommonPrefix(strs []string) string {
	if len(strs) == 0 {
		return ""
	}

	for j := 0; j < len(strs[0]); j++ {
		first := strs[0][j]
		for i := 1; i < len(strs); i++ {
			if len(strs[i]) <= j || first != strs[i][j] {
				return strs[0][0:j]
			}
		}
	}

	return strs[0]
}

// 0 ms	2.4 MB
func longestCommonPrefix_(strs []string) string {
	if len(strs) == 0 {
		return ""
	}

	i := 0
	var sb strings.Builder
	for {
		if isSameChar(i, strs) {
			sb.WriteString(strs[0][i : i+1])
		} else {
			break
		}
		i++
	}
	return sb.String()
}

func isSameChar(i int, strs []string) bool {
	for _, str := range strs {
		if len(str) <= i {
			return false
		}
	}

	first := strs[0][i]
	for j := 1; j < len(strs); j++ {
		other := strs[j][i]
		if first != other {
			return false
		}
	}
	return true
}
