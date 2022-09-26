package test

import (
	"fmt"
	"src/problems"
	"testing"
)

func TestMissingTwo(t *testing.T) {
	fmt.Printf("problems.MissingTwo([]int{1, 3}): %v\n", problems.MissingTwo([]int{1, 3}))
	fmt.Printf("problems.MissingTwo([]int{2, 4}): %v\n", problems.MissingTwo([]int{2, 4}))
}
