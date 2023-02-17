package test

import (
	"src/problems"
	"src/tools"
	"testing"
)

func TestLargest1BorderedSquare(t *testing.T) {
	problems.Largest1BorderedSquare(tools.ParseArr("[[1,1,1],[1,0,1],[1,1,1]]"))
	problems.Largest1BorderedSquare(tools.ParseArr("[[1,1,0,0]]"))
	problems.Largest1BorderedSquare(tools.ParseArr("[[0]]"))
}
