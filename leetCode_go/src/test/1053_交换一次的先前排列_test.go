package test

import (
	"fmt"
	"src/problems"
	"testing"
)

func TestPrevPermOpt1(t *testing.T) {
	fmt.Println(problems.PrevPermOpt1([]int{3, 2, 1}))
	fmt.Println(problems.PrevPermOpt1([]int{1, 1, 5}))
	fmt.Println(problems.PrevPermOpt1([]int{1, 9, 4, 6, 7}))
	//problems.PrevPermOpt1([]int{3, 2, 1})
}
