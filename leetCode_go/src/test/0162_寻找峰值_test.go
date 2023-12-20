package test

import (
	"src/problems"
	"testing"
)

func TestFindPeakElement(t *testing.T) {
	println(problems.FindPeakElement([]int{1, 2, 3, 1}))
	println(problems.FindPeakElement([]int{1, 2, 1, 3, 5, 6, 4}))
}
