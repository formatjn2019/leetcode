package test

import (
	"fmt"
	"src/problems"
	"src/tools"
	"testing"
)

func TestEvaluateTree(t *testing.T) {
	fmt.Printf("problems.EvaluateTree(tools.ParseTree(\"[2,1,3,null,null,0,1]\")): %v\n", problems.EvaluateTree(tools.ParseTree("[2,1,3,null,null,0,1]")))
	fmt.Printf("problems.EvaluateTree(tools.ParseTree(\"[0]\")): %v\n", problems.EvaluateTree(tools.ParseTree("[0]")))
}
