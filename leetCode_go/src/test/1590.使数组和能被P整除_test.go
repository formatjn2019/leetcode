package test

import (
	"src/problems"
	"testing"
)

func TestMinSubarray(t *testing.T) {
	problems.MinSubarray([]int{6, 3, 5, 2}, 9)
	problems.MinSubarray([]int{8, 32, 31, 18, 34, 20, 21, 13, 1, 27, 23, 22, 11, 15, 30, 4, 2}, 148)
	problems.MinSubarray([]int{3, 1, 4, 2}, 6)
	problems.MinSubarray([]int{1, 2, 3}, 6)
	problems.MinSubarray([]int{1, 2, 3}, 7)
	problems.MinSubarray([]int{1000000000, 1000000000, 1000000000}, 3)
	problems.MinSubarray([]int{5, 2, 4}, 10)
}
