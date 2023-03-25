package test

import (
	"src/problems"
	"testing"
)

func TestFindLengthOfShortestSubarray(t *testing.T) {
	println(problems.FindLengthOfShortestSubarray([]int{1, 2, 3, 10, 0, 7, 8, 9}))
	println(problems.FindLengthOfShortestSubarray([]int{0}))
	println(problems.FindLengthOfShortestSubarray([]int{1, 2, 3}))
	println(problems.FindLengthOfShortestSubarray([]int{1, 2, 3, 10, 4, 2, 3, 5}))
	println(problems.FindLengthOfShortestSubarray([]int{5, 4, 3, 2, 1}))
}
