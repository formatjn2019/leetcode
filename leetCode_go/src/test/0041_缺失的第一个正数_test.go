package test

import (
	"src/problems"
	"testing"
)

func TestFirstMissingPositive(t *testing.T) {
	println(problems.FirstMissingPositive([]int{1, 2, 0}))
	println(problems.FirstMissingPositive([]int{7, 8, 9, 11, 12}))
	println(problems.FirstMissingPositive([]int{3, 4, -1, 1}))
	println(problems.FirstMissingPositive([]int{1, 1}))
}
