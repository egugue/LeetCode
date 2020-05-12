package markdown

import (
	"github.com/egugue/LeetCode/tools/readme/solution"
)

type stat struct {
	solvedCount map[solution.Language]int
}

func newStat(table solution.SolutionsTable) stat {
	solvedCount := make(map[solution.Language]int)
	for key, value := range table {
		solvedCount[key] = len(value)
	}
	return stat{
		solvedCount: solvedCount,
	}
}
