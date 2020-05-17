package main

import (
	"github.com/egugue/LeetCode/tools/readme/leetcode"
	"github.com/egugue/LeetCode/tools/readme/markdown"
	"github.com/egugue/LeetCode/tools/readme/solution"
	"go.uber.org/zap"
	"log"
	"os"
	"path"
	"runtime"
)

func main() {
	os.Exit(run())
}

func run() int {
	logger, err := zap.NewDevelopment()
	if err != nil {
		log.Fatalf("Initialization error.\n%v\n", err)
		return 1
	}
	defer logger.Sync()
	undo := zap.ReplaceGlobals(logger)
	defer undo()

	_, filename, _, _ := runtime.Caller(0)
	dir := path.Dir(filename)
	solutionsTable, err := solution.ReadSolutionsTable(dir + "/assets/solutions/")
	if err != nil {
		zap.S().Errorf("couldn't read json\n %v \n", err)
		return 1
	}

	response, err := leetcode.GetProblemResponse()
	if err != nil {
		zap.S().Errorf("couldn't retrieve problems\n%v\n", err)
		return 1
	}

	err = markdown.WriteREADME(response, solutionsTable)
	if err != nil {
		zap.S().Errorf("couldn't write README\n%v\n", err)
		return 1
	}

	return 0
}
