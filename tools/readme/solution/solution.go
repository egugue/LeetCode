package solution

type Language int

const (
	Java Language = iota
	Python3
)

var Languages = []Language{
	Java, Python3,
}

func (l Language) String() string {
	switch l {
	case Java:
		return "Java"
	case Python3:
		return "Python3"

	}
	return ""
}

type ProblemID int

type Solution struct {
	ProblemID ProblemID
	Path      string
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
	r[Java] = getJavaSolutions()
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
