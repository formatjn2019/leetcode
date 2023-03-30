package test

import (
	"src/problems"
	"src/tools"
	"testing"
)

func TestMaxWidthOfVerticalArea(t *testing.T) {
	println(problems.MaxWidthOfVerticalArea(tools.ParseArr("[[8,7],[9,9],[7,4],[9,7]]")))
	println(problems.MaxWidthOfVerticalArea(tools.ParseArr("[[3,1],[9,0],[1,0],[1,4],[5,3],[8,8]]")))
}
