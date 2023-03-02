package test

import (
	"src/problems"
	"src/tools"
	"testing"
)

func TestLargestLocal(t *testing.T) {
	problems.LargestLocal(tools.ParseArr("[[9,9,8,1],[5,6,2,6],[8,2,6,4],[6,2,2,2]]"))
	problems.LargestLocal(tools.ParseArr("[[1,1,1,1,1],[1,1,1,1,1],[1,1,2,1,1],[1,1,1,1,1],[1,1,1,1,1]]"))
}
