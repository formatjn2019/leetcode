package test

import (
	"fmt"
	"src/problems"
	"testing"
)

func TestFindSolution(t *testing.T) {
	fmt.Printf("problems.FindSolution(func(i1, i2 int) int { return i1 + i2 }, 5): %v\n", problems.FindSolution(func(i1, i2 int) int { return i1 + i2 }, 5))
	fmt.Printf("problems.FindSolution(func(i1, i2 int) int { return i1 * i2 }, 5): %v\n", problems.FindSolution(func(i1, i2 int) int { return i1 * i2 }, 5))
}
