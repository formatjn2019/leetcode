package test

import (
	"src/problems"
	"testing"
)

func TestMinScoreTriangulation(t *testing.T) {
	println(problems.MinScoreTriangulation([]int{2, 1, 4, 4}))
	println(problems.MinScoreTriangulation([]int{2, 3, 2, 4}))
	println(problems.MinScoreTriangulation([]int{1, 2, 3}))
	println(problems.MinScoreTriangulation([]int{3, 7, 4, 5}))
	println(problems.MinScoreTriangulation([]int{1, 3, 1, 4, 1, 5}))
}
