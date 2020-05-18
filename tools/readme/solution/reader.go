package solution

import (
	"encoding/json"
	"io/ioutil"
	"path/filepath"
)

func ReadSolutionsTable(jsonDirPath string) (*SolutionsTable, error) {
	files, err := collectJsonFiles(jsonDirPath)
	if err != nil {
		return nil, err
	}
	table, err := readSolutionTable(files)
	return table, err
}

func readSolutionTable(filePaths []string) (*SolutionsTable, error) {
	table := SolutionsTable{}
	for _, path := range filePaths {
		language, solutions, err := readSolutions(path)
		if err != nil {
			return nil, err
		}

		table[*language] = *solutions
	}
	return &table, nil
}

func readSolutions(path string) (*Language, *Solutions, error) {
	bytes, err := ioutil.ReadFile(path)
	if err != nil {
		return nil, nil, err
	}

	sJson := struct {
		Language  Language   `json:"language"`
		Solutions []Solution `json:"solutions"`
	}{}

	if err := json.Unmarshal(bytes, &sJson); err != nil {
		return nil, nil, err
	}

	solutions := make(Solutions, len(sJson.Solutions))
	for _, s := range sJson.Solutions {
		solutions[s.ProblemID] = append(solutions[s.ProblemID], s)
	}

	return &sJson.Language, &solutions, nil
}

func collectJsonFiles(jsonDirPath string) ([]string, error) {
	files, err := ioutil.ReadDir(jsonDirPath)
	if err != nil {
		return nil, err
	}

	i := 0
	for _, file := range files {
		if filepath.Ext(file.Name()) == ".json" {
			files[i] = file
			i++
		}
	}
	files = files[:i]

	paths := make([]string, len(files))
	for i, file := range files {
		paths[i] = jsonDirPath + file.Name()
	}

	return paths, err
}
