package test

import (
	"src/problems"
	"src/tools"
	"testing"
)

func TestLargestBSTSubtree(t *testing.T) {
	//tree := tools.ParseTree("[3,2,4,null,null,1]")
	tree := tools.ParseTree("[4,2,7,2,3,5,null,2,null,null,null,null,null,1]")
	//tree := tools.ParseTree("[10,5,15,1,8,null,7]")
	println(problems.LargestBSTSubtree(tree))
}
