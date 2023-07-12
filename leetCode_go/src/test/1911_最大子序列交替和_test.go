package test

import (
	"src/problems"
	"testing"
)

func TestMaxAlternatingSum(t *testing.T) {
	problems.MaxAlternatingSum([]int{4, 2, 5, 3})
	problems.MaxAlternatingSum([]int{5, 6, 7, 8})
	problems.MaxAlternatingSum([]int{6, 2, 1, 2, 4, 5})
}
