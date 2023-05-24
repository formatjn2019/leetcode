package test

import (
	"fmt"
	"src/problems"
	"testing"
)

func TestAddNegabinary(t *testing.T) {
	println(fmt.Sprint(problems.AddNegabinary([]int{1, 0, 1}, []int{1, 0, 1})) == "[1 1 1 1 0]")
	println(fmt.Sprint(problems.AddNegabinary([]int{1}, []int{1, 0, 1})) == "[1 1 0 1 0]")
	println(fmt.Sprint(problems.AddNegabinary([]int{1}, []int{1, 1})) == "[0]")
	println(fmt.Sprint(problems.AddNegabinary([]int{1}, []int{1})) == "[1 1 0]")
	println(fmt.Sprint(problems.AddNegabinary([]int{1, 1, 1, 1, 1}, []int{1, 0, 1})) == "[1 0 0 0 0]")
	println(fmt.Sprint(problems.AddNegabinary([]int{0}, []int{0})) == "[0]")
	println(fmt.Sprint(problems.AddNegabinary([]int{1}, []int{0})) == "[1]")
}
