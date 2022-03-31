package test

import (
	"fmt"
	"src/problems"
	"testing"
)


func TestFindDuplicates(t *testing.T){
	fmt.Println(problems.FindDuplicates([]int{1}))
	fmt.Println(problems.FindDuplicates([]int{1, 1, 2}))
	fmt.Println(problems.FindDuplicates([]int{4, 3, 2, 7, 8, 2, 3, 1}))
}