package markdown

import (
	"github.com/egugue/LeetCode/tools/readme/leetcode"
	"github.com/egugue/LeetCode/tools/readme/solution"
	"sort"
)

type difficulty int8

func newDifficulty(dif *leetcode.Difficulty) difficulty {
	switch dif.Level {
	case leetcode.DifficultyEasy:
		return easy
	case leetcode.DifficultyMedium:
		return medium
	case leetcode.DifficultyHard:
		return hard
	}
	return unknown
}

const (
	easy difficulty = iota
	medium
	hard
	unknown
)

type problems []problem

type problem struct {
	ID         solution.ProblemID
	title      string
	url        string
	difficulty difficulty
	solutions  map[solution.Language][]solution.Solution
}

func newSortedProblems(lProblems leetcode.Problems, solutionsTable solution.SolutionsTable) problems {
	idSet := solutionsTable.GetAllProblemIDSet()
	lProblems.Filter(func(pairs *leetcode.StatStatusPairs) bool {
		ok, _ := idSet[solution.ProblemID(pairs.Stat.FrontendQuestionId)]
		return ok && !pairs.PaidOnly && !pairs.Stat.QuestionHide
	})

	problems := make(problems, len(idSet))
	for _, pair := range lProblems.StatStatusPairs {
		id := solution.ProblemID(pair.Stat.FrontendQuestionId)

		solutions := make(map[solution.Language][]solution.Solution)
		for _, language := range solution.Languages {
			solutions[language] = solutionsTable[language][id]
		}

		problems = append(problems, problem{
			ID:         id,
			title:      pair.Stat.QuestionTitle,
			url:        pair.Stat.QuestionUrl(),
			difficulty: newDifficulty(&pair.Difficulty),
			solutions:  solutions,
		})
	}

	sort.Slice(problems, func(i, j int) bool {
		return problems[i].ID < problems[j].ID
	})

	return problems
}

func filterProblems(problem *leetcode.Problems, solutionsTable *solution.SolutionsTable) {
	idSet := solutionsTable.GetAllProblemIDSet()
	problem.Filter(func(pairs *leetcode.StatStatusPairs) bool {
		ok, _ := idSet[solution.ProblemID(pairs.Stat.FrontendQuestionId)]
		return ok && !pairs.PaidOnly && !pairs.Stat.QuestionHide
	})
}
