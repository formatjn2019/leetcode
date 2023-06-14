package test

import (
	"src/problems"
	"testing"
)

func TestNumTimesAllBlue(t *testing.T) {
	println(problems.NumTimesAllBlue([]int{3, 2, 4, 1, 5}))
	println(problems.NumTimesAllBlue([]int{4, 1, 2, 3}))
	//problems.NumTimesAllBlue([]int{})
}
