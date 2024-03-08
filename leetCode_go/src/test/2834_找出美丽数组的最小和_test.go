package test

import (
	"src/problems"
	"testing"
)

func TestMinimumPossibleSum(t *testing.T) {
	println(problems.MinimumPossibleSum(9, 9))
	println(problems.MinimumPossibleSum(8, 9))
	println(problems.MinimumPossibleSum(7, 9))
	println(problems.MinimumPossibleSum(2, 3))
	println(problems.MinimumPossibleSum(3, 3))
	println(problems.MinimumPossibleSum(1, 1))
}
