package testutil

import "github.com/egugue/LeetCode/tools/readme/leetcode"

func NewProblemResponse(pairs ...leetcode.StatStatusPairs) *leetcode.ProblemResponse {
	return &leetcode.ProblemResponse{
		StatStatusPairs: pairs,
	}
}

type statStatusPairsParam struct {
	stat       leetcode.Stat
	difficulty int
	paidOnly   bool
}

type StatStatusPairsOption func(p *statStatusPairsParam)

func Stat(stat leetcode.Stat) StatStatusPairsOption {
	return func(p *statStatusPairsParam) {
		p.stat = stat
	}
}

func StatWith(options ...StatOption) StatStatusPairsOption {
	return func(p *statStatusPairsParam) {
		p.stat = *NewStat(options...)
	}
}

func Difficulty(level int) StatStatusPairsOption {
	return func(p *statStatusPairsParam) {
		p.difficulty = level
	}
}

func PaidOnly(paidOnly bool) StatStatusPairsOption {
	return func(p *statStatusPairsParam) {
		p.paidOnly = paidOnly
	}
}

func NewStatStatusPairs(options ...StatStatusPairsOption) *leetcode.StatStatusPairs {
	p := &statStatusPairsParam{
		stat:       *NewStat(),
		difficulty: 1,
		paidOnly:   false,
	}

	for _, option := range options {
		option(p)
	}

	return &leetcode.StatStatusPairs{
		Stat:       p.stat,
		Difficulty: leetcode.Difficulty{Level: p.difficulty},
		PaidOnly:   p.paidOnly,
	}
}

type statParam struct {
	questionId int
	// QuestionArticleLive bool
	// QuestionArticleSlug string
	questionTitle     string
	questionTitleSlug string
	questionHide      bool
	// TotalAcs            int
	// TotalSubmitted      int
	frontendQuestionId int
	// IsNewQuestion       bool
}

type StatOption func(p *statParam)

func QuestionHide(hide bool) StatOption {
	return func(p *statParam) {
		p.questionHide = hide
	}
}

func FrontendQuestionID(id int) StatOption {
	return func(p *statParam) {
		p.frontendQuestionId = id
	}
}

func NewStat(options ...StatOption) *leetcode.Stat {
	p := &statParam{
		questionId:         1,
		questionTitle:      "Two Sum",
		questionTitleSlug:  "two-sum",
		questionHide:       false,
		frontendQuestionId: 1,
	}

	for _, option := range options {
		option(p)
	}

	return &leetcode.Stat{
		QuestionId:         p.questionId,
		QuestionTitle:      p.questionTitle,
		QuestionTitleSlug:  p.questionTitleSlug,
		QuestionHide:       p.questionHide,
		FrontendQuestionId: p.questionId,
	}
}
