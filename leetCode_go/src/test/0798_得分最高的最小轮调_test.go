package test

import (
	"src/problems"
	"testing"
)

func TestBestRotation(t *testing.T) {
	println(problems.BestRotation([]int{2, 3, 1, 4, 0}))
	println(problems.BestRotation([]int{1, 3, 0, 2, 4}))
}
