package markdown

import (
	"fmt"
	"github.com/egugue/LeetCode/tools/readme/leetcode"
	"github.com/egugue/LeetCode/tools/readme/solution"
	"os"
	. "strconv"
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
	var sb strings.Builder
	sb.WriteString(` 
This repo commits only free problems.  
https://leetcode.com/egugue/

| # | Title | Difficulty | `)
	for _, language := range solution.Languages {
		sb.WriteString(language.String() + " (" + Itoa(stat.solvedCount[language]) + ") | ")
	}

	if _, err := fmt.Fprintln(f, sb.String()); err != nil {
		return err
	}

	sb.Reset()
	sb.WriteString("| :---: | :--- | :---: | ")
	for range solution.Languages {
		sb.WriteString(" :---: | ")
	}
	_, err := fmt.Fprintln(f, sb.String())
	return err
}

func writeRow(f *os.File, problem *problem) error {
	elements := []interface{}{problem.id, problem.title, problem.difficulty}
	for _, language := range solution.Languages {
		elements = append(elements, buildSolutionsText(problem.solutions[language]))
	}

	var sb strings.Builder
	sb.WriteString("| ")
	for range elements {
		sb.WriteString("%v")
		sb.WriteString(" | ")
	}
	sb.WriteString("\n")

	_, err := fmt.Fprintf(f, sb.String(), elements...)
	return err
}

func buildSolutionsText(solutions []solution.Solution) string {
	if len(solutions) == 0 {
		return " - "
	}

	var sb strings.Builder
	for i, s := range solutions {
		sb.WriteString("[Solution_")
		sb.WriteString(Itoa(i + 1))
		sb.WriteString("](")
		sb.WriteString(s.Path)
		sb.WriteString(")<br>")
	}
	return sb.String()
}
