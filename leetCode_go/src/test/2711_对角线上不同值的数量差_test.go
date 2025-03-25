package test

import (
	"src/problems"
	"src/tools"
	"testing"
)

func TestDifferenceOfDistinctValues(t *testing.T) {
	tools.ShowArray(problems.DifferenceOfDistinctValues(tools.ParseArr("[[5,50,39,37],[2,19,36,26],[27,3,23,10],[20,33,8,39]]")))
	tools.ShowArray(problems.DifferenceOfDistinctValues(tools.ParseArr("[[1,2,3],[3,1,5],[3,2,1]]")))
}
