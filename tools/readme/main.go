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
	setUpLogger()

	response, err := leetcode.GetProblemResponse()
	if err != nil {
		zap.S().Errorf("couldn't retrieve problems\n%v\n", err)
		os.Exit(1)
	}

	solutionsTable := solution.GetAllSolutions()

	err = markdown.WriteREADME(response, &solutionsTable)
	if err != nil {
		zap.S().Errorf("couldn't write README\n%v\n", err)
	}
}

func setUpLogger() {
	logger, err := zap.NewDevelopment()
	if err != nil {
		log.Fatalf("Initialization error.\n%v\n", err)
	}
	defer logger.Sync()
	undo := zap.ReplaceGlobals(logger)
	defer undo()

}
