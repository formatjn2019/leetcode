package test

import (
	"src/problems"
	"testing"
)

func TestMiceAndCheese(t *testing.T) {
	println(problems.MiceAndCheese([]int{1, 4, 4, 6, 4}, []int{6, 5, 3, 6, 1}, 1))
	println(problems.MiceAndCheese([]int{4, 1, 5, 3, 3}, []int{3, 4, 4, 5, 2}, 3))
	println(problems.MiceAndCheese([]int{1, 1, 3, 4}, []int{4, 4, 1, 1}, 2))
	println(problems.MiceAndCheese([]int{1, 1}, []int{1, 1}, 2))
	//problems.MiceAndCheese([]int{}, []int{}, 2)
}
