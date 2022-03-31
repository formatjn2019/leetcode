package test

import (
	"fmt"
	"src/problems"
	"src/tools"
	"testing"
)

func TestHighestRankedKItems(t *testing.T){
	fmt.Println(problems.HighestRankedKItems(tools.ParseArr("[[1,2,0,1],[1,3,0,1],[0,2,5,1]]"), []int{2, 5}, []int{0, 0}, 3))
	fmt.Println(problems.HighestRankedKItems(tools.ParseArr("[[1,2,0,1],[1,3,3,1],[0,2,5,1]]"), []int{2, 3}, []int{2, 3}, 2))
}

