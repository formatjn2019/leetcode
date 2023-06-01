package test

import (
	"src/problems"
	"testing"
)

func TestMaximumTastiness(t *testing.T) {
	println(problems.MaximumTastiness([]int{34, 116, 83, 15, 150, 56, 69, 42, 26}, 6))
	println(problems.MaximumTastiness([]int{13, 5, 1, 8, 21, 2}, 3))
	println(problems.MaximumTastiness([]int{1, 3, 1}, 2))
	println(problems.MaximumTastiness([]int{7, 7, 7, 7}, 2))
	println(problems.MaximumTastiness([]int{7, 7, 7, 8}, 3))

}
