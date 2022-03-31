package test

import (
	"src/problems"
	"src/tools"
	"testing"
)

func TestFindMinHeightTrees(t *testing.T){
	problems.FindMinHeightTrees(6,tools.ParseArr("[[3,0],[3,1],[3,2],[3,4],[5,4]]"))
	problems.FindMinHeightTrees(1,tools.ParseArr("[]"))
	problems.FindMinHeightTrees(7,tools.ParseArr("[[0,1],[1,2],[1,3],[2,4],[3,5],[4,6]]"))
}