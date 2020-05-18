package testutil

import (
	"github.com/egugue/LeetCode/tools/readme/solution"
)

func NewSolutions(solutions ...solution.Solution) solution.Solutions {
	result := make(solution.Solutions)
	for _, s := range solutions {
		result[s.ProblemID] = append(result[s.ProblemID], s)
	}
	return result
}

type SolutionParam struct {
	ProblemID solution.ProblemID
	Path      string
}

type SolutionOption func(p *SolutionParam)

func ProblemID(id solution.ProblemID) SolutionOption {
	return func(p *SolutionParam) {
		p.ProblemID = id
	}
}

func Path(path string) SolutionOption {
	return func(p *SolutionParam) {
		p.Path = path
	}
}

func NewSolution(options ...SolutionOption) *solution.Solution {
	p := &SolutionParam{
		ProblemID: 1,
		Path:      "/path",
	}

	for _, option := range options {
		option(p)
	}

	s := solution.Solution{
		ProblemID: p.ProblemID,
		Path:      p.Path,
	}

	return &s
}
