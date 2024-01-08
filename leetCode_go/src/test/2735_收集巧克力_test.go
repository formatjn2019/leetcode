package test

import (
	"src/problems"
	"testing"
)

func TestMinCost(t *testing.T) {
	println(problems.MinCost([]int{15, 150, 56, 69, 214, 203}, 42))
	println(problems.MinCost([]int{20, 1, 15}, 5))
}
