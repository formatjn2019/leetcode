package test

import (
	"fmt"
	"src/problems"
	"testing"
)

func TestFindDisappearedNumbers(t *testing.T) {
	fmt.Println(problems.FindDisappearedNumbers([]int{4, 3, 2, 7, 8, 2, 3, 1}))
}