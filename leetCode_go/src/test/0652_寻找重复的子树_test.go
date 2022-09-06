package test

import (
	"fmt"
	"src/problems"
	"src/tools"
	"testing"
)

func TestFindDuplicateSubtrees(t *testing.T) {
	fmt.Printf(": %v\n", problems.FindDuplicateSubtrees(tools.ParseTree("[2,1,3,2,null,1,null,null,null,null,null,2,null]")))
	// fmt.Printf("problems.FindDuplicateSubtrees(tools.ParseTree(\"[1,2,3,4,null,2,4,null,null,4]\")): %v\n", problems.FindDuplicateSubtrees(tools.ParseTree("[1,2,3,4,null,2,4,null,null,4]")))
}
