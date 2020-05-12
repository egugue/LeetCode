package leetcode

import (
	"github.com/stretchr/testify/assert"
	"testing"
)

func TestProblems_Filter(t *testing.T) {
	pairs := StatStatusPairs{
		Stat{
			QuestionId:         0,
			QuestionTitle:      "title",
			QuestionTitleSlug:  "titleSlug",
			QuestionHide:       false,
			FrontendQuestionId: 1,
		},
		Difficulty{
			Level: 1,
		},
		false,
	}

	problems := Problems{
		StatStatusPairs: []StatStatusPairs{},
	}

	problems.StatStatusPairs = append(problems.StatStatusPairs, pairs)

	toBeFiltered := pairs
	toBeFiltered.Stat.QuestionId = 1
	problems.StatStatusPairs = append(problems.StatStatusPairs, toBeFiltered)

	toBeFiltered = pairs
	toBeFiltered.Stat.QuestionId = 2
	toBeFiltered.Stat.QuestionHide = true
	problems.StatStatusPairs = append(problems.StatStatusPairs, toBeFiltered)

	toBeFiltered = pairs
	toBeFiltered.Stat.QuestionId = 3
	toBeFiltered.PaidOnly = true
	problems.StatStatusPairs = append(problems.StatStatusPairs, toBeFiltered)

	t.Run("filter", func(t *testing.T) {
		problems.Filter(func(pairs *StatStatusPairs) bool {
			con := pairs.Stat.QuestionId != 1 && !pairs.Stat.QuestionHide && !pairs.PaidOnly
			return con
		})
		assert.ElementsMatch(t, problems.StatStatusPairs, []StatStatusPairs{pairs})
	})
}
