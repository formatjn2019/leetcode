package test

import (
	"fmt"
	"src/problems"
	"src/tools"
	"testing"
)

func TestMaxValue(t *testing.T) {
	fmt.Println(problems.MaxValue(tools.ParseArr("[[1,3,1],[1,5,1],[4,2,1]]")))
}
