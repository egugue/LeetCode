package markdown

import (
	tu "github.com/egugue/LeetCode/tools/readme/internal/testutil"
	"github.com/egugue/LeetCode/tools/readme/solution"
	"github.com/stretchr/testify/assert"
	"testing"
)

func Test_newStat(t *testing.T) {
	tests := map[string]struct {
		table    solution.SolutionsTable
		expected stat
	}{
		"should count solved problems": {
			table: solution.SolutionsTable{
				solution.JavaKotlin: tu.NewSolutions(
					*tu.NewSolution(tu.ProblemID(1)),
					*tu.NewSolution(tu.ProblemID(2)),
					*tu.NewSolution(tu.ProblemID(3)),
				),
				solution.Python3: tu.NewSolutions(
					*tu.NewSolution(tu.ProblemID(1)),
					*tu.NewSolution(tu.ProblemID(20)),
				),
			},
			expected: stat{
				solvedCount: map[solution.Language]int{
					solution.JavaKotlin: 3,
					solution.Python3:    2,
				},
			},
		},
		"should count 0 if not any solved problems": {
			table: solution.SolutionsTable{
				solution.JavaKotlin: tu.NewSolutions(),
				solution.Python3:    tu.NewSolutions(),
			},
			expected: stat{
				solvedCount: map[solution.Language]int{
					solution.JavaKotlin: 0,
					solution.Python3:    0,
				},
			},
		},
	}

	for name, tt := range tests {
		t.Run(name, func(t *testing.T) {
			actual := newStat(tt.table)
			assert.Equal(t, tt.expected, actual)
		})
	}
}
