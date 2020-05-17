package solution

import "sort"

type Language string

func (l *Language) String() string {
	return string(*l)
}

type ProblemID int

type Solution struct {
	ProblemID ProblemID `json:"problem_id"`
	Path      string    `json:"path"`
}

type Solutions map[ProblemID][]Solution

type SolutionsTable map[Language]Solutions

func (s *Solutions) SolvedCount() int {
	return len(*s)
}

func (table *SolutionsTable) Languages() *[]Language {
	var languages []Language
	for language := range *table {
		languages = append(languages, language)
	}

	sort.SliceStable(languages, func(i, j int) bool {
		return languages[i] < languages[j]
	})

	return &languages
}

func (table *SolutionsTable) GetAllProblemIDSet() map[ProblemID]bool {
	idSet := make(map[ProblemID]bool)
	for _, solutions := range *table {
		for id := range solutions {
			idSet[id] = true
		}
	}
	return idSet
}

func buildSolutions(list []Solution) Solutions {
	solutions := make(Solutions, len(list))
	for _, s := range list {
		solutions[s.ProblemID] = append(solutions[s.ProblemID], s)
	}
	return solutions
}

func getPython3Solutions() Solutions {
	// TODO
	response := []Solution{
		{ProblemID: 1, Path: "111"},
		{ProblemID: 1, Path: "333"},
		{ProblemID: 2, Path: "222"},
		{ProblemID: 100, Path: "222"},
	}
	return buildSolutions(response)
}

func getJavaSolutions() Solutions {
	response := []Solution{
		{ProblemID: 3, Path: "222"},
	}
	return buildSolutions(response)
}
