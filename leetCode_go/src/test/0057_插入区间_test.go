package test

import (
	"fmt"
	"src/problems"
	"src/tools"
	"testing"
)

func TestInsert(t *testing.T) {
	fmt.Println(problems.Insert(tools.ParseArr("[[1,3],[6,9]]"), []int{2, 5}))
	fmt.Println(problems.Insert(tools.ParseArr("[[1,5]]"), []int{0, 3}))
	fmt.Println(problems.Insert(tools.ParseArr("[[3,5],[12,15]]"), []int{6, 6}))
}
