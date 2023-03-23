package test

import (
	"src/problems"
	"testing"
)

func TestCheckArithmeticSubarrays(t *testing.T) {
	problems.CheckArithmeticSubarrays([]int{4, 6, 5, 9, 3, 7}, []int{0, 0, 2}, []int{2, 3, 5})
	problems.CheckArithmeticSubarrays([]int{-12, -9, -3, -12, -6, 15, 20, -25, -20, -15, -10}, []int{0, 1, 6, 4, 8, 7}, []int{4, 4, 9, 7, 9, 10})
}
