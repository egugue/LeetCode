package main

import (
	"github.com/egugue/LeetCode/tools/readme/leetcode"
	"github.com/egugue/LeetCode/tools/readme/markdown"
	"github.com/egugue/LeetCode/tools/readme/solution"
	"go.uber.org/zap"
	"log"
	"os"
)

func main() {
	logger, err := zap.NewDevelopment()
	if err != nil {
		log.Fatalf("Initialization error.\n%v\n", err)
	}
	defer logger.Sync()
	undo := zap.ReplaceGlobals(logger)
	defer undo()

	response, err := leetcode.GetProblemResponse()
	if err != nil {
		zap.S().Error("couldn't retrieve problems\n%v\n", err)
		os.Exit(1)
	}

	solutionsTable := solution.GetAllSolutions()

	err = markdown.WriteREADME(response, &solutionsTable)
	if err != nil {
		zap.S().Error("couldn't write README\n%v\n", err)
	}
}
