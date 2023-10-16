package test

import (
	"src/problems"
	"testing"
)

func TestSumDistance(t *testing.T) {
	println(problems.SumDistance([]int{-2, 0, 2}, "RLL", 3))
	println(problems.SumDistance([]int{1, 0}, "RL", 2))
}
