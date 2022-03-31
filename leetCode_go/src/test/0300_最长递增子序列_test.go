package test

import (
	"src/problems"
	"testing"
)

func TestLengthOfLIS(t *testing.T) {
	println(problems.LengthOfLIS([]int{10, 9, 2, 5, 3, 7, 101, 18}))
	println(problems.LengthOfLIS([]int{1,3,6,7,9,4,10,5,6}))
}
