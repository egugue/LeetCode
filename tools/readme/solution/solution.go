package solution

type Language int
type ProblemID int

const (
	JavaKotlin Language = iota
	Python3
)

var Languages = []Language{
	JavaKotlin, Python3,
}

type Solution struct {
	ProblemID ProblemID
	URL       string
}

type Solutions map[ProblemID][]Solution

type SolutionsTable map[Language]Solutions

func (s *Solutions) SolvedCount() int {
	return len(*s)
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

func GetAllSolutions() SolutionsTable {
	r := make(map[Language]Solutions)
	r[Python3] = getPython3Solutions()
	return r
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
		{ProblemID: 1, URL: "111"},
		{ProblemID: 2, URL: "222"},
	}
	return buildSolutions(response)
}
