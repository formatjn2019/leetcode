package test

import (
	"src/problems"
	"src/tools"
	"testing"
)

func TestLcaDeepestLeaves(t *testing.T) {
	println(problems.LcaDeepestLeaves(tools.ParseTree("[3,5,1,6,2,0,8,null,null,7,4]")).Val)
	println(problems.LcaDeepestLeaves(tools.ParseTree("[1]")).Val)
	println(problems.LcaDeepestLeaves(tools.ParseTree("[0,1,3,null,2]")).Val)
}
