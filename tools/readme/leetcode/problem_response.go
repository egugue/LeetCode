package leetcode

import (
	"encoding/json"
	"io/ioutil"
	"net/http"
)

type ProblemResponse struct {
	StatStatusPairs []StatStatusPairs `json:"stat_status_pairs"`
}

type StatStatusPairs struct {
	Stat Stat `json:"stat"`
	// Status     string     `json:"status"`
	Difficulty Difficulty `json:"difficulty"`
	PaidOnly   bool       `json:"paid_only"`
	// IsFavor    bool       `json:"is_favor"`
	// Frequency  int        `json:"frequency"`
	// Progress   int        `json:"progress"`
}

type Stat struct {
	QuestionId int `json:"question_id"`
	// QuestionArticleLive bool   `json:"question__article__live"`
	// QuestionArticleSlug string `json:"question__article__slug"`
	QuestionTitle     string `json:"question__title"`
	QuestionTitleSlug string `json:"question__title_slug"`
	QuestionHide      bool   `json:"question__hide"`
	// TotalAcs            int    `json:"total_acs"`
	// TotalSubmitted      int    `json:"total_submitted"`
	FrontendQuestionId int `json:"frontend_question_id"`
	// IsNewQuestion       bool   `json:"is_new_question"`
}

func (stat *Stat) QuestionUrl() string {
	return "https://leetcode.com/problems/" + stat.QuestionTitleSlug
}

type Difficulty struct {
	Level int `json:"level"`
}

const (
	DifficultyEasy = iota + 1
	DifficultyMedium
	DifficultyHard
)

func GetAllProblems() (*ProblemResponse, error) {
	resp, err := http.Get("https://leetcode.com/api/problems/all/")
	if err != nil {
		return nil, err
	}
	defer resp.Body.Close()

	body, err := ioutil.ReadAll(resp.Body)
	if err != nil {
		return nil, err
	}

	allProblems := &ProblemResponse{}
	if err := json.Unmarshal(body, &allProblems); err != nil {
		return nil, err
	}
	return allProblems, nil
}

func (problems *ProblemResponse) Filter(predicate func(*StatStatusPairs) bool) {
	i := 0
	for _, pair := range problems.StatStatusPairs {
		if predicate(&pair) {
			problems.StatStatusPairs[i] = pair
			i++
		}
	}
	problems.StatStatusPairs = problems.StatStatusPairs[:i]
}
