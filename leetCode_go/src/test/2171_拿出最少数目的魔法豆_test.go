package test

import (
	"src/problems"
	"testing"
)

func TestMinimumRemoval(t *testing.T) {
	println(problems.MinimumRemoval([]int{4, 1, 6, 5}))
	println(problems.MinimumRemoval([]int{2, 10, 3, 2}))
}
