package test

import (
	"src/problems"
	"testing"
)

func TestMaxAbsoluteSum(t *testing.T) {
	println(problems.MaxAbsoluteSum([]int{1, -3, 2, 3, -4}))
	println(problems.MaxAbsoluteSum([]int{2, -5, 1, -4, 3, -2}))
}
