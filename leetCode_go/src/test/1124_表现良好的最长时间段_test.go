package test

import (
	"fmt"
	"src/problems"
	"testing"
)

func TestLongestWPI(t *testing.T) {
	fmt.Printf("problems.LongestWPI([]int{9, 9, 6, 0, 6, 6, 9}): %v\n", problems.LongestWPI([]int{9, 9, 6, 0, 6, 6, 9}))
	fmt.Printf("problems.LongestWPI([]int{6, 6, 6}): %v\n", problems.LongestWPI([]int{6, 6, 6}))
	fmt.Printf("problems.LongestWPI([]int{9, 8, 9, 6, 9}): %v\n", problems.LongestWPI([]int{9, 8, 9, 6, 9}))
	fmt.Printf("problems.LongestWPI([]int{9, 8, 9, 6, 6, 9}): %v\n", problems.LongestWPI([]int{9, 8, 9, 6, 6, 9}))
}
