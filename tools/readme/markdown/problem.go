package markdown

import (
	"github.com/egugue/LeetCode/tools/readme/leetcode"
	"github.com/egugue/LeetCode/tools/readme/solution"
	"sort"
)

type difficulty int8

func (d difficulty) String() string {
	switch d {
	case easy:
		return "Easy"
	case medium:
		return "Medium"
	case hard:
		return "Hard"
	}
	return ""
}

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

type Problems []problem

type problem struct {
	id         solution.ProblemID
	title      string
	url        string
	difficulty difficulty
	solutions  map[solution.Language][]solution.Solution
}

func newSortedProblems(response *leetcode.ProblemResponse, solutionsTable *solution.SolutionsTable) Problems {
	filterUnnecessaryProblems(response, solutionsTable)

	problems := make(Problems, len((*response).StatStatusPairs))
	for i, pair := range (*response).StatStatusPairs {
		id := solution.ProblemID(pair.Stat.FrontendQuestionId)

		solutions := make(map[solution.Language][]solution.Solution)
		for _, language := range solution.Languages {
			s, ok := (*solutionsTable)[language][id]
			if !ok {
				continue
			}
			solutions[language] = s
		}

		problems[i] = problem{
			id:         id,
			title:      pair.Stat.QuestionTitle,
			url:        pair.Stat.QuestionUrl(),
			difficulty: newDifficulty(&pair.Difficulty),
			solutions:  solutions,
		}
	}

	sort.Slice(problems, func(i, j int) bool {
		return problems[i].id < problems[j].id
	})

	return problems
}

func filterUnnecessaryProblems(problem *leetcode.ProblemResponse, solutionsTable *solution.SolutionsTable) {
	idSet := solutionsTable.GetAllProblemIDSet()
	problem.Filter(func(pairs *leetcode.StatStatusPairs) bool {
		ok, _ := idSet[solution.ProblemID(pairs.Stat.FrontendQuestionId)]
		return ok && !pairs.PaidOnly && !pairs.Stat.QuestionHide
	})
}
