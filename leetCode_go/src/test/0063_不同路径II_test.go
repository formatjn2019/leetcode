package test

import (
	"src/problems"
	"src/tools"
	"testing"
)

func TestUniquePathsWithObstacles(t *testing.T) {
	println(problems.UniquePathsWithObstacles(tools.ParseArr("[[0,0,0],[0,1,0],[0,0,0]]")))
	println(problems.UniquePathsWithObstacles(tools.ParseArr("[[0,1],[0,0]]")))
}
