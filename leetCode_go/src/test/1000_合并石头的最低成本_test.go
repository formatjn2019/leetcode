package test

import (
	"src/problems"
	"testing"
)

func TestMergeStones(t *testing.T) {
	println(problems.MergeStones([]int{3, 2, 4, 1}, 2))
	println(problems.MergeStones([]int{3, 2, 4, 1}, 3))
	println(problems.MergeStones([]int{3, 5, 1, 2, 6}, 3))
}
