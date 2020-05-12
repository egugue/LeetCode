package markdown

import (
	"github.com/egugue/LeetCode/tools/readme/leetcode"
	. "github.com/egugue/LeetCode/tools/readme/leetcode/leetcodetest"
	"github.com/egugue/LeetCode/tools/readme/solution"
	. "github.com/egugue/LeetCode/tools/readme/solution/solutiontest"
	"github.com/stretchr/testify/assert"
	"testing"
)

func Test_newDifficulty(t *testing.T) {
	tests := map[string]struct {
		difficulty *leetcode.Difficulty
		expected   difficulty
	}{
		"should return easy": {
			difficulty: &leetcode.Difficulty{Level: leetcode.DifficultyEasy},
			expected:   easy,
		},
		"should return medium": {
			difficulty: &leetcode.Difficulty{Level: leetcode.DifficultyMedium},
			expected:   medium,
		},
		"should return hard": {
			difficulty: &leetcode.Difficulty{Level: leetcode.DifficultyHard},
			expected:   hard,
		},
	}
	for name, tt := range tests {
		t.Run(name, func(t *testing.T) {
			assert.Equal(t, tt.expected, newDifficulty(tt.difficulty))
		})
	}
}

func Test_filterProblems(t *testing.T) {
	tests := map[string]struct {
		problems       *leetcode.Problems
		solutionsTable *solution.SolutionsTable
		expected       []leetcode.StatStatusPairs
	}{
		"should drop problems such that unsolved, hidden, or paid only": {
			problems: NewProblems(
				*NewStatStatusPairs(StatWith(FrontendQuestionID(1))),
				*NewStatStatusPairs(StatWith(FrontendQuestionID(2))),
				*NewStatStatusPairs(StatWith(FrontendQuestionID(3))),
				*NewStatStatusPairs(StatWith(FrontendQuestionID(4), QuestionHide(true))),
				*NewStatStatusPairs(StatWith(FrontendQuestionID(5)), PaidOnly(true)),
			),
			solutionsTable: &solution.SolutionsTable{
				solution.JavaKotlin: NewSolutions(
					*NewSolution(ProblemID(1)),
					*NewSolution(ProblemID(2)),
					*NewSolution(ProblemID(4)),
					*NewSolution(ProblemID(5)),
				),
				solution.Python3: NewSolutions(
					*NewSolution(ProblemID(1)),
				),
			},
			expected: []leetcode.StatStatusPairs{
				*NewStatStatusPairs(StatWith(FrontendQuestionID(1))),
				*NewStatStatusPairs(StatWith(FrontendQuestionID(2))),
				*NewStatStatusPairs(StatWith(FrontendQuestionID(3))),
			},
		},
	}

	for name, tt := range tests {
		t.Run(name, func(t *testing.T) {
			filterProblems(tt.problems, tt.solutionsTable)
			assert.Equal(t, tt.expected, tt.problems.StatStatusPairs)
		})
	}
}
