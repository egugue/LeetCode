package _17

var table = [][]string{
	{},
	{},
	{"a", "b", "c"},
	{"d", "e", "f"},
	{"g", "h", "i"},
	{"j", "k", "l"},
	{"m", "n", "o"},
	{"p", "q", "r", "s"},
	{"t", "u", "v"},
	{"w", "x", "y", "z"},
}

// 0 ms	2 MB
func letterCombinations(digits string) []string {
	if len(digits) == 0 {
		return nil
	}
	var combinations []string
	helper(0, "", digits, &combinations)
	return combinations
}

func helper(index int, builder string, digits string, combinations *[]string) {
	if len(builder) == len(digits) {
		*combinations = append(*combinations, builder)
		return
	}

	num := digits[index] - '0'
	for _, letter := range table[num] {
		helper(index+1, builder+letter, digits, combinations)
	}
}
