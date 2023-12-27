package test

import (
	"src/problems"
	"testing"
)

func TestMinStoneSum(t *testing.T) {
	problems.MinStoneSum([]int{5, 4, 9}, 2)
	println(problems.MinStoneSum([]int{4, 3, 6, 7}, 3))
}
