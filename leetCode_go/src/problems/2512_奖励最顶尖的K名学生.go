package problems

import (
	"sort"
	"strings"
)

func topStudents(positive_feedback []string, negative_feedback []string, report []string, student_id []int, k int) []int {
	wordScoreMap := map[string]int{}
	for _, word := range positive_feedback {
		wordScoreMap[word] = 3
	}
	for _, word := range negative_feedback {
		wordScoreMap[word] = -1
	}
	calculateScore := func(rep string) int {
		split := strings.Split(rep, " ")
		var sc int
		for _, wd := range split {
			sc += wordScoreMap[wd]
		}
		return sc
	}
	scoreMap := map[int]int{}
	for idx, rep := range report {
		scoreMap[student_id[idx]] = calculateScore(rep)
	}
	sort.Slice(student_id, func(i, j int) bool {
		iid, jid := student_id[i], student_id[j]
		if scoreMap[iid] > scoreMap[jid] {
			return true
		} else if scoreMap[iid] == scoreMap[jid] && iid < jid {
			return true
		}
		return false
	})
	return student_id[:k]
}
