package markdown

import (
	"github.com/egugue/LeetCode/tools/readme/solution"
	"github.com/egugue/LeetCode/tools/readme/solution/solutiontest"
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
				solution.JavaKotlin: solutiontest.NewSolutions(
					*solutiontest.NewSolution(solutiontest.ProblemID(1)),
					*solutiontest.NewSolution(solutiontest.ProblemID(2)),
					*solutiontest.NewSolution(solutiontest.ProblemID(3)),
				),
				solution.Python3: solutiontest.NewSolutions(
					*solutiontest.NewSolution(solutiontest.ProblemID(1)),
					*solutiontest.NewSolution(solutiontest.ProblemID(20)),
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
				solution.JavaKotlin: solutiontest.NewSolutions(),
				solution.Python3: solutiontest.NewSolutions(
					*solutiontest.NewSolution(solutiontest.ProblemID(1)),
					*solutiontest.NewSolution(solutiontest.ProblemID(20)),
				),
			},
			expected: stat{
				solvedCount: map[solution.Language]int{
					solution.JavaKotlin: 3,
					solution.Python3:    2,
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
