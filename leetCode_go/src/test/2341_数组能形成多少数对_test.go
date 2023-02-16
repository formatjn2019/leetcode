package test

import (
	"fmt"
	"src/problems"
	"testing"
)

func TestNumberOfPairs(t *testing.T) {
	fmt.Printf("problems.NumberOfPairs([]int{1, 3, 2, 1, 3, 2, 2}): %v\n", problems.NumberOfPairs([]int{1, 3, 2, 1, 3, 2, 2}))
	fmt.Printf("problems.NumberOfPairs([]int{1, 1}): %v\n", problems.NumberOfPairs([]int{1, 1}))
	fmt.Printf("problems.NumberOfPairs([]int{0}): %v\n", problems.NumberOfPairs([]int{0}))
}
