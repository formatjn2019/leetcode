package test

import (
	"src/problems"
	"src/tools"
	"testing"
)

func TestMinimumFuelCost(t *testing.T) {
	problems.MinimumFuelCost(tools.ParseArr("[[0,1],[0,2],[0,3]]"), 5)
	problems.MinimumFuelCost(tools.ParseArr("[[3,1],[3,2],[1,0],[0,4],[0,5],[4,6]]"), 2)
	problems.MinimumFuelCost([][]int{}, 1)
}
