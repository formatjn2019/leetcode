package test

import (
	"src/problems"
	"src/tools"
	"testing"
)

func TestShortestPathBinaryMatrix(t *testing.T) {
	println(problems.ShortestPathBinaryMatrix(tools.ParseArr("[[0,1],[1,0]]")))
	println(problems.ShortestPathBinaryMatrix(tools.ParseArr("[[0,0,0],[1,1,0],[1,1,0]]")))
	println(problems.ShortestPathBinaryMatrix(tools.ParseArr("[[1,0,0],[1,1,0],[1,1,0]]")))
}
