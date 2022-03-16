package test

import (
	"src/problems"
	"testing"
)

func TestCountMaxOrSubsets(t *testing.T) {
	println(problems.CountMaxOrSubsets([]int{3, 1}))
	println(problems.CountMaxOrSubsets([]int{2, 2, 2}))
}
