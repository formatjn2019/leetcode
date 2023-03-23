package test

import (
	"src/problems"
	"testing"
)

func TestBestTeamScore(t *testing.T) {
	println(problems.BestTeamScore([]int{1, 3, 5, 10, 15}, []int{1, 2, 3, 4, 5}))
	println(problems.BestTeamScore([]int{4, 5, 6, 5}, []int{2, 1, 2, 1}))
	println(problems.BestTeamScore([]int{1, 2, 3, 5}, []int{8, 9, 10, 1}))
	println(problems.BestTeamScore([]int{2, 6, 4, 5, 6, 5}, []int{0, 0, 2, 1, 2, 1}))
}
