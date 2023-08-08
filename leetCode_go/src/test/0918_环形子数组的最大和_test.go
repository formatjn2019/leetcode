package test

import (
	"src/problems"
	"testing"
)

func TestMaxSubarraySumCircular(t *testing.T) {
	println(problems.MaxSubarraySumCircular([]int{1, -2, 3, -2}))
	println(problems.MaxSubarraySumCircular([]int{-3, -2, -3}))
}
