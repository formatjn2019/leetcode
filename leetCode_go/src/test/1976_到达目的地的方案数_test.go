package test

import (
	"src/problems"
	"src/tools"
	"testing"
)

func TestCountPaths(t *testing.T) {
	println(problems.CountPaths(7, tools.ParseArr("[[0,6,7],[0,1,2],[1,2,3],[1,3,3],[6,3,3],[3,5,1],[6,5,1],[2,5,1],[0,4,5],[4,6,2]]")))
	println(problems.CountPaths(2, tools.ParseArr("[[1,0,10]]")))
}
