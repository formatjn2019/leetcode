package test

import (
	"src/problems"
	"src/tools"
	"testing"
)

func TestFindPeakGrid(t *testing.T) {
	problems.FindPeakGrid(tools.ParseArr("[[10,30,40,50,20],[1,3,2,500,4]]"))
}
