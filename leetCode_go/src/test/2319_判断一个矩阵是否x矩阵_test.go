package test

import (
	"fmt"
	"src/problems"
	"src/tools"
	"testing"
)

func TestCheckXMatrix(t *testing.T) {
	fmt.Printf("problems.CheckXMatrix(tools.ParseArr(\"[[2,0,0,1],[0,3,1,0],[0,5,2,0],[4,0,0,2]]\")): %v\n", problems.CheckXMatrix(tools.ParseArr("[[2,0,0,1],[0,3,1,0],[0,5,2,0],[4,0,0,2]]")))
	fmt.Printf("problems.CheckXMatrix(tools.ParseArr(\"[[5,7,0],[0,3,1],[0,5,0]]\")): %v\n", problems.CheckXMatrix(tools.ParseArr("[[5,7,0],[0,3,1],[0,5,0]]")))
}
