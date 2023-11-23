package test

import (
	"src/problems"
	"src/tools"
	"testing"
)

func TestMinPathCost(t *testing.T) {
	problems.MinPathCost(tools.ParseArr("[[5,1,2],[4,0,3]]"), tools.ParseArr("[[12,10,15],[20,23,8],[21,7,1],[8,1,13],[9,10,25],[5,3,2]]"))
	problems.MinPathCost(tools.ParseArr("[[5,3],[4,0],[2,1]]"), tools.ParseArr("[[9,8],[1,5],[10,12],[18,6],[2,4],[14,3]]"))
}
