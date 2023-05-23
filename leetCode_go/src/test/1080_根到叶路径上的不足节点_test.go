package test

import (
	"src/problems"
	"src/tools"
	"testing"
)

func TestSufficientSubset(t *testing.T) {
	root := problems.SufficientSubset(tools.ParseTree("[5,4,8,11,null,17,4,7,1,null,null,5,3]"), 22)
	//root := problems.SufficientSubset(tools.ParseTree("[1,2,3,4,-99,-99,7,8,9,-99,-99,12,13,-99,14]"), 1)
	tools.ShowTree(root)

}
