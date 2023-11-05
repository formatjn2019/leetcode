package test

import (
	"src/problems"
	"testing"
)

func TestMissingElement(t *testing.T) {
	println(problems.MissingElement([]int{4, 7, 9, 10}, 1))
	println(problems.MissingElement([]int{4, 7, 9, 10}, 3))
	println(problems.MissingElement([]int{1, 2, 4}, 3))
}
