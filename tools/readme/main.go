package main

import (
	"fmt"
	"github.com/egugue/LeetCode/tools/readme/leetcode"
	"os"
)

func main() {
	problems, err := leetcode.GetAllProblems()
	if err != nil {
		//noinspection ALL
		fmt.Fprintf(os.Stderr, "couldn't retrieve problems.\n%v\n", err)
		os.Exit(1)
	}

	for _, pairs := range problems.StatStatusPairs[:20] {
		fmt.Printf("%v\n", pairs)
	}
}
