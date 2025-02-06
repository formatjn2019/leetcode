package test

import (
	"fmt"
	"src/problems"
	"testing"
)

func TestPermuteUnique(t *testing.T) {
	fmt.Println(problems.PermuteUnique([]int{1, 1, 2}))
	fmt.Println(problems.PermuteUnique([]int{1, 3, 2}))
}
