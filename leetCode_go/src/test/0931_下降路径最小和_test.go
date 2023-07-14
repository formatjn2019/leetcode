package test

import (
	"src/problems"
	"src/tools"
	"testing"
)

func TestMinFallingPathSum(t *testing.T) {
	println(problems.MinFallingPathSum(tools.ParseArr("[[2,1,3],[6,5,4],[7,8,9]]")))
	println(problems.MinFallingPathSum(tools.ParseArr("[[-19,57],[-40,-5]]")))
}
