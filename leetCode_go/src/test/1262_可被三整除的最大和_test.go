package test

import (
	"src/problems"
	"testing"
)

func TestMaxSumDivThree(t *testing.T) {
	println(problems.MaxSumDivThree([]int{3, 6, 5, 1, 8}))
	println(problems.MaxSumDivThree([]int{4}))
	println(problems.MaxSumDivThree([]int{1, 2, 3, 4, 4}))
}
