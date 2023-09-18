package test

import (
	"src/problems"
	"src/tools"
	"testing"
)

func TestRob(t *testing.T) {
	println(problems.Rob(tools.ParseTree("[3,2,3,null,3,null,1]")))
	//problems.Rob(tools.ParseTree("[3,4,5,1,3,null,1]"))
}
