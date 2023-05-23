package test

import (
	"src/problems"
	"testing"
)

func TestLargestValsFromLabels(t *testing.T) {
	println(problems.LargestValsFromLabels([]int{5, 4, 3, 2, 1}, []int{1, 1, 2, 2, 3}, 3, 1))
	println(problems.LargestValsFromLabels([]int{5, 4, 3, 2, 1}, []int{1, 3, 3, 3, 2}, 3, 2))
	println(problems.LargestValsFromLabels([]int{9, 8, 8, 7, 6}, []int{0, 0, 0, 1, 1}, 3, 1))
}
