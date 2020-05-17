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
	logger, err := zap.NewDevelopment()
	if err != nil {
		log.Fatalf("Initialization error.\n%v\n", err)
	}
	defer logger.Sync()
	undo := zap.ReplaceGlobals(logger)
	defer undo()

	_, filename, _, _ := runtime.Caller(0)
	dir := path.Dir(filename)
	solutionsTable, err := solution.ReadSolutionsTable(dir + "/assets/solutions/")
	if err != nil {
		zap.S().Errorf("couldn't read json\n %v \n", err)
		os.Exit(1)
	}

	response, err := leetcode.GetProblemResponse()
	if err != nil {
		zap.S().Errorf("couldn't retrieve problems\n%v\n", err)
		os.Exit(1)
	}

	err = markdown.WriteREADME(response, solutionsTable)
	if err != nil {
		zap.S().Errorf("couldn't write README\n%v\n", err)
		os.Exit(1)
	}
}
