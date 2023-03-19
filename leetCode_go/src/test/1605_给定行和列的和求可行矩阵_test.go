package test

import (
	"src/problems"
	"testing"
)

func TestRestoreMatrix(t *testing.T) {
	problems.RestoreMatrix([]int{3, 8}, []int{4, 7})
	problems.RestoreMatrix([]int{5, 7, 10}, []int{8, 6, 8})
	problems.RestoreMatrix([]int{14, 9}, []int{6, 9, 8})
	problems.RestoreMatrix([]int{1, 0}, []int{1})
	problems.RestoreMatrix([]int{0}, []int{0})
}
