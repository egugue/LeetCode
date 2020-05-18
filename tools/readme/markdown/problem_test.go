package markdown

import (
	tu "github.com/egugue/LeetCode/tools/readme/internal/testutil"
	"github.com/egugue/LeetCode/tools/readme/leetcode"
	"github.com/egugue/LeetCode/tools/readme/solution"
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

func Test_filterUnnecessaryProblems(t *testing.T) {
	tests := map[string]struct {
		problems       *leetcode.ProblemResponse
		solutionsTable *solution.SolutionsTable
		expected       []leetcode.StatStatusPairs
	}{
		"should drop problems such that unsolved, hidden, or paid only": {
			problems: tu.NewProblemResponse(
				*tu.NewStatStatusPairs(tu.StatWith(tu.FrontendQuestionID(1))),
				*tu.NewStatStatusPairs(tu.StatWith(tu.FrontendQuestionID(2))),
				*tu.NewStatStatusPairs(tu.StatWith(tu.FrontendQuestionID(3))),
				*tu.NewStatStatusPairs(tu.StatWith(tu.FrontendQuestionID(4), tu.QuestionHide(true))),
				*tu.NewStatStatusPairs(tu.StatWith(tu.FrontendQuestionID(5)), tu.PaidOnly(true)),
			),
			solutionsTable: &solution.SolutionsTable{
				solution.Java: tu.NewSolutions(
					*tu.NewSolution(tu.ProblemID(1)),
					*tu.NewSolution(tu.ProblemID(2)),
					*tu.NewSolution(tu.ProblemID(4)),
					*tu.NewSolution(tu.ProblemID(5)),
				),
				solution.Python3: tu.NewSolutions(
					*tu.NewSolution(tu.ProblemID(1)),
				),
			},
			expected: []leetcode.StatStatusPairs{
				*tu.NewStatStatusPairs(tu.StatWith(tu.FrontendQuestionID(1))),
				*tu.NewStatStatusPairs(tu.StatWith(tu.FrontendQuestionID(2))),
				*tu.NewStatStatusPairs(tu.StatWith(tu.FrontendQuestionID(3))),
			},
		},
	}

	for name, tt := range tests {
		t.Run(name, func(t *testing.T) {
			filterUnnecessaryProblems(tt.problems, tt.solutionsTable)
			assert.Equal(t, tt.expected, tt.problems.StatStatusPairs)
		})
	}
}
