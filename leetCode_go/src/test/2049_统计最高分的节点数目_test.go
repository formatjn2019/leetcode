package test

import (
	"src/problems"
	"testing"
)

func TestCountHighestScoreNodes(t *testing.T) {
	problems.CountHighestScoreNodes([]int{-1, 2, 0, 2, 0})
	problems.CountHighestScoreNodes([]int{-1, 2, 0})
	problems.CountHighestScoreNodes([]int{-1, 6, 1, 0, 6, 4, 0})
}
