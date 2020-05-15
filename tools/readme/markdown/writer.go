package markdown

import (
	"fmt"
	"github.com/egugue/LeetCode/tools/readme/leetcode"
	"github.com/egugue/LeetCode/tools/readme/solution"
	"os"
	"strconv"
	"strings"
)

func WriteREADME(response *leetcode.ProblemResponse, solutionsTable *solution.SolutionsTable) error {
	problems := newSortedProblems(response, solutionsTable)
	stat := newStat(solutionsTable)

	// TODO
	file, err := os.Create("test.md")
	if err != nil {
		return err
	}
	defer file.Close()

	if err = writeHeader(file, &stat); err != nil {
		return err
	}

	for _, p := range problems {
		if err = writeRow(file, &p); err != nil {
			return err
		}
	}

	return nil
}

func writeHeader(f *os.File, stat *stat) error {
	// TODO: create header using solutions.Languages dynamically
	head := `
| # | Title | Difficulty | Java (%v) | Python3 (%v) |
| --- | --- | --- | --- | --- |
`
	_, err := fmt.Fprintf(f,
		head,
		stat.solvedCount[solution.Java],
		stat.solvedCount[solution.Python3],
	)
	return err
}

func writeRow(f *os.File, problem *problem) error {
	// TODO: create header using solutions.Languages dynamically
	format := "| %v | %v | %v | %v | %v |\n"

	solutionTexts := []interface{}{problem.id, problem.title, problem.difficulty}
	for _, language := range solution.Languages {
		solutionTexts = append(solutionTexts, buildSolutionsText(problem.solutions[language]))
	}

	_, err := fmt.Fprintf(f,
		format,
		solutionTexts...,
	)
	return err
}

func buildSolutionsText(solutions []solution.Solution) string {
	var sb strings.Builder
	for i, s := range solutions {
		sb.WriteString("[Solution_")
		sb.WriteString(strconv.Itoa(i + 1))
		sb.WriteString("](")
		sb.WriteString(s.Path)
		sb.WriteString(")<br>")
	}
	return sb.String()
}
